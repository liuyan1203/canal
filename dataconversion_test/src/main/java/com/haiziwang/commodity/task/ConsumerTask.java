package com.haiziwang.commodity.task;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.haiziwang.commodity.common.CanalRow;
import com.haiziwang.commodity.strategy.table.TableStrategy;
import com.haiziwang.commodity.strategy.table.TableStrategyContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class ConsumerTask {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerTask.class);

    private ArrayBlockingQueue<CanalRow> canalQueue = null;

    private Thread thread = null;

    protected volatile boolean running = false;
    protected Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {

        public void uncaughtException(Thread t, Throwable e) {
            logger.error("canal consumer task has an error", e);
        }
    };

    public ConsumerTask(ArrayBlockingQueue<CanalRow> canalQueue) {
        this.canalQueue = canalQueue;
    }

    public void start() {
        thread = new Thread(() -> {
            process();
        });
        thread.setUncaughtExceptionHandler(handler);
        running = true;
        thread.start();
    }

    public void stop() {
        if (!running) {
            return;
        }
        running = false;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                // ignore
            }
        }

        MDC.remove("destination");
    }

    private void process() {
        while (running || canalQueue.size() > 0) {
            if (canalQueue.size() > 0) {
                CanalRow canalRow = null;
                String tableName = "";
                try {
                    canalRow = canalQueue.take();
                    //根据表名引用策略模式
                    tableName = canalRow.getTableName();
                    TableStrategyContext tableStrategyContext = new TableStrategyContext(tableName);
                    TableStrategy tableStrategy = tableStrategyContext.getTableStrategy();
                    tableStrategy.execute(canalRow);
                } catch (Exception ex) {
                    StringBuilder sb = new StringBuilder();
                    List<CanalEntry.Column> columns = canalRow.getColumns();
                    for (CanalEntry.Column column : columns) {
                        String columnName = column.getName();
                        String value = column.getValue();
                        if (column.getUpdated()) {
                            sb.append("updated:");
                        }
                        sb.append(columnName + "=" + value + ",");
                    }
                    logger.error("消费线程异常: tableName [{}] canalRow[{}] ex[{}]", tableName, sb.toString(), ex.getMessage());
                }
            } else {
                try {
                    logger.debug("队列中没有消息，线程[{}]睡5秒...", Thread.currentThread().getName());
                    thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }

    }
}