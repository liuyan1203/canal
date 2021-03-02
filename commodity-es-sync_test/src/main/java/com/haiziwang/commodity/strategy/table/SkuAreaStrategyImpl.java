package com.haiziwang.commodity.strategy.table;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.haiziwang.commodity.common.CanalRow;
import com.haiziwang.commodity.dao.PackInfoDao;
import com.haiziwang.commodity.dao.SkuDao;
import com.haiziwang.commodity.dao.SpuDao;
import com.haiziwang.commodity.model.dto.EsCommodityDTO;
import com.haiziwang.commodity.model.po.ConversionSkuAreaPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SkuAreaStrategyImpl extends CommonStrategyImpl implements TableStrategy {

    private static final Logger logger = LoggerFactory.getLogger(SkuAreaStrategyImpl.class);

    @Override
    public int insert(CanalRow canalRow) {
        /**
         * 执行转换的逻辑
         * 将canal中CanalEntry.Column转化为PO
         */
        EsCommodityDTO esCommodityDTO = (EsCommodityDTO) getPOByCanalRow(canalRow, new EsCommodityDTO());
        //补全spu+sku字段
        String spuId = esCommodityDTO.getFspuid();
        Long skuId = esCommodityDTO.getFskuid();
        SpuDao spuDao = new SpuDao();
        spuDao.getSpu(esCommodityDTO, spuId);
        //todo 后续需要查询spuchildren表赋值
        esCommodityDTO.setFspuchildrenids(new ArrayList<>());

        SkuDao skuDao = new SkuDao();
        skuDao.getSku(esCommodityDTO, spuId, skuId);

        PackInfoDao packInfoDao = new PackInfoDao();
        packInfoDao.getPackInfosBySkuId(esCommodityDTO, spuId, skuId);

        //初始化otherinfo
        initOtherInfo(esCommodityDTO);

        setESKey(canalRow.getEventType(), canalRow.getTableName(), esCommodityDTO);
        List<EsCommodityDTO> esCommodityDTOList = Arrays.asList(new EsCommodityDTO[]{esCommodityDTO});
        int result = pushToEs(esCommodityDTOList, canalRow);
        return result;
    }

    @Override
    public int update(CanalRow canalRow) {
        // 获取关注的字段
        List<String> columns = getColumnsToChange(ConversionSkuAreaPO.class);
        // 获取更新的字段
        Map<String, String> updatedColumnsMap = getUpdatedColumns(canalRow, columns);
        // 判断是否需要进行字段转换
        if (!canalRow.getNeedChange())
            return 0;

        EsCommodityDTO areaEs = (EsCommodityDTO) getPOByCanalRow(canalRow, new EsCommodityDTO());
        setESKey(canalRow.getEventType(), canalRow.getTableName(), areaEs);
        List<EsCommodityDTO> esCommodityDTOList = Arrays.asList(new EsCommodityDTO[]{areaEs});
        int result = pushToEs(esCommodityDTOList, canalRow);
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