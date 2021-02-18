package com.haiziwang.commodity.strategy.table;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.haiziwang.commodity.common.CanalRow;
import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.mapper.*;
import com.haiziwang.commodity.model.po.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.regex.Pattern;

public class SkuStrategyImpl extends CommonStrategyImpl implements TableStrategy {

    private static final Logger logger = LoggerFactory.getLogger(SkuStrategyImpl.class);

    private static Map<String, Set<String>> conversionRelation = new HashMap<String, Set<String>>() {
        {
            put("sku", new HashSet<String>() {
                {
                    add("Fpopskucode");
                    add("Fskulocalcode");
                    add("Fskucategoryattr");
                    add("Fskusaleattr");
                    add("Fskukeyattr");
                    add("Fskupacklist");
                    add("Fskuunitcost");
                    add("Fskuceilprice");
                    add("Fskufloorprice");
                    add("Fskuunit");
                    add("Fskustockexpiretime");
                    add("Fskuaddtime");
                    add("Fskulastupdatetime");
                    add("Fskulastdowntime");
                    add("Fskulastuptime");
                }
            });
            put("spu", new HashSet<String>() {
                {
                    add("Fskutitle");
                    add("Fflagshipstoreid");
                    add("Fskushortname");
                    add("Fskusubtitle");
                    add("Fskuoperationmodel");
                    add("Fskutype");
                    add("Fskubrand");
                    add("Fcategoryid");
                    add("Ftempid");
                    add("Ftoptempid");
                    add("Fbottomtempid");
                    add("Fskuvatrate");
                    add("Fskupurchtaxrate");
                    add("Fskuproducingarea");
                    add("Fskuspecmodel");
                    add("Fskusort");
                }
            });
//            put("area", new HashSet<String>() {
//                {
//                    add("Fspuid");
//                    add("Fcooperatorid");
//                    add("Fflagshipstoreid");
//                    add("Fskushortname");
//                    add("Fskusubtitle");
//                    add("Fcategoryid");
//                    add("Ftempid");
//                    add("Ftoptempid");
//                    add("Fbottomtempid");
//                    add("Fskuproducingarea");
//                    add("Fskusort");
//                    add("Fskulastdowntime");
//                    add("Fskulastuptime");
//                    add("Fskutype");
//                    add("Fskuspecmodel");
//                }
//            });
        }
    };

    @Override
    public int insert(CanalRow canalRow) {
        /**
         * 执行转换的逻辑
         * 将canal中CanalEntry.Column转化为PO
         */
        HzwSkuPO skuPO = (HzwSkuPO) getPOByCanalRow(canalRow, new HzwSkuPO());
//        logger.info("sku[{}]  eventType[{}] ", skuPO.toString(), canalRow.getEventType());
        try {
            handlerSkuInsert(skuPO);
            logger.info("table[{}] event[{}] success PO[{}]", canalRow.getTableName(), canalRow.getEventType(), skuPO.toString());
        } catch (Exception e) {
            logger.error("table[{}] event[{}] error PO[{}]  exception：{}", canalRow.getTableName(), canalRow.getEventType(), skuPO.toString(), e.getMessage());
        }

        return 1;
    }

