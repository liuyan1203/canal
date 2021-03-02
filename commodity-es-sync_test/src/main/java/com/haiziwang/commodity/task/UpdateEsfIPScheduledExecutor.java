package com.haiziwang.commodity.task;

import com.haiziwang.commodity.cpp.CachePeerIp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 全量ES：主要用来解决个别数据缺失以及不一直的问题（例如获取名牌超时，消息丢失，消息推送失败等）
 * 文件中配置（spuId）
 */
@Component
public class UpdateEsfIPScheduledExecutor {
    protected final static Logger logger = LoggerFactory.getLogger(UpdateEsfIPScheduledExecutor.class);
    private static AtomicLong printCnt = new AtomicLong(0);

    public void executeJob() {
        if (printCnt.get() % 2 == 0) {
            if (printCnt.get() == 100000000)
                printCnt.getAndSet(0);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            CachePeerIp.getInstance().setA001IPs("A001");
            CachePeerIp.getInstance().setA016IPs("A016");
            logger.info("定时更新缓存esf IP DateTime[{}] ", sdf.format(new Date()));
        }
        printCnt.getAndIncrement();
    }

}