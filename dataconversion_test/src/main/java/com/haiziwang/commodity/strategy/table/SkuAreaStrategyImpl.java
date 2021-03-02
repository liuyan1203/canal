package com.haiziwang.commodity.strategy.table;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.haiziwang.commodity.common.CanalRow;
import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.mapper.ConversionSkuAreaMapper;
import com.haiziwang.commodity.mapper.ConversionSkuMapper;
import com.haiziwang.commodity.mapper.HzwSkuMapper;
import com.haiziwang.commodity.model.po.ConversionSkuAreaPO;
import com.haiziwang.commodity.model.po.ConversionSkuPO;
import com.haiziwang.commodity.model.po.HzwSkuAreaPO;
import com.haiziwang.commodity.model.po.HzwSkuPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class SkuAreaStrategyImpl extends CommonStrategyImpl implements TableStrategy {
    private static final Logger logger = LoggerFactory.getLogger(SkuAreaStrategyImpl.class);

    @Override
    public int insert(CanalRow canalRow) {
        HzwSkuAreaPO areaPO = (HzwSkuAreaPO) getPOByCanalRow(canalRow, new HzwSkuAreaPO());
        try {
            handlerInsert(areaPO);
            logger.info("table[{}] event[{}] success PO[{}]", canalRow.getTableName(), canalRow.getEventType(), areaPO.toString());
        } catch (Exception e) {
            logger.error("table[{}] event[{}] error PO[{}]  exception：{}", canalRow.getTableName(), canalRow.getEventType(), areaPO.toString(), e.getMessage());
        }

        return 0;
    }

    @Override
    public int update(CanalRow canalRow) {
        // 获取关注的字段
        List<String> columns = getColumnsToChange(HzwSkuAreaPO.class);
        // 获取更新的字段
        Map<String, String> updatedColumnsMap = getUpdatedColumns(canalRow, columns);
        // 判断是否需要进行字段转换
        if (!canalRow.getNeedChange())
            return 0;

        HzwSkuAreaPO areaPO = (HzwSkuAreaPO) getPOByCanalRow(canalRow, new HzwSkuAreaPO());
        Long skuId = areaPO.getFskuid();
        HzwSkuMapper hzwSkuMapper = context.getBean(HzwSkuMapper.class);
        HzwSkuPO hzwSkuPO = hzwSkuMapper.getSkuById(skuId);
        String spuId = "";
        if (hzwSkuPO.getFspuid() == 0) {
            spuId = createSpuId(skuId, Constant.NEW_SPU_ID_PREFIX);
        } else {
            spuId = createSpuId(hzwSkuPO.getFspuid(), Constant.SPU_ID_PREFIX);
        }
        Integer index = getTableAreaIndex(spuId);

        // 查询中间库是否存在spu
        ConversionSkuAreaMapper conversionSkuAreaMapper = context.getBean(ConversionSkuAreaMapper.class);
        ConversionSkuAreaPO exsitSkuAreaPO = conversionSkuAreaMapper.selectBySpuIdAndSkuId(index, spuId, skuId, areaPO.getFentityid());
        try {
            if (exsitSkuAreaPO != null) {
                //更新
                handlerUpdate(areaPO, updatedColumnsMap, index, exsitSkuAreaPO.getFid());
            } else {
                //新增
                handlerInsert(areaPO);
            }
            logger.info("table[{}] event[{}] success PO[{}]", canalRow.getTableName(), canalRow.getEventType(), areaPO.toString());
        } catch (Exception e) {
            logger.error("table[{}] event[{}] error PO[{}]  exception：{}", canalRow.getTableName(), canalRow.getEventType(), areaPO.toString(), e.getMessage());
        }
        return 1;
    }

    @Override
    public int delete(CanalRow canalRow) {
        return 0;
    }

    @Override
    public int execute(CanalRow canalRow) {
        int recordNum = 0;
        if (canalRow.getEventType() == CanalEntry.EventType.INSERT) {
            recordNum = insert(canalRow);
        } else if (canalRow.getEventType() == CanalEntry.EventType.UPDATE) {
            recordNum = update(canalRow);
        } else if (canalRow.getEventType() == CanalEntry.EventType.DELETE) {
            recordNum = delete(canalRow);
        }
        return recordNum;
    }

    private void handlerInsert(HzwSkuAreaPO areaPO) {
        String spuId = "";
        ConversionSkuAreaPO conversionSkuAreaPO = new ConversionSkuAreaPO();
        Long skuId = areaPO.getFskuid();
        // 检查是否存在
        HzwSkuMapper hzwSkuMapper = context.getBean(HzwSkuMapper.class);
        HzwSkuPO hzwSkuPO = hzwSkuMapper.getSkuById(skuId);

        if (hzwSkuPO != null) {
            if (hzwSkuPO.getFspuid() == 0) {
                spuId = createSpuId(skuId, Constant.NEW_SPU_ID_PREFIX);
            } else {
                spuId = createSpuId(hzwSkuPO.getFspuid(), Constant.SPU_ID_PREFIX);
            }
            int index = getTableIndex(spuId);
            ConversionSkuMapper conversionSkuMapper = context.getBean(ConversionSkuMapper.class);
            ConversionSkuPO conversionSkuPO = conversionSkuMapper.selectBySkuId(index, skuId);
            if (conversionSkuPO != null) {
                conversionSkuAreaPO.setFplatformid(1);
                conversionSkuAreaPO.setFspuid(spuId);
                conversionSkuAreaPO.setFskuid(hzwSkuPO.getFskuid());
                conversionSkuAreaPO.setFentityid(areaPO.getFentityid());
                conversionSkuAreaPO.setFchannelid(areaPO.getFchannelid());
                conversionSkuAreaPO.setFstoreid(areaPO.getFstoreid());
//            conversionSkuAreaPO.setFincatalog(areaPO.getFincatalog());
                conversionSkuAreaPO.setFworkstatecode(areaPO.getFworkstatecode());
                conversionSkuAreaPO.setFcirculationmodecode(areaPO.getFcirculationmodecode());
                conversionSkuAreaPO.setFskuareapostprice(areaPO.getFskuareapostprice());
                conversionSkuAreaPO.setFskuareaprice(areaPO.getFskuareaprice());
                conversionSkuAreaPO.setFskuareapreprice(areaPO.getFskuareapreprice());
                conversionSkuAreaPO.setFsaleslabelid(areaPO.getFsaleslabelid());
                // 没有同步的值
//        conversionSkuAreaPO.setFsubchannelinfo(areaPO.getFsubchannelinfo());
                conversionSkuAreaPO = handlerSpecialColumn(conversionSkuAreaPO, areaPO);
//                conversionSkuAreaPO.setFskuareaproperty(areaPO.getFskuareaproperty());
                conversionSkuAreaPO.setFskuareabuyer(areaPO.getFskuareabuyer());
                conversionSkuAreaPO.setFskuareaaddtime(areaPO.getFskuareaaddtime());
                conversionSkuAreaPO.setFskuarealastupdatetime(areaPO.getFskuarealastupdatetime());
                conversionSkuAreaPO.setFskuareafirstpublishtime(areaPO.getFskuareafirstpublishtime());
                //赋值给sku
                if (areaPO.getFentityid() == 8000 && areaPO.getFchannelid() == 1){
                    conversionSkuPO.setFskuminbuycount(areaPO.getFskuareaminbuycount());
                    conversionSkuPO.setFskumaxbuycount(areaPO.getFskuareamaxbuycount());
                    conversionSkuPO.setFskubuymultiple(areaPO.getFskuareabuymultiple());
                    conversionSkuMapper.updateByPrimaryKeySelective(index, conversionSkuPO);
                }
                ConversionSkuAreaMapper conversionSkuAreaMapper = context.getBean(ConversionSkuAreaMapper.class);
                conversionSkuAreaMapper.insertSelective(getTableAreaIndex(spuId), conversionSkuAreaPO);
            }

        }

    }

    private void handlerUpdate(HzwSkuAreaPO areaPO, Map<String, String> updatedColumnsMap, int index, Long entityId) {
        boolean updateArea = false;
        boolean updateSku = false;
        ConversionSkuAreaPO conversionSkuAreaPO = new ConversionSkuAreaPO();
        ConversionSkuPO conversionSkuPO = new ConversionSkuPO();
        for (Map.Entry entry : updatedColumnsMap.entrySet()) {
            String columnName = (String) entry.getKey();
            switch (columnName) {
                case "Fchannelid":
                    updateArea = checkUpdateSpuOrSku(updateArea);
                    conversionSkuAreaPO.setFchannelid(areaPO.getFchannelid());
                    break;
                case "Fstoreid":
                    updateArea = checkUpdateSpuOrSku(updateArea);
                    conversionSkuAreaPO.setFstoreid(areaPO.getFstoreid());
                    break;
                case "Fworkstatecode":
                    updateArea = checkUpdateSpuOrSku(updateArea);
                    conversionSkuAreaPO.setFworkstatecode(areaPO.getFworkstatecode());
                    break;
                case "Fcirculationmodecode":
                    updateArea = checkUpdateSpuOrSku(updateArea);
                    conversionSkuAreaPO.setFcirculationmodecode(areaPO.getFcirculationmodecode());
                    break;
                case "Fskuareapostprice":
                    updateArea = checkUpdateSpuOrSku(updateArea);
                    conversionSkuAreaPO.setFskuareapostprice(areaPO.getFskuareapostprice());
                    break;
                case "Fskuareaprice":
                    updateArea = checkUpdateSpuOrSku(updateArea);
                    conversionSkuAreaPO.setFskuareaprice(areaPO.getFskuareaprice());
                    break;
                case "Fskuareapreprice":
                    updateArea = checkUpdateSpuOrSku(updateArea);
                    conversionSkuAreaPO.setFskuareapreprice(areaPO.getFskuareapreprice());
                    break;
                case "Fsaleslabelid":
                    updateArea = checkUpdateSpuOrSku(updateArea);
                    conversionSkuAreaPO.setFsaleslabelid(areaPO.getFsaleslabelid());
                    break;
                case "Fskuareabuyer":
                    updateArea = checkUpdateSpuOrSku(updateArea);
                    conversionSkuAreaPO.setFskuareabuyer(areaPO.getFskuareabuyer());
                    break;
                case "Fskuareaaddtime":
                    updateArea = checkUpdateSpuOrSku(updateArea);
                    conversionSkuAreaPO.setFskuareaaddtime(areaPO.getFskuareaaddtime());
                    break;
                case "Fskuarealastupdatetime":
                    updateArea = checkUpdateSpuOrSku(updateArea);
                    conversionSkuAreaPO.setFskuarealastupdatetime(areaPO.getFskuarealastupdatetime());
                    break;
                case "Fskuareafirstpublishtime":
                    updateArea = checkUpdateSpuOrSku(updateArea);
                    conversionSkuAreaPO.setFskuareafirstpublishtime(areaPO.getFskuareafirstpublishtime());
                    break;
                case "Fskuareaproperty":
                    updateArea = checkUpdateSpuOrSku(updateArea);
                    conversionSkuAreaPO = handlerSpecialColumn(conversionSkuAreaPO, areaPO);
                    break;
                /**
                 * 更新sku购买数量
                 */
                case "Fskuareaminbuycount":
                    if (areaPO.getFentityid() == 8000 && areaPO.getFchannelid() == 1) {
                        updateSku = checkUpdateSpuOrSku(updateSku);
                        conversionSkuPO.setFskuminbuycount(areaPO.getFskuareaminbuycount());
                    }
                    break;
                case "Fskuareamaxbuycount":
                    if (areaPO.getFentityid() == 8000 && areaPO.getFchannelid() == 1) {
                        updateSku = checkUpdateSpuOrSku(updateSku);
                        conversionSkuPO.setFskumaxbuycount(areaPO.getFskuareamaxbuycount());
                    }
                    break;
                case "Fskuareabuymultiple":
                    if (areaPO.getFentityid() == 8000 && areaPO.getFchannelid() == 1) {
                        updateSku = checkUpdateSpuOrSku(updateSku);
                        conversionSkuPO.setFskubuymultiple(areaPO.getFskuareabuymultiple());
                    }
                    break;
                default:
                    logger.info("没有处理的字段 [{}]", columnName);
            }
        }
        if (updateArea) {
            ConversionSkuAreaMapper conversionSkuAreaMapper = context.getBean(ConversionSkuAreaMapper.class);
            conversionSkuAreaPO.setFid(entityId);
            conversionSkuAreaMapper.updateByPrimaryKeySelective(index, conversionSkuAreaPO);
        }
        if (updateSku) {
            ConversionSkuMapper conversionSkuMapper = context.getBean(ConversionSkuMapper.class);
            ConversionSkuPO exsitSku = conversionSkuMapper.selectBySkuId(index, areaPO.getFskuid());
            if (exsitSku != null){
                conversionSkuPO.setFid(exsitSku.getFid());
                conversionSkuMapper.updateByPrimaryKeySelective(index, conversionSkuPO);
            }
        }

    }

    private ConversionSkuAreaPO handlerSpecialColumn(ConversionSkuAreaPO conversionSkuAreaPO, HzwSkuAreaPO hzwSkuAreaPO) {
        if (conversionSkuAreaPO != null && hzwSkuAreaPO != null && hzwSkuAreaPO.getFskuareaproperty() != null) {
            Long skuareaproperty = hzwSkuAreaPO.getFskuareaproperty();
            StringBuffer sb = new StringBuffer();
            for (int i = 63; i >= 0; i--) {
                long bitVal = new Double(Math.pow(2, i)).longValue();
                if ((skuareaproperty & bitVal) == bitVal) {
                    if (i == 0 || i == 1) {
                        sb.append("0");
                    } else {
                        sb.append("1");
                    }
                } else {
                    sb.append("0");
                }
            }
            conversionSkuAreaPO.setFskuareaproperty(Long.parseLong(sb.toString(), 2));
        }

        return conversionSkuAreaPO;
    }

}