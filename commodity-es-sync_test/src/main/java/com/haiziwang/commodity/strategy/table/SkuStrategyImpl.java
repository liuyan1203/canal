package com.haiziwang.commodity.strategy.table;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.haiziwang.commodity.common.CanalRow;
import com.haiziwang.commodity.dao.SkuAreaDao;
import com.haiziwang.commodity.dao.SpuDao;
import com.haiziwang.commodity.model.dto.EsCommodityDTO;
import com.haiziwang.commodity.model.po.ConversionSkuPO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SkuStrategyImpl extends CommonStrategyImpl implements TableStrategy {

    private static final Logger logger = LoggerFactory.getLogger(SkuStrategyImpl.class);

    @Override
    public int insert(CanalRow canalRow) {
        /**
         *  执行转换的逻辑
         * 将canal中CanalEntry.Column转化为PO
         */
        EsCommodityDTO esCommodityDTO = (EsCommodityDTO) getPOByCanalRow(canalRow, new EsCommodityDTO());
        //补全spu+sku字段
        String spuId = esCommodityDTO.getFspuid();
        Long skuId = esCommodityDTO.getFskuid();
        //校验关键字段
        if (StringUtils.isEmpty(spuId) || skuId == null) {
            logger.error("table[{}] event[{}] error 关键字段缺失， spuId[{}], skuId[{}]",
                    canalRow.getTableName(), canalRow.getEventType(), spuId, skuId);
            return 0;
        }

        SpuDao spuDao = new SpuDao();
        spuDao.getSpu(esCommodityDTO, spuId);
        //todo 后续需要查询spuchildren表赋值
        esCommodityDTO.setFspuchildrenids(new ArrayList<>());
        initAllArea(esCommodityDTO, false, true);

        setESKey(canalRow.getEventType(), canalRow.getTableName(), esCommodityDTO);
        List<EsCommodityDTO> esCommodityDTOList = Arrays.asList(new EsCommodityDTO[]{esCommodityDTO});
        int result = pushToEs(esCommodityDTOList, canalRow);
        return result;
    }

    @Override
    public int update(CanalRow canalRow) {
        //修改的key为spu_sku_-1/spu_sku_*
        // 获取关注的字段
        List<String> columns = getColumnsToChange(ConversionSkuPO.class);
        // 获取更新的字段
        Map<String, String> updatedColumnsMap = getUpdatedColumns(canalRow, columns);
        // 判断是否需要进行字段转换
        if (!canalRow.getNeedChange())
            return 0;

        EsCommodityDTO skuEs = (EsCommodityDTO) getPOByCanalRow(canalRow, new EsCommodityDTO());
        String spuId = skuEs.getFspuid();
        Long skuId = skuEs.getFskuid();
        if (StringUtils.isEmpty(spuId) || skuId == null) {
            logger.error("table[{}] event[{}] error 关键字段缺失， spuId[{}], skuId[{}]",
                    canalRow.getTableName(), canalRow.getEventType(), spuId, skuId);
            return 0;
        }
        SkuAreaDao areaDao = new SkuAreaDao();
        List<EsCommodityDTO> resultEsDTOs = areaDao.getEntityIdsBySkuId(skuEs, spuId, skuId);
        //构造spu_sku_-1
        skuEs.setFentityid(-1);
        resultEsDTOs.add(skuEs);
        //设置Key
        for (EsCommodityDTO resultEs : resultEsDTOs){
            setESKey(canalRow.getEventType(), canalRow.getTableName(), resultEs);
        }
        int result = pushToEs(resultEsDTOs, canalRow);
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