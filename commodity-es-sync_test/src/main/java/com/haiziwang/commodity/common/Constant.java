package com.haiziwang.commodity.common;

import com.haiziwang.commodity.utils.PropertyUtils;

/**
 * 常量类
 */
public class Constant {

    public static final String CLIENT_DESTINATION = PropertyUtils.get("client_destination");

    public static final String CANAL_USER_NAME = PropertyUtils.get("client_user_name");

    public static final String CANAL_PASSWORD = PropertyUtils.get("client_password");

    public static final Integer CLIENT_BATCH_SIZE = PropertyUtils.getInteger("client_batch_size");

    public static final Integer CLIENT_PROCESS_NUMBER = PropertyUtils.getInteger("client_process_number");

    public static final String CLIENT_RETRYTIMES = PropertyUtils.get("client_retrytimes");

    public static final String CLIENT_FILTER = PropertyUtils.get("client_filter");

    public static final String CLIENT_SCHEMA_NAME = PropertyUtils.get("client_schema_name");

    public static final String CLIENT_DEBUG = PropertyUtils.get("client_debug");

    public static final Integer DB_SHARDING = PropertyUtils.getInteger("db_sharding");

    public static final Integer DB_SHARDING_AREA = PropertyUtils.getInteger("db_sharding_area");

    public static final Integer FULL_MODE = PropertyUtils.getInteger("full_mode");

    public static final Integer OPEN_LOG = PropertyUtils.getInteger("open_log");

    public static final String MQ_URL = PropertyUtils.get("mq_url");

    public static final String APP_CODE = PropertyUtils.get("app_code");

    public static final String MQ_TOPIC = PropertyUtils.get("mq_topic");

    public static final String MQ_TOKEN = PropertyUtils.get("mq_token");

    //c++服务IP
    public static final String CPP_SERVICE_IP = PropertyUtils.get("cpp_server_ip");

    //c++服务端口
    public static final Integer CPP_SERVICE_PORT = PropertyUtils.getInteger("cpp_server_port");

    //定时任务标识
    public static final Integer OPEN_SCHEDULE = PropertyUtils.getInteger("open_schedule");

    //esf路径
    public static final String ESF_SRV = PropertyUtils.get("esf_srv");

    //定时任务的全量模式，慎改
    public static final Integer SCHEDULE_FULL_MODE = PropertyUtils.getInteger("schedule_full_mode");

    /**
     * 中间库数据源
     */
    public static final String DATASOURCE_CONVERSION = "dataSource_conversion";

    public static final String NEW_SPU_ID_PREFIX = "SK";

    public static final String SPU_ID_PREFIX = "SP";


}