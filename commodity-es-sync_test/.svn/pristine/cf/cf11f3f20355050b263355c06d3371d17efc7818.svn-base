package com.haiziwang.commodity.strategy.table;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.haiziwang.commodity.common.CanalRow;
import com.haiziwang.commodity.dao.PackInfoDao;
import com.haiziwang.commodity.dao.SkuAreaDao;
import com.haiziwang.commodity.model.dto.EsCommodityDTO;
import com.haiziwang.commodity.model.po.ConversionSkuPO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class PackInfoStrategyImpl extends CommonStrategyImpl implements TableStrategy {

    private static final Logger logger = LoggerFactory.getLogger(PackInfoStrategyImpl.class);

    @Override
    public int insert(CanalRow canalRow) {
        EsCommodityDTO skuEs = (EsCommodityDTO) getPOByCanalRow(canalRow, new EsCommodityDTO());
        String spuId = skuEs.getFspuid();
        Long skuId = skuEs.getFskuid();
        if (StringUtils.isEmpty(spuId) || skuId == null) {
            logger.error("table[{}] event[{}] error 关键字段缺失， spuId[{}], skuId[{}]",
                    canalRow.getTableName(), canalRow.getEventType(), spuId, skuId);
            return 0;
        }
        PackInfoDao packInfoDao = new PackInfoDao();
        packInfoDao.getPackInfosBySkuId(skuEs, spuId, skuId);

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
    public int update(CanalRow canalRow) {
        //pack info insert/update/delete 逻辑相同
        return insert(canalRow);
    }

    @Override
    public int delete(CanalRow canalRow) {
        //pack info insert/update/delete 逻辑相同
        return insert(canalRow);
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