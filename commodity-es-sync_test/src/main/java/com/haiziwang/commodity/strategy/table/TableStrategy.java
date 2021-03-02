package com.haiziwang.commodity.strategy.table;

import com.haiziwang.commodity.common.CanalRow;

/**
 * 策略接口
 */
public interface TableStrategy {

    int insert(CanalRow canalRow);

    int update(CanalRow canalRow);

    int delete(CanalRow canalRow);

    int execute(CanalRow canalRow);
}
