package com.haiziwang.commodity.strategy.table;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.haiziwang.commodity.common.CanalRow;
import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.mapper.ConversionSpuMapper;
import com.haiziwang.commodity.mapper.HzwSpuErpMapper;
import com.haiziwang.commodity.model.dto.SkuUpdateFlagDTO;
import com.haiziwang.commodity.model.po.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class SpuErpStrategyImpl extends CommonStrategyImpl implements TableStrategy{
    private static final Logger logger = LoggerFactory.getLogger(SpuErpStrategyImpl.class);

    private static Map<String, Set<String>> conversionRelation = new HashMap<String, Set<String>>() {
        {
            put("sku", new HashSet<String>() );
            put("spu", new HashSet<String>() {
                {
                    add("Fremark");
                    add("Fcreateuser");
                    add("Fskutitle");
                }
            });
        }
    };

    @Override
    public int insert(CanalRow canalRow) {
        return 0;
    }

    @Override
    public int update(CanalRow canalRow) {
        // 获取关注的字段
        List<String> columns = getColumnsToChange(HzwSpuErpPO.class);
        // 获取更新的字段
        Map<String, String> updatedColumnsMap = getUpdatedColumns(canalRow, columns);
        // 判断是否需要进行字段转换
        if (!canalRow.getNeedChange())
            return 0;

        HzwSpuErpPO spuErpPO = (HzwSpuErpPO) getPOByCanalRow(canalRow, new HzwSpuErpPO());
        String spuId = createSpuId(spuErpPO.getFspuid(), Constant.SPU_ID_PREFIX);
        int index = (int) (spuErpPO.getFspuid() % Constant.DB_SHARDING);

        // 查询中间库是否存在sku
        ConversionSpuMapper conversionSpuMapper = context.getBean(ConversionSpuMapper.class);
        ConversionSpuPO exsitSpuPO = conversionSpuMapper.selectBySpuId(index, spuId, 3L);
        try {
            if (exsitSpuPO != null) {
                //更新
                handlerSpuErpUpdate(spuErpPO, updatedColumnsMap, index, exsitSpuPO.getFid());
            } else {
                //新增暂不处理
            }
            logger.info("table[{}] event[{}] success PO[{}]", canalRow.getTableName(), canalRow.getEventType(), spuErpPO.toString());
        } catch (Exception e) {
            logger.error("table[{}] event[{}] error PO[{}]  exception：{}", canalRow.getTableName(), canalRow.getEventType(), spuErpPO.toString(), e.getMessage());
        }
        return 0;
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

    private void handlerSpuErpUpdate(HzwSpuErpPO spuErpPO, Map<String, String> updatedColumnsMap, int index, Long spuFid) {
        ConversionSpuPO conversionSpuPO = new ConversionSpuPO();
        for (Map.Entry entry : updatedColumnsMap.entrySet()) {
            String columnName = (String) entry.getKey();
//            String columnvValue = (String) entry.getValue();
            switch (columnName) {
                case "Fremark":
                    conversionSpuPO.setFremark(spuErpPO.getFremark());
                    break;
                case "Fcreateuser":
                    conversionSpuPO.setFcreateuser(spuErpPO.getFcreateuser());
                    break;
                case "Fskutitle":
                    conversionSpuPO.setFsputitle(spuErpPO.getFskutitle());
                    break;
                default:
                    logger.info("没有处理的字段 [{}]", columnName);
            }
        }
        ConversionSpuMapper conversionSpuMapper = context.getBean(ConversionSpuMapper.class);
        conversionSpuPO.setFid(spuFid);
        conversionSpuMapper.updateByPrimaryKeySelective(index, conversionSpuPO);
    }
}