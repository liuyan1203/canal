package com.haiziwang.commodity.task;

/**
 * ES -> packinfo补偿：主要用来解决ES中packinfo信息不一致问题
 * 文件中配置（spuId,skuId）
 */
//@Component
public class PackInfoScheduledExecutor {
    //读取配置文件
//    protected final static Logger logger = LoggerFactory.getLogger(PackInfoScheduledExecutor.class);
//
//    private static AtomicLong printCnt = new AtomicLong(0);
//
//    private List<String> skuIds = new ArrayList<>();
//
//    //是否执行过标识
//    private static AtomicBoolean execFlag = new AtomicBoolean(false);
//
//    public void executeJob() {
//        //防止重复执行
//        synchronized (PackInfoScheduledExecutor.class) {
//            if (execFlag.get() == false) {
//                execFlag.set(true);
//            } else {
//                logger.info("重复执行了..");
//                return;
//            }
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        InputStream inputStream = null;
//        //是否开启定时任务
//        if (1 == Constant.OPEN_SCHEDULE) {
//            logger.info("定时任务开始执行ThreadName[{}] DateTime[{}] ", Thread.currentThread().getName(), sdf.format(new Date()));
//            skuIds.clear();
//            inputStream = PackInfoScheduledExecutor.class.getClassLoader().getResourceAsStream("file/packinfo.txt");
//        } else {
//            return;
//        }
//        readFileByLinesV2(inputStream);
//        parsePushEs();
//    }
//
//    public List<String> readFileByLinesV2(InputStream inputStream) {
//        List<String> pushSpus = new ArrayList<>();
////        File file = new File(fileName);
//        BufferedReader reader = null;
//        try {
//            logger.info("开始读取文件流...");
//            reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
//            String tempString = null;
//            int line = 1;
//            // 一次读入一行，直到读入null为文件结束
//            while ((tempString = reader.readLine()) != null) {
//                // 显示行号
//                logger.debug("line " + line + ": " + tempString);
//                //内容处理逻辑、
//                String spuId = parseLine(tempString);
//                if (StringUtils.isNotEmpty(spuId)) {
//                    skuIds.add(spuId);
//                }
//                line++;
//            }
//            logger.info("line " + line + ": 读到最后一行结束！！！");
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e1) {
//                }
//            }
//        }
//        return pushSpus;
//    }
//
//    private String parseLine(String line) {
//        if (StringUtils.isEmpty(line)) {
//            return null;
//        }
//        return line.trim();
//    }
//
//    private void parsePushEs() {
//
//        CommonStrategyImpl commonStrategy = new CommonStrategyImpl();
//
//        SpuDao spuDao = new SpuDao();
//        SkuDao skuDao = new SkuDao();
//        PackInfoDao packInfoDao = new PackInfoDao();
//        SkuAreaDao areaDao = new SkuAreaDao();
//        int massPerLength = 100;
//        int spuIdLength = skuIds.size();
//        BigDecimal a = new BigDecimal(massPerLength);
//        BigDecimal b = new BigDecimal(spuIdLength);
////        System.out.println(b.divide(a));
//        long times = b.divide(a).setScale(0, BigDecimal.ROUND_UP).longValue(); // 向上取整
//        int startIndex = 0;
//
//        for (int i = 0; i < times; i++) {
////            System.out.println("第" + i + "段开始");
//            //最后一次
//            if (i == times - 1) {
//                massPerLength = spuIdLength - i * massPerLength;
//            }
//            List<String> subSkus = skuIds.subList(startIndex, startIndex + massPerLength);
//            //ES数据集合
//            List<EsCommodityDTO> resultEsList = Lists.newArrayList();
//            for (String spuIdAndSkuId : subSkus) {
//                String[] arr = spuIdAndSkuId.split(",");
//                String spuId = arr[0];
//                String skuIdStr = arr[1];
//                Long skuId = null;
//                if (StringUtils.isNotEmpty(skuIdStr)) {
//                    skuId = Long.valueOf(skuIdStr);
//                }
//                if (skuId != null) {
//                    EsCommodityDTO skuEs = new EsCommodityDTO();
//                    skuEs.setFspuid(spuId);
//                    skuEs.setFskuid(skuId);
//
//                    packInfoDao.getPackInfosBySkuId(skuEs, spuId, skuId);
//                    List<EsCommodityDTO> resultEsDTOs = areaDao.getEntityIdsBySkuId(skuEs, spuId, skuId);
//                    //构造spu_sku_-1
//                    skuEs.setFentityid(-1);
//                    resultEsDTOs.add(skuEs);
//                    //设置Key
//                    for (EsCommodityDTO resultEs : resultEsDTOs) {
//                        setESKey(resultEs);
//                    }
//                    resultEsList.addAll(resultEsDTOs);
//                }
//            }
//            //设置Key
//            for (EsCommodityDTO resultEs : resultEsList) {
//                setESKey(resultEs);
//            }
//            pushToEs(resultEsList);
//
//            startIndex += massPerLength;
//        }
//        logger.info("PackInfoScheduledExecutor执行结束，共推送[{}]条数据", printCnt);
//
//    }
//
//    private EsCommodityDTO setESKey(EsCommodityDTO esDTO) {
//        esDTO.setEagleType("update");
//        // ES主键校验
//        if (esDTO.getFspuid() == null || "".equals(esDTO.getFspuid())) {
//            logger.warn("Fspuid:{} invalid.", esDTO.getFspuid());
//            return null;
//        }
//        if (esDTO.getFskuid() == null || esDTO.getFskuid() < -1) {
//            logger.warn("Fskuid:{} invalid.", esDTO.getFskuid());
//            return null;
//        }
//        if (esDTO.getFentityid() == null || esDTO.getFentityid() < -1) {
//            logger.warn("Fentityid:{} invalid.", esDTO.getFentityid());
//            return null;
//        }
//
//        esDTO.setEagleTenantId(String.valueOf(esDTO.getFplatformid()));
//        esDTO.setPkey(esDTO.getFspuid() + "_" + esDTO.getFskuid() + "_" + esDTO.getFentityid());
//        return esDTO;
//    }
//
//    private void pushToEs(List<EsCommodityDTO> gEsBoList) {
//        if (gEsBoList.size() > 0) {
//            Iterator it = gEsBoList.iterator();
//            while (it.hasNext()) {
//                EsCommodityDTO esBo = (EsCommodityDTO) it.next();
//                // 发送给Es
//                PerformanceUtil performanceUtil = new PerformanceUtil();
//                int ret = TMQMessageUtil.SendTMQ(esBo);
//                logger.debug("TMQMessageUtil耗时：[{}]", performanceUtil.PERFORM_TIME());
//                if (ret != 0) {
//                    logger.error("push es failed. operator[{PackinfoScheduledExecutor}] spu[{}] sku[{}] entity[{}] code[{}], info:",
//                            esBo.getFspuid(), esBo.getFskuid(), esBo.getFentityid(), ret, esBo.toString());
//                } else {
//                    // key log
//                    logger.debug("push es success. operator[{PackinfoScheduledExecutor}] spu[{}] sku[{}] entity[{}]",
//                            esBo.getFspuid(), esBo.getFskuid(), esBo.getFentityid());
//                }
//                // 日志标识
//                if (printCnt.get() % 200 == 0) {
//                    logger.info("push es success. >>>printCnt=[{}] eventType=[{PackinfoScheduledExecutor}] spuid=[{}] skuid=[{}] entityid=[{}] {}", printCnt, esBo.getFspuid(), esBo.getFskuid(), esBo.getFentityid(), esBo.toString());
//                }
//                if (printCnt.get() >= 90000000000L) {
//                    printCnt.getAndSet(0);
//                }
//                printCnt.getAndIncrement();
//            }
//        }
//    }


}