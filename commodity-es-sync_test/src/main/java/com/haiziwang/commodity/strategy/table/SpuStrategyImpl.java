package com.haiziwang.commodity.strategy.table;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.google.common.collect.Lists;
import com.haiziwang.commodity.common.CanalRow;
import com.haiziwang.commodity.dao.PackInfoDao;
import com.haiziwang.commodity.dao.SkuAreaDao;
import com.haiziwang.commodity.dao.SkuDao;
import com.haiziwang.commodity.dao.SpuDao;
import com.haiziwang.commodity.model.dto.EsCommodityDTO;
import com.haiziwang.commodity.model.po.ConversionSpuPO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class SpuStrategyImpl extends CommonStrategyImpl implements TableStrategy {

    private static final Logger logger = LoggerFactory.getLogger(SpuStrategyImpl.class);

    @Override
    public int insert(CanalRow canalRow) {
        /**
         * 执行转换的逻辑
         * 将canal中CanalEntry.Column转化为PO
         */
        EsCommodityDTO esCommodityDTO = (EsCommodityDTO) getPOByCanalRow(canalRow, new EsCommodityDTO());
        //初始化spu  platform_spuId_-1_-1
        initAllArea(esCommodityDTO, true, true);
        //需要处理的字段 Fspuchildrenids brandName erpBrandName categoryList erpCategoryList
        //todo 后续需要查询spuchildren表赋值
        esCommodityDTO.setFspuchildrenids(new ArrayList<>());
        setESKey(canalRow.getEventType(), canalRow.getTableName(), esCommodityDTO);
        List<EsCommodityDTO> esCommodityDTOList = Arrays.asList(new EsCommodityDTO[]{esCommodityDTO});
        int result = pushToEs(esCommodityDTOList, canalRow);
        return result;
    }

    @Override
    public int update(CanalRow canalRow) {
        List<String> columns = getColumnsToChange(ConversionSpuPO.class);
        // 获取更新的字段
        Map<String, String> updatedColumnsMap = getUpdatedColumns(canalRow, columns);
        // 判断是否需要进行字段转换
        if (!canalRow.getNeedChange())
            return 0;

        EsCommodityDTO spuEs = (EsCommodityDTO) getPOByCanalRow(canalRow, new EsCommodityDTO());
        String spuId = spuEs.getFspuid();
        if (StringUtils.isEmpty(spuId)) {
            logger.error("table[{}] event[{}] error 关键字段缺失， spuId[{}]",
                    canalRow.getTableName(), canalRow.getEventType(), spuId);
            return 0;
        }

        List<EsCommodityDTO> resultEsList = Lists.newArrayList();
        SkuDao skuDao = new SkuDao();

        //全量更新，upsert所有字段
        if (updatedColumnsMap.containsKey("Fplatformid")) {
            SpuDao spuDao = new SpuDao();
            spuDao.getSpu(spuEs, spuId);
            //todo 这里后续加入children表... 需要加入对应的查询Dao
            spuEs.setFspuchildrenids(new ArrayList<>());
            //查询sku全字段
            List<EsCommodityDTO> skuEsDTOs = skuDao.getSkusBySpuId(spuEs, spuId);
            for (EsCommodityDTO skuEs : skuEsDTOs) {
                //todo 这里后续加入children表... 需要加入对应的查询Dao，暂时只加入packinfo
                initAllArea(skuEs, false, true);
                PackInfoDao packInfoDao = new PackInfoDao();
                packInfoDao.getPackInfosBySkuId(skuEs, spuId, skuEs.getFskuid());
                resultEsList.add(skuEs);
                SkuAreaDao skuAreaDao = new SkuAreaDao();
                List<EsCommodityDTO> areaEs = skuAreaDao.getSkuAreasBySkuId(skuEs, spuId, skuEs.getFskuid());
                resultEsList.addAll(areaEs);
            }
            initAllArea(spuEs, true, true);
            resultEsList.add(spuEs);
        } else {
            //非全量
            //查询skuIds
            List<EsCommodityDTO> skuEsDTOs = skuDao.getSkuIdsBySpuId(spuEs, spuId);
            for (EsCommodityDTO skuEs : skuEsDTOs) {
                //spu_sku_-1
                skuEs.setFentityid(-1);
                resultEsList.add(skuEs);
                //spu_sku_entity
                SkuAreaDao skuAreaDao = new SkuAreaDao();
                List<EsCommodityDTO> areaEs = skuAreaDao.getEntityIdsBySkuId(skuEs, spuId, skuEs.getFskuid());
                resultEsList.addAll(areaEs);
            }
            // spu_-1_-1
            spuEs.setFskuid(-1L);
            spuEs.setFentityid(-1);
            resultEsList.add(spuEs);
        }
        //设置Key
        for (EsCommodityDTO resultEs : resultEsList) {
            setESKey(canalRow.getEventType(), canalRow.getTableName(), resultEs);
        }
        int result = pushToEs(resultEsList, canalRow);
        return result;
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

}