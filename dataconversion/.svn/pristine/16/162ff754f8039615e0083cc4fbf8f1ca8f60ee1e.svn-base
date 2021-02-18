package com.haiziwang.commodity.strategy;

import com.haiziwang.commodity.common.CanalRow;
import com.haiziwang.commodity.strategy.table.TableStrategy;
import com.haiziwang.commodity.strategy.table.TableStrategyContext;

import java.util.concurrent.ArrayBlockingQueue;

public class ta {
    private ArrayBlockingQueue<CanalRow> canalQueue = null;

    private Thread thread = null;
    public void start(){
        thread = new Thread(() -> {
            process();
        });
        thread.start();
    }

    private void process() {
        try {
            CanalRow canalRow = canalQueue.take();
            //根据表名引用策略模式
            String tableName = canalRow.getTableName();
            TableStrategyContext tableStrategyContext = new TableStrategyContext(tableName);
            TableStrategy tableStrategy = tableStrategyContext.getTableStrategy();
            tableStrategy.execute(canalRow);
        }catch (Exception e){

        }

    }


}