    @Override
    public int update(CanalRow canalRow) {
        Map<String, String> updatedColumnsMap;
        if (Constant.FULL_MODE == 1) {
            updatedColumnsMap = convertColumnsToMap(canalRow);
        } else {
            // 获取关注的字段
            List<String> columns = getColumnsToChange(HzwSkuPO.class);
            // 获取更新的字段
            updatedColumnsMap = getUpdatedColumns(canalRow, columns);
            // 判断是否需要进行字段转换
            if (!canalRow.getNeedChange())
                return 0;
        }

        HzwSkuPO skuPO = (HzwSkuPO) getPOByCanalRow(canalRow, new HzwSkuPO());
        int index;
        if (skuPO.getFspuid() == 0) {
            index = (int) (skuPO.getFskuid() % Constant.DB_SHARDING);
        } else {
            index = (int) (skuPO.getFspuid() % Constant.DB_SHARDING);
        }
        // 查询中间库是否存在sku
        ConversionSkuMapper conversionSkuMapper = context.getBean(ConversionSkuMapper.class);
        ConversionSkuPO conversionSkuPO = conversionSkuMapper.selectBySkuId(index, skuPO.getFskuid());
        try {
            if (conversionSkuPO != null) {
                //更新
                handlerSkuUpdate(skuPO, updatedColumnsMap, index, conversionSkuPO.getFspuid(), conversionSkuPO.getFid());
            } else {
                //新增
                handlerSkuInsert(skuPO);
            }
            logger.info("table[{}] event[{}] success PO[{}]", canalRow.getTableName(), canalRow.getEventType(), skuPO.toString());
        } catch (Exception e) {
            logger.error("table[{}] event[{}] error PO[{}]  exception：{}", canalRow.getTableName(), canalRow.getEventType(), skuPO.toString(), e.getMessage());
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

    private void handlerSkuUpdate(HzwSkuPO skuPO, Map<String, String> updatedColumnsMap, int index, String spuId, Long skuFid) {
        //是否更新标识
        boolean updateSpu = false;
        boolean updateSku = false;
        boolean updatePackInfo = false;
        //判断spuid是sp开头还是sk
        boolean isSP = false;
        boolean spMatch = Pattern.matches("^SP.*", spuId);
        if (spMatch) {
            isSP = true;
        }
        ConversionSpuPO conversionSpuPO = new ConversionSpuPO();
        ConversionSkuPO conversionSkuPO = new ConversionSkuPO();
        ConversionSkuPackInfoPO conversionSkuPackInfoPO = new ConversionSkuPackInfoPO();
        for (Map.Entry entry : updatedColumnsMap.entrySet()) {
            String columnName = (String) entry.getKey();
//            String columnvValue = (String) entry.getValue();
            switch (columnName) {
                case "Fpopskucode":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSkuPO.setFskuextcode(skuPO.getFpopskucode());
                    break;
                case "Fskulocalcode":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSkuPO.setFskulocalcode(skuPO.getFskulocalcode());
                    break;
                case "Fskucategoryattr":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSkuPO.setFcategoryattr(skuPO.getFskucategoryattr());
                    updateSpu = checkUpdateSpuOrSku(updateSpu);
                    conversionSpuPO.setFspucategoryattr(skuPO.getFskucategoryattr());
                    break;
                case "Fskusaleattr":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSkuPO.setFskusaleattr(skuPO.getFskusaleattr());
                    if (skuPO.getFmainskuid() != 0) {
                        updateSpu = checkUpdateSpuOrSku(updateSpu);
                        conversionSpuPO.setFspusaleattr(skuPO.getFskusaleattr());
                    }
                    break;
                case "Fskukeyattr":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSkuPO.setFskukeyattr(skuPO.getFskukeyattr());
                    break;
                case "Fskupacklist":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSkuPO.setFskupacklist(skuPO.getFskupacklist());
                    break;
                case "Fskuunitcost":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSkuPO.setFskuunitcost(skuPO.getFskuunitcost());
                    break;
                case "Fskuceilprice":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSkuPO.setFskuerpceilingprice(skuPO.getFskuceilprice());
                    break;
                case "Fskuerpfloorprice":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSkuPO.setFskuerpfloorprice(skuPO.getFskufloorprice());
                    break;
                case "Fskuunit":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSkuPO.setFskuunit(skuPO.getFskuunit());
                    break;
                case "Fskustockexpiretime":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSkuPO.setFskustockexpiretime(skuPO.getFskustockexpiretime());
                    break;
                case "Fskuaddtime":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSkuPO.setFskuaddtime(skuPO.getFskuaddtime());
                    if (!isSP) {
                        updateSpu = checkUpdateSpuOrSku(updateSpu);
                        conversionSpuPO.setFspuaddtime(skuPO.getFskuaddtime());
                    }
                    break;
                case "Fskulastupdatetime":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSkuPO.setFskulastupdatetime(skuPO.getFskulastupdatetime());
                    if (!isSP) {
                        updateSpu = checkUpdateSpuOrSku(updateSpu);
                        conversionSpuPO.setFspulastupdatetime(skuPO.getFlastupdatetime());
                    }
                    break;
                case "Fskulastuptime":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSkuPO.setFskulastupstatetime(skuPO.getFskulastuptime());
                    updateSpu = checkUpdateSpuOrSku(updateSpu);
                    conversionSpuPO.setFspulastupstoretime(skuPO.getFskulastuptime());
                    break;
                case "Fskulastdowntime":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSkuPO.setFskulastdowntime(skuPO.getFskulastdowntime());
                    updateSpu = checkUpdateSpuOrSku(updateSpu);
                    conversionSpuPO.setFspulastdownstoretime(skuPO.getFskulastdowntime());
                    break;
                case "Fskureferprice":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSkuPO.setFskuerpreferprice(skuPO.getFskureferprice());
                    break;
                case "Fskupurchprice":
                    HzwSkuErpMapper hzwSkuErpMapper = context.getBean(HzwSkuErpMapper.class);
                    HzwSkuErpPO hzwSkuErpPO = hzwSkuErpMapper.getSkuById(skuPO.getFskuid());
                    if (hzwSkuErpPO == null || hzwSkuErpPO.getFskupurchpricev2() == 0) {
                        updateSku = checkUpdateSpuOrSku(updateSku);
                        conversionSkuPO.setFskuerpreferprice(skuPO.getFskureferprice() * 100);
                    }
                    break;

                /**
                 * spu
                 */
                case "Fskutitle":
                    if (isSP) {
                        updateSpu = checkUpdateSpuOrSku(updateSpu);
                        conversionSpuPO.setFspuonlinetitle(skuPO.getFskutitle());
                    }
                    break;
                case "Fflagshipstoreid":
                    updateSpu = checkUpdateSpuOrSku(updateSpu);
                    conversionSpuPO.setFflagshipstoreid(skuPO.getFflagshipstoreid());
                    break;
                case "Fspushortname":
                    updateSpu = checkUpdateSpuOrSku(updateSpu);
                    conversionSpuPO.setFspushortname(skuPO.getFskushortname());
                    break;
                case "Fskusubtitle":
                    updateSpu = checkUpdateSpuOrSku(updateSpu);
                    conversionSpuPO.setFspusubtitle(skuPO.getFskusubtitle());
                    break;
                case "Fskuoperationmodel":
                    updateSpu = checkUpdateSpuOrSku(updateSpu);
                    conversionSpuPO.setFspuoperationmodel(skuPO.getFskuoperationmodel());
                    break;
                case "Fskutype":
                    if (isSP) {
                        updateSpu = checkUpdateSpuOrSku(updateSpu);
                        conversionSpuPO.setFsputype(skuPO.getFskutype());
                    }
                    break;
                case "Fcategoryid":
                    updateSpu = checkUpdateSpuOrSku(updateSpu);
                    conversionSpuPO.setFcategoryid(skuPO.getFcategoryid());
                    break;
                case "Fskubrand":
                    updateSpu = checkUpdateSpuOrSku(updateSpu);
                    conversionSpuPO.setFbrandid(skuPO.getFskubrand());
                    break;
                case "Ftempid":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSpuPO.setFtempid(skuPO.getFtempid());
                    break;
                case "Ftoptempid":
                    updateSku = checkUpdateSpuOrSku(updateSku);
                    conversionSpuPO.setFtoptempid(skuPO.getFtoptempid());
                    break;
                case "Fbottomtempid":
                    updateSpu = checkUpdateSpuOrSku(updateSpu);
                    conversionSpuPO.setFbottomtempid(skuPO.getFbottomtempid());
                    break;
                case "Fskuvatrate":
                    updateSpu = checkUpdateSpuOrSku(updateSpu);
                    conversionSpuPO.setFspuvatrate(skuPO.getFskuvatrate());
                    break;
                case "Fskupurchtaxrate":
                    updateSpu = checkUpdateSpuOrSku(updateSpu);
                    conversionSpuPO.setFspupurchtaxrate(skuPO.getFskupurchtaxrate());
                    break;
                case "Fskuproducingarea":
                    updateSpu = checkUpdateSpuOrSku(updateSpu);
                    conversionSpuPO.setFspuproducingarea(skuPO.getFskuproducingarea());
                    break;
                case "Fskusort":
                    updateSpu = checkUpdateSpuOrSku(updateSpu);
                    conversionSpuPO.setFspusort(skuPO.getFskusort());
                    break;

                case "Fskuspecmodel":
                    if (isSP) {
                        updateSpu = checkUpdateSpuOrSku(updateSpu);
                        conversionSpuPO.setFspuspecmodel(skuPO.getFskuspecmodel());
                    }
                    break;
                /**
                 * sku_pack_info
                 */
                case "Fskuweight":
                    updatePackInfo = checkUpdateSpuOrSku(updatePackInfo);
                    conversionSkuPackInfoPO.setFskuweight(skuPO.getFskuweight());
                    break;
                case "Fskunetweight":
                    updatePackInfo = checkUpdateSpuOrSku(updatePackInfo);
                    conversionSkuPackInfoPO.setFskunetweight(skuPO.getFskunetweight());
                    break;
                case "Fskuvolume":
                    updatePackInfo = checkUpdateSpuOrSku(updatePackInfo);
                    conversionSkuPackInfoPO.setFskuvolume(Integer.valueOf(skuPO.getFskuvolume().toString()));
                    break;
                case "Fskusizex":
                    updatePackInfo = checkUpdateSpuOrSku(updatePackInfo);
                    conversionSkuPackInfoPO.setFskusizex(skuPO.getFskusizex());
                    break;
                case "Fskusizey":
                    updatePackInfo = checkUpdateSpuOrSku(updatePackInfo);
                    conversionSkuPackInfoPO.setFskusizey(skuPO.getFskusizey());
                    break;
                case "Fskusizez":
                    updatePackInfo = checkUpdateSpuOrSku(updatePackInfo);
                    conversionSkuPackInfoPO.setFskusizez(skuPO.getFskusizez());
                    break;
                default:
                    logger.info("没有处理的字段 [{}]", columnName);

            }
        }

        if (updateSpu) {
            ConversionSpuMapper conversionSpuMapper = context.getBean(ConversionSpuMapper.class);
            ConversionSpuPO exsitSpu = conversionSpuMapper.selectBySpuId(index, spuId, null);
            if (exsitSpu != null) {
                conversionSpuPO.setFid(exsitSpu.getFid());
                conversionSpuMapper.updateByPrimaryKeySelective(index, conversionSpuPO);
            }
        }
        if (updateSku) {
            ConversionSkuMapper conversionSkuMapper = context.getBean(ConversionSkuMapper.class);
            conversionSkuPO.setFid(skuFid);
            conversionSkuMapper.updateByPrimaryKeySelective(index, conversionSkuPO);
        }
        if (updatePackInfo) {
            ConversionSkuPackInfoMapper conversionSkuPackInfoMapper = context.getBean(ConversionSkuPackInfoMapper.class);
            ConversionSkuPackInfoPO packInfoPO = conversionSkuPackInfoMapper.selectBySpuIdAndSkuId(index, spuId, skuPO.getFskuid(), 1);
            if (packInfoPO != null) {
                conversionSkuPackInfoPO.setFid(packInfoPO.getFid());
                conversionSkuPackInfoMapper.updateByPrimaryKeySelective(index, conversionSkuPackInfoPO);
            }
        }
    }

    public void handlerSkuInsert(HzwSkuPO skuPO) {
        // 孩子王库存在spu
        boolean hwzExsitSpu = false;
        boolean conversionExsitSpu = false;
        // 分表下标
        Integer index = 0;
        String spuId = "";
        ConversionSkuPO conversionSkuPO = new ConversionSkuPO();
        ConversionSpuPO conversionSpuPO = new ConversionSpuPO();

        // 处理spuid
        if (skuPO.getFspuid() == 0) {
            spuId = createSpuId(skuPO.getFskuid(), Constant.NEW_SPU_ID_PREFIX);
        } else {
            spuId = createSpuId(skuPO.getFspuid(), Constant.SPU_ID_PREFIX);
            hwzExsitSpu = true;
        }
        index = getTableIndex(spuId);
        // 判断中间库是否已经存在spu
        ConversionSpuMapper conversionSpuMapper = context.getBean(ConversionSpuMapper.class);
        ConversionSpuPO exsitConversionSpuPO = conversionSpuMapper.selectBySpuId(index, spuId, skuPO.getFcooperatorid());
        if (exsitConversionSpuPO != null) {
            conversionExsitSpu = true;
        }

        /**
         * sku赋值
         */
        conversionSkuPO.setFskuid(skuPO.getFskuid());
        conversionSkuPO.setFplatformid(1);
        conversionSkuPO.setFspuid(spuId);
        conversionSkuPO.setFskuextcode(skuPO.getFpopskucode());
        conversionSkuPO.setFskulocalcode(skuPO.getFskulocalcode());
        conversionSkuPO.setFskustate(skuPO.getFskustate());
        conversionSkuPO.setFcategoryattr(skuPO.getFskucategoryattr());
        conversionSkuPO.setFskusaleattr(skuPO.getFskusaleattr());
        conversionSkuPO.setFskukeyattr(skuPO.getFskukeyattr());
        conversionSkuPO.setFskupacklist(skuPO.getFskupacklist());
        conversionSkuPO.setFskumainurl(skuPO.getFmainurl());
        conversionSkuPO.setFskuunitcost(skuPO.getFskuunitcost());
        conversionSkuPO.setFskuerpreferprice(skuPO.getFskureferprice());
        conversionSkuPO.setFskuerppurchprice(skuPO.getFskupurchprice() * 100);
        conversionSkuPO.setFskuerpceilingprice(skuPO.getFskuceilprice());
        conversionSkuPO.setFskuerpfloorprice(skuPO.getFskufloorprice());
//        conversionSkuPO.setFskuproperty(skuPO.getFskuproperty());
        conversionSkuPO.setFskuunit(skuPO.getFskuunit());
        conversionSkuPO.setFskustockexpiretime(skuPO.getFskustockexpiretime());
        conversionSkuPO.setFskuaddtime(skuPO.getFskuaddtime());
        conversionSkuPO.setFskulastupdatetime(skuPO.getFskulastupdatetime());
        conversionSkuPO.setFskulastupstatetime(skuPO.getFskulastuptime());
        conversionSkuPO.setFskulastdowntime(skuPO.getFskulastdowntime());

        /**
         * spu赋值
         */
        conversionSpuPO.setFspuid(spuId);
        conversionSpuPO.setFplatformid(1);
//        conversionSpuPO.setFspuextcode("");
        conversionSpuPO.setFspuonlinetitle(skuPO.getFskutitle());
        conversionSpuPO.setFcooperatorid(skuPO.getFcooperatorid());
        conversionSpuPO.setFflagshipstoreid(skuPO.getFflagshipstoreid());
        conversionSpuPO.setFspushortname(skuPO.getFskushortname());
        conversionSpuPO.setFspusubtitle(skuPO.getFskusubtitle());
//        conversionSpuPO.setFspustate(skuPO.getFskustate());
        conversionSpuPO.setFspuoperationmodel(skuPO.getFskuoperationmodel());
        conversionSpuPO.setFsputype(skuPO.getFskutype());
//        conversionSpuPO.setFspumainurl(skuPO.getFmainurl());
        conversionSpuPO.setFbrandid(skuPO.getFskubrand());
        conversionSpuPO.setFcategoryid(skuPO.getFcategoryid());
        if (skuPO.getFmainskuid() != 0)
            conversionSpuPO.setFspusaleattr(skuPO.getFskusaleattr());
        conversionSpuPO.setFspucategoryattr(skuPO.getFskucategoryattr());
        conversionSpuPO.setFtempid(skuPO.getFtempid());
        conversionSpuPO.setFtoptempid(skuPO.getFtoptempid());
        conversionSpuPO.setFbottomtempid(skuPO.getFbottomtempid());
//        conversionSpuPO.setFspuproperty(skuPO.getFskuproperty());
        conversionSpuPO.setFspuvatrate(skuPO.getFskuvatrate());
        conversionSpuPO.setFspupurchtaxrate(skuPO.getFskupurchtaxrate());
        conversionSpuPO.setFspuproducingarea(skuPO.getFskuproducingarea());
        conversionSpuPO.setFspuspecmodel(skuPO.getFskuspecmodel());
        conversionSpuPO.setFspusort(skuPO.getFskusort());

        conversionSpuPO.setFspulastdownstoretime(skuPO.getFskulastdowntime());
        conversionSpuPO.setFspulastupstoretime(skuPO.getFskulastuptime());
        conversionSpuPO.setFspuaddtime(skuPO.getFskuaddtime());
        conversionSpuPO.setFspulastupdatetime(skuPO.getFskulastupdatetime());

        //判断是否自营，查询sku_erp
        if (skuPO.getFcooperatorid() == 3) {
            //取值sku_erp(自营才有erp)
            HzwSkuErpMapper hzwSkuErpMapper = context.getBean(HzwSkuErpMapper.class);
            HzwSkuErpPO hzwSkuErpPO = hzwSkuErpMapper.getSkuById(skuPO.getFskuid());
            if (hzwSkuErpPO != null) {
                conversionSkuPO.setFgrossmargin(hzwSkuErpPO.getFgrossmargin());
                conversionSkuPO.setFgoodsno(hzwSkuErpPO.getFgoodsno());
                conversionSkuPO.setFskulevel(hzwSkuErpPO.getFlevel());
                conversionSpuPO.setFerpbrandid(hzwSkuErpPO.getFbrandid());
                conversionSpuPO.setFerppubnavid(hzwSkuErpPO.getFcategoryid());
                conversionSpuPO.setFcreateuser(hzwSkuErpPO.getFcreateuser());
                conversionSpuPO.setFsputitle(hzwSkuErpPO.getFskutitle());
                //参考进价
                conversionSkuPO.setFskuerppurchprice(hzwSkuErpPO.getFskupurchpricev2());
            }
        }
        //判断是否spu商品
        if (hwzExsitSpu) {
            HzwSpuMapper hzwSpuMapper = context.getBean(HzwSpuMapper.class);
            HzwSpuPO exsitHzwSpuPO = hzwSpuMapper.getSpuById(skuPO.getFspuid());
            if (exsitHzwSpuPO != null) {
                conversionSpuPO.setFspuonlinetitle(exsitHzwSpuPO.getFsputitle());
//                conversionSpuPO.setFspustate(exsitHzwSpuPO.getFspustate());
                conversionSpuPO.setFsputype(exsitHzwSpuPO.getFsputype());
                conversionSpuPO.setFspucategoryattr(exsitHzwSpuPO.getFspucategoryattr());
                conversionSpuPO.setFspuspecmodel(exsitHzwSpuPO.getFspuspecmodel());
                conversionSpuPO.setFspuaddtime(exsitHzwSpuPO.getFaddtime());
                conversionSpuPO.setFspulastupdatetime(exsitHzwSpuPO.getFlastupdatetime());
            }
            //取值spu_erp(自营才有erp)
            HzwSpuErpMapper hzwSpuErpMapper = context.getBean(HzwSpuErpMapper.class);
            HzwSpuErpPO exsitHzwSpuErpPO = hzwSpuErpMapper.getSpuById(skuPO.getFspuid());
            if (exsitHzwSpuErpPO != null) {
                conversionSpuPO.setFremark(exsitHzwSpuErpPO.getFremark());
                conversionSpuPO.setFsputitle(exsitHzwSpuErpPO.getFskutitle());
            }

        }

        if (conversionExsitSpu) {
            conversionSpuPO.setFid(exsitConversionSpuPO.getFid());
            conversionSpuMapper.updateByPrimaryKeySelective(index, conversionSpuPO);
            logger.info("conversionSpuPO更新成功! [{}]", conversionSpuPO.toString());
        } else {
            conversionSpuMapper.insertSelective(index, conversionSpuPO);
            logger.info("conversionSpuPO新增成功! [{}]", conversionSpuPO.toString());
        }
        ConversionSkuMapper conversionSkuMapper = context.getBean(ConversionSkuMapper.class);
        conversionSkuMapper.insertSelective(index, conversionSkuPO);
        logger.info("conversionSkuPO新增成功! [{}]", conversionSkuPO.toString());

    }


}