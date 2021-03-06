package com.haiziwang.commodity.strategy.table;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.haiziwang.commodity.annotation.ColumnAnnotation;
import com.haiziwang.commodity.common.CanalRow;
import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.cpp.response.Brand;
import com.haiziwang.commodity.cpp.response.NavEntryDdo;
import com.haiziwang.commodity.cpp.service.CppBrandService;
import com.haiziwang.commodity.cpp.service.CppCategaryService;
import com.haiziwang.commodity.enums.TableTypeEnum;
import com.haiziwang.commodity.model.dto.CategaryDTO;
import com.haiziwang.commodity.model.dto.ClothingDTO;
import com.haiziwang.commodity.model.dto.EsCommodityDTO;
import com.haiziwang.commodity.model.dto.MaternalChildDTO;
import com.haiziwang.commodity.utils.PerformanceUtil;
import com.haiziwang.commodity.utils.SpringUtil;
import com.haiziwang.commodity.utils.TMQMessageUtil;
import com.haiziwang.commodity.utils.TableUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CommonStrategyImpl {

    private static final Logger logger = LoggerFactory.getLogger(CommonStrategyImpl.class);

    private static final int SPU_ID_LENGTH = 10;

    protected static final ApplicationContext context = SpringUtil.getApplicationContext();

    private static AtomicLong printCnt = new AtomicLong(0);

//    private List<EsCommodityDTO> gEsBoList = new ArrayList<>();

    /**
     * 构造spuId
     *
     * @param skuId
     * @return
     */
    public static String createSpuId(Long skuId, String prefix) {
        StringBuffer sb = new StringBuffer(prefix);
        if (skuId != null && skuId > 0) {
            BigDecimal skuIdLength = new BigDecimal(String.valueOf(skuId).length()).setScale(0, BigDecimal.ROUND_HALF_UP);
            BigDecimal maxLength = new BigDecimal(String.valueOf(SPU_ID_LENGTH));
            int supplementLenth = maxLength.subtract(skuIdLength).intValue();
            IntStream.range(0, supplementLenth).forEach(i -> sb.append("0"));
            sb.append(String.valueOf(skuId));
        }
        return sb.toString();
    }

    /**
     * 获取需要转化的字段：通过反射获取自定义注解实现
     *
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> List<String> getColumnsToChange(Class<T> clazz) {
        PerformanceUtil invokePer= new PerformanceUtil();
        List<String> columns = new ArrayList<>();
        try {
            Field[] fields = clazz.getDeclaredFields();
            columns = Arrays.stream(fields).filter(field -> {
                ColumnAnnotation columnAnnotation = field.getAnnotation(ColumnAnnotation.class);
                if (columnAnnotation != null) {
                    field.setAccessible(true);
                    return columnAnnotation.toChange();
                }
                return false;
            }).map(Field::getName).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug("getColumnsToChange耗时：[{}]", invokePer.PERFORM_TIME());
        return columns;
    }

    protected Map<String, String> getUpdatedColumns(CanalRow canalRow, List<String> needUpdateColumns) {
        boolean needChange = false;
        Map<String, String> columnMap = new HashMap<>(100);
        List<CanalEntry.Column> columns = canalRow.getColumns();
        for (CanalEntry.Column column : columns) {
            String columnName = column.getName();
            String value = column.getValue();
            if (column.getUpdated() && needUpdateColumns.contains(columnName)) {
                if (!needChange) {
                    needChange = true;
                }
                columnMap.put(columnName, value);
            }
        }
        canalRow.setNeedChange(needChange);
        return columnMap;
    }

    /**
     * 拷贝实体
     *
     * @param object
     * @param columnName
     * @param value
     * @return
     */
    protected Object copyValue(Object object, String columnName, String value) {
        try {
            Field[] skuFields = object.getClass().getDeclaredFields();
            for (Field field : skuFields) {
                field.setAccessible(true);
                String name = field.getName();
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                String type = field.getGenericType().toString();
                if (value != null && name.equalsIgnoreCase(columnName)) {
                    logger.debug("column[{}]  type[{}] value[{}]", columnName, type, value);
                    if (type.equals("class java.lang.String")) {
                        Method m = object.getClass().getDeclaredMethod("get" + name);
                        field.set(object, value);
                        break;
                    } else if (type.equals("class java.lang.Integer")) {
                        field.set(object, Integer.valueOf(value));
                        break;
                    } else if (type.equals("class java.lang.Boolean")) {
                        field.set(object, Boolean.valueOf(value));
                        break;
                    } else if (type.equals("class java.lang.Long")) {
                        //处理时间戳类型
                        if (value.contains("-")) {
                            if ("0000-00-00 00:00:00".equals(value)) {
                                LocalDateTime dateTime = LocalDateTime.of(2000, 1, 1, 0, 0, 0);
                                Long initDateTime = dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
                                field.set(object, initDateTime);
                            } else {
                                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                Date date = format.parse(value);
                                field.set(object, date.getTime());
                            }
                        } else {
                            field.set(object, Long.valueOf(value));
                        }
                        break;
                    } else if (type.equals("class java.util.Date")) {
                        if ("0000-00-00 00:00:00".equals(value)) {
                            LocalDateTime dateTime = LocalDateTime.of(2000, 1, 1, 0, 0, 0);
                            Long initDateTime = dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
                            field.set(object, new Date(initDateTime));
                        } else {
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date = format.parse(value);
                            field.set(object, new Date(date.getTime()));
                        }
                        break;
                    } else if (type.equals("class java.time.LocalDateTime")) {
                        if ("0000-00-00 00:00:00".equals(value)) {
                            LocalDateTime dateTime = LocalDateTime.of(2000, 1, 1, 0, 0, 0);
                            Long initDateTime = dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
                            field.set(object, new Date(initDateTime));
                        }
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        field.set(object, LocalDateTime.parse(value, dateTimeFormatter));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 将CanalRow中CanalEntry.Column转化为具体PO
     *
     * @param canalRow
     * @param object
     * @return
     */
    protected Object getPOByCanalRow(CanalRow canalRow, Object object) {
        PerformanceUtil invokePer= new PerformanceUtil();
        canalRow.setNeedChange(true);
        if (object != null) {
            List<CanalEntry.Column> columns = canalRow.getColumns();
            for (CanalEntry.Column column : columns) {
                String columnName = column.getName();
                String value = column.getValue();
                if (column.getUpdated()) {
                    //特殊处理的字段
                    logger.debug("table [{}] column [{}] 更新为：[{}]", columnName, value);
                    object = specialHandler(object, columnName, value);
                }
                object = copyValue(object, columnName, value);
            }
        }
        logger.debug("CanalRow转化Object耗时：[{}]", invokePer.PERFORM_TIME());
        return object;
    }

    protected EsCommodityDTO setESKey(CanalEntry.EventType eventType, String tableName, EsCommodityDTO esDTO) {
        tableName = TableUtil.getPrefixTableName(tableName);
        if (eventType == CanalEntry.EventType.DELETE) {
            esDTO.setEagleType("update");
            // 主档或区域删除，直接将商品状态标记删除
            if (tableName == TableTypeEnum.T_SKU.getMsgId()) {
                esDTO.setFskustate(0); // 设置sku状态为删除
            } else if (tableName == TableTypeEnum.T_SPU.getMsgId()) {
                esDTO.setFspustate(0); // 设置spu状态为删除
            }
        } else if (eventType == CanalEntry.EventType.INSERT || eventType == CanalEntry.EventType.UPDATE) {
            esDTO.setEagleType("upsert");
        } else {
            logger.warn("eventType:{} ignore.", eventType);
            return null;
        }

        // ES主键校验
        if (esDTO.getFspuid() == null || "".equals(esDTO.getFspuid())) {
            logger.warn("Fspuid:{} invalid.", esDTO.getFspuid());
            return null;
        }
        if (esDTO.getFskuid() == null || esDTO.getFskuid() < -1) {
            logger.warn("Fskuid:{} invalid.", esDTO.getFskuid());
            return null;
        }
        if (esDTO.getFentityid() == null || esDTO.getFentityid() < -1) {
            logger.warn("Fentityid:{} invalid.", esDTO.getFentityid());
            return null;
        }

        esDTO.setEagleTenantId(String.valueOf(esDTO.getFplatformid()));
        esDTO.setPkey(esDTO.getFspuid() + "_" + esDTO.getFskuid() + "_" + esDTO.getFentityid()
        );
        return esDTO;
    }

    public EsCommodityDTO initAllArea(EsCommodityDTO baseArea, boolean initSkuInfo, boolean initOtherInfo) {
        if (initSkuInfo) {
            baseArea.setFpackinfolist(new ArrayList<>());
            baseArea.setFClothingObject(new ClothingDTO());
//            baseArea.setFspuchildrenids(new ArrayList<>());
            baseArea.setFskubindlist(new ArrayList<>());
            baseArea.setFMaternalChildObject(new MaternalChildDTO());
            baseArea.setFGlobalObject(new Object());

            baseArea.setFskuproperty(new ArrayList<>());
            baseArea.setFskuid(-1L);
            baseArea.setFskuextcode("");
            baseArea.setFskulocalcode("");
            baseArea.setFgoodsno("");
            baseArea.setFskustate(3);
            baseArea.setFskumainurl("");
            baseArea.setFskuerpreferprice(0);
            baseArea.setFskusaleattr("");
            baseArea.setFskuunit("");
            baseArea.setFskuunitcost(0);
            baseArea.setFskuaddtime(new Date().getTime());
            baseArea.setFskulastupdatetime(new Date().getTime());


        } else if (initOtherInfo) {
            baseArea.setFpackinfolist(new ArrayList<>());
            baseArea.setFClothingObject(new ClothingDTO());
            baseArea.setFspuchildrenids(new ArrayList<>());
            baseArea.setFskubindlist(new ArrayList<>());
            baseArea.setFMaternalChildObject(new MaternalChildDTO());
            baseArea.setFarealabelidlist(new ArrayList<>());
        }
        // 默认构建一条 entityId = -1的记录作为主档信息查询使用，满足宽表可以查询主档逻辑
        baseArea.setFentityid(-1);
        baseArea.setFskuareaprice(0);
        baseArea.setFworkstatecode("");
        baseArea.setFincatalog(0);
        baseArea.setFcirculationmodecode("");
        baseArea.setFskuareaproperty(new ArrayList<>());
        baseArea.setFskuareaaddtime(new Date().getTime());
        baseArea.setFskuarealastupdatetime(new Date().getTime());
        baseArea.setFstoreid("");
        baseArea.setFskuareafirstpublishtime(new Date().getTime());
        baseArea.setFsaleslabelid("");
        baseArea.setFarealabelidlist(new ArrayList<>());
        return baseArea;
    }

    protected EsCommodityDTO initOtherInfo(EsCommodityDTO esCommodityDTO) {
        esCommodityDTO.setFpackinfolist(new ArrayList<>());
        esCommodityDTO.setFClothingObject(new ClothingDTO());
        esCommodityDTO.setFspuchildrenids(new ArrayList<>());
        esCommodityDTO.setFskubindlist(new ArrayList<>());
        esCommodityDTO.setFMaternalChildObject(new MaternalChildDTO());
        esCommodityDTO.setFarealabelidlist(new ArrayList<>());
        return esCommodityDTO;
    }


    protected int pushToEs(List<EsCommodityDTO> gEsBoList, CanalRow row) {
        if (gEsBoList.size() > 0) {
            Iterator it = gEsBoList.iterator();
            while (it.hasNext()) {
                EsCommodityDTO esBo = (EsCommodityDTO) it.next();
                // 发送给Es
                PerformanceUtil performanceUtil = new PerformanceUtil();
                int ret = TMQMessageUtil.SendTMQ(esBo);
                logger.debug("TMQMessageUtil耗时：[{}]" , performanceUtil.PERFORM_TIME());
                if (ret != 0) {
                    logger.error("push es failed.tb[{}] operator[{}] spu[{}] sku[{}] entity[{}] code[{}], info:",
                            row.getTableName(), row.getEventType(), esBo.getFspuid(), esBo.getFskuid(), esBo.getFentityid(), ret, esBo.toString());
                } else {
                    // key log
                    logger.debug("push es success. tb[{}] operator[{}] spu[{}] sku[{}] entity[{}]",
                            row.getTableName(), row.getEventType(), esBo.getFspuid(), esBo.getFskuid(), esBo.getFentityid());
                }
                // 日志标识
                if (Constant.OPEN_LOG == 1) {
                    logger.info("push es success. >>>printCnt=[{}] tb=[{}] eventType=[{}] spuid=[{}] skuid=[{}] entityid=[{}] {}", printCnt, row.getTableName(), row.getEventType(), esBo.getFspuid(), esBo.getFskuid(), esBo.getFentityid(), esBo.toString());
                } else {
                    // 每操作200条数据打印Info级别的推ES的报文日志作为关键日志
                    if (printCnt.get() % 200 == 0) {
                        logger.info("push es success. >>>printCnt=[{}] tb=[{}] eventType=[{}] spuid=[{}] skuid=[{}] entityid=[{}]", printCnt, row.getTableName(), row.getEventType(), esBo.getFspuid(), esBo.getFskuid(), esBo.getFentityid());
                    } else {
                        logger.debug("push es success. >>>printCnt=[{}] tb=[{}] eventType=[{}] spuid=[{}] skuid=[{}] entityid=[{}] {}", printCnt, row.getTableName(), row.getEventType(), esBo.getFspuid(), esBo.getFskuid(), esBo.getFentityid(), esBo.toString());
                    }
                }

                if (printCnt.get() >= 90000000000L) {
                    printCnt.getAndSet(0);
                }
                printCnt.getAndIncrement();
            }
        }
        return gEsBoList.size();
    }

    /**
     * 特殊处理字段
     *
     * @param object
     * @param fieldName
     * @param value
     * @return
     */
    public Object specialHandler(Object object, String fieldName, Object value) {
        try {
            EsCommodityDTO es = (EsCommodityDTO) object;
            if ("Fcategoryid".equals(fieldName) && value != null) {
                //调用C++接口 1:线上
                List<CategaryDTO> categaryBos = getCppCategary(es, Long.valueOf(value.toString()));
                Method m = object.getClass().getDeclaredMethod("setFcategorylist", List.class);
                m.setAccessible(true);
                m.invoke(object, categaryBos);
            } else if ("Ferppubnavid".equals(fieldName) && value != null) {
                // 11:線下
                List<CategaryDTO> erpCategaryBos = new ArrayList<>();
                if (!"".equals(value.toString())) {
                    erpCategaryBos = getCppErpCategary(es, value.toString());
                }
                Method m = object.getClass().getDeclaredMethod("setFerpcategorylist", List.class);
                m.setAccessible(true);
                m.invoke(object, erpCategaryBos);
            } else if ("Fbrandid".equals(fieldName) && value != null) {
                String brandName = getBrandName(es, Long.valueOf(value.toString()));
                Method m = object.getClass().getDeclaredMethod("setFbrandname", String.class);
                m.setAccessible(true);
                m.invoke(object, brandName);
            } else if ("Ferpbrandid".equals(fieldName) && value != null) {
                String erpBrandName = "";
                if (!"".equals(value.toString())) {
                    erpBrandName = getErpBrandName(es, value.toString());
                }
                Method m = object.getClass().getDeclaredMethod("setFerpbrandname", String.class);
                m.setAccessible(true);
                m.invoke(object, erpBrandName);
            } else if ("Fspuproperty".equals(fieldName) && value != null) {
                Long tmpVal = Long.valueOf(String.valueOf(value));
                List<Integer> propertyList = setProperty(tmpVal);
                Method m = object.getClass().getDeclaredMethod("setFspuproperty", List.class);
                m.setAccessible(true);
                m.invoke(object, propertyList);
            } else if ("Fskuproperty".equals(fieldName) && value != null) {
                Long tmpVal = Long.valueOf(String.valueOf(value));
                List<Integer> propertyList = setProperty(tmpVal);
                Method m = object.getClass().getDeclaredMethod("setFskuproperty", List.class);
                m.setAccessible(true);
                m.invoke(object, propertyList);
            } else if ("Fskuareaproperty".equals(fieldName) && value != null) {
                Long tmpVal = Long.valueOf(String.valueOf(value));
                List<Integer> propertyList = setProperty(tmpVal);
                Method m = object.getClass().getDeclaredMethod("setFskuareaproperty", List.class);
                m.setAccessible(true);
                m.invoke(object, propertyList);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }

    public EsCommodityDTO handlerDateTime(EsCommodityDTO esCommodityDTO, String fieldName, Date value) {
        if (value != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String valueStr = format.format(value);
            if ("0000-00-00 00:00:00".equals(value)) {
                LocalDateTime dateTime = LocalDateTime.of(2000, 1, 1, 0, 0, 0);
                Long initDateTime = dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
                value = new Date(initDateTime);
            }
        }
        if ("Fspuaddtime".equals(fieldName) && value != null) {
            esCommodityDTO.setFspuaddtime(value.getTime());
        } else if ("Fspulastupdatetime".equals(fieldName) && value != null) {
            esCommodityDTO.setFspulastupdatetime(value.getTime());
        } else if ("Fskuaddtime".equals(fieldName) && value != null) {
            esCommodityDTO.setFskuaddtime(value.getTime());
        } else if ("Fskulastupdatetime".equals(fieldName) && value != null) {
            esCommodityDTO.setFskulastupdatetime(value.getTime());
        } else if ("Fskuareaaddtime".equals(fieldName) && value != null) {
            esCommodityDTO.setFskuareaaddtime(value.getTime());
        } else if ("Fskuarealastupdatetime".equals(fieldName) && value != null) {
            esCommodityDTO.setFskuarealastupdatetime(value.getTime());
        } else if ("Fskuareafirstpublishtime".equals(fieldName) && value != null) {
            esCommodityDTO.setFskuareafirstpublishtime(value.getTime());
        }
        return esCommodityDTO;
    }

    /**
     * 处理property
     *
     * @param value
     * @return
     */
    private List<Integer> setProperty(Long value) {
        List<Integer> propList = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            long bitVal = new Double(Math.pow(2, i)).longValue();
            if ((value & bitVal) == bitVal) {
                propList.add(i);
            }
        }
        return propList;
    }

    /**
     * 获取线上品牌名称
     * @param brandId
     * @return
     */
    private String getBrandName(EsCommodityDTO es, Long brandId) {
        String brandName = "";
        CppBrandService cppBrand = new CppBrandService();
        //获取线上品牌
        Brand brand = cppBrand.getBrandsById(es, brandId);
        if (brand != null) {
            brandName = brand.getBrandNameCn();
        }
        return brandName;
    }

    /**
     * 获取线下品牌名称
     * @param erpBrandId
     * @return
     */
    private String getErpBrandName(EsCommodityDTO es, String erpBrandId) {
        String erpBrandName = "";
        CppBrandService cppBrand = new CppBrandService();
        Brand brand = cppBrand.getErpBrand(es, erpBrandId);
        if (brand != null) {
            erpBrandName = brand.getErpBrandName();
        }
        return erpBrandName;
    }

    private List<CategaryDTO> getCppCategary(EsCommodityDTO es, Long classId) {
        CppCategaryService cppCategary = new CppCategaryService();
        Vector<NavEntryDdo> fullDdoList = cppCategary.queryPathByNavId(es, classId, 1L);
        List<CategaryDTO> categaryBos = convertNavEntryDdo(fullDdoList, false);
        return categaryBos;
    }

    private List<CategaryDTO> getCppErpCategary(EsCommodityDTO es, String erpclassId) {
        CppCategaryService cppCategary = new CppCategaryService();
        Vector<NavEntryDdo> fullDdoList = cppCategary.queryPathByErpClassId(es, erpclassId, 11L);
        List<CategaryDTO> categaryBos = convertNavEntryDdo(fullDdoList, true);
        return categaryBos;
    }

    private List<CategaryDTO> convertNavEntryDdo(Vector<NavEntryDdo> fullDdoList, boolean isErp) {
        List<CategaryDTO> categaryBos = new ArrayList<>();
        if (fullDdoList != null) {
            categaryBos = fullDdoList.stream().map(e -> {
                CategaryDTO categaryBo = new CategaryDTO();
                if (isErp) {
                    categaryBo.setName(e.getErpClassName());
                } else {
                    categaryBo.setName(e.getName());
                }
                categaryBo.setClassid(e.getNavId());
                categaryBo.setErpclassid(e.getErpClassId());
                categaryBo.setParentclassid(e.getPNavId());
                return categaryBo;
            }).collect(Collectors.toList());
        }
        return categaryBos;
    }
}