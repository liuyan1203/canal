package com.haiziwang.commodity.canal;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.common.utils.AddressUtils;
import com.haiziwang.commodity.common.CanalRow;
import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.task.ConsumerTask;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.InetSocketAddress;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 程序入口
 */
public class CanalClient extends AbstractCanalClient {

    private static String IP = "";
    private static int PORT = 11111;

    public CanalClient(String destination) {
        super(destination);
    }

    public static void main(String args[]) {
        new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        // 根据ip，直接创建链接，无HA的功能
        IP = AddressUtils.getHostIp();
        IP = "172.172.177.109";
        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress(IP, PORT),
                Constant.CLIENT_DESTINATION,
                Constant.CANAL_USER_NAME,
                Constant.CANAL_PASSWORD);

        final CanalClient client = new CanalClient(Constant.CLIENT_DESTINATION);
        client.setConnector(connector);
        if (connector != null) {
            logger.info("canal destination[{}] IP[{}] PORT[{}] 连接成功！", Constant.CLIENT_DESTINATION, IP, PORT);
        }

        queueList = new Vector<>();
        IntStream.range(0, Constant.CLIENT_PROCESS_NUMBER).forEach(i -> {
            queueList.add(new ArrayBlockingQueue<CanalRow>(1000, true));
        });
        /**
         * 启动消费线程
         */
        IntStream.range(0, Constant.CLIENT_PROCESS_NUMBER).forEach(i -> {
            ArrayBlockingQueue<CanalRow> queue = queueList.get(i);
            ConsumerTask consumerTask = new ConsumerTask(queue);
            consumerTask.start();

            Runtime.getRuntime().addShutdownHook(
                    new Thread() {
                        public void run() {
                            try {
                                logger.info("## stop the table parse client");
                                consumerTask.stop();
                            } catch (Throwable e) {
                                logger.warn("##something goes wrong when stopping table parse:", e);
                            } finally {
                                logger.info("## canal table parse is down.");
                            }
                        }
                    }
            );
        });

        /**
         * 启动生产线程
         */
        client.start();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    logger.info("## stop the table parse client");
                    client.stop();
                } catch (Throwable e) {
                    logger.warn("##something goes wrong when stopping table parse:", e);
                } finally {
                    logger.info("## canal table parse is down.");
                }
            }
        });
    }

}
