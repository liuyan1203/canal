package com.haiziwang.commodity.cpp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haiziwang.commodity.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class CachePeerIp {

    private static final Logger logger = LoggerFactory.getLogger(CachePeerIp.class);
    private static volatile CachePeerIp instance = null;

    private static Vector<String> A001IPs = new Vector<>();
    private static Vector<String> A016IPs = new Vector<>();

    private CachePeerIp() {
    }

    public static CachePeerIp getInstance() {
        if (instance == null) {
            synchronized (CachePeerIp.class) {
                if (instance == null) {
                    instance = new CachePeerIp();
                }

            }
        }
        return instance;
    }

    public static Vector<String> getA001IPs(String cmd) {
        if (A001IPs.size() == 0) {
            try {
                A001IPs.addAll(getPeerIp(cmd));
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        return A001IPs;
    }

    public static Vector<String> getA016IPs(String cmd) {
        if (A016IPs.size() == 0) {
            try {
                A016IPs.addAll(getPeerIp(cmd));
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        return A016IPs;
    }

    public static void clear() {
        A001IPs.clear();
        A016IPs.clear();
    }

    public static Vector<String> setA001IPs(String cmd) {
        try {
            A001IPs.clear();
            A001IPs.addAll(getPeerIp(cmd));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return A001IPs;
    }

    public static Vector<String> setA016IPs(String cmd) {
        try {
            A016IPs.clear();
            A016IPs.addAll(getPeerIp(cmd));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return A016IPs;
    }

    /**
     * 随机取一个
     *
     * @param cmd
     * @return
     */
    public static String getA001RandomIP(String cmd) {
        getA001IPs(cmd);
        Random random = new Random();
        int index = random.nextInt(A001IPs.size());
        return A001IPs.get(index);
    }

    public static String getA016RandomIP(String cmd) {
        getA016IPs(cmd);
        Random random = new Random();
        int index = random.nextInt(A016IPs.size());
        return A016IPs.get(index);
    }

    private static List<String> getPeerIp(String cmd) throws Exception {
//        String url = "http://172.172.178.16:9090/esf-web/cpp/cppServiceList.do";
        String url = Constant.ESF_SRV;
        if (url.isEmpty()) {
            throw new Exception("get esf properties failed");
        }
        url += "?reportload=0&aoData=[{\"name\":\"theme\",\"value\":\"" + cmd + "\"}]";
        System.out.println("url:" + url);
        String charset = "UTF-8";
        StringBuffer content = new StringBuffer();
        URL realUrl = new URL(url);
        // 打开和URL之间的连接
        URLConnection connection = realUrl.openConnection();
        // 设置通用的请求属性
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        // 建立实际的连接
        connection.setConnectTimeout(5000);
        connection.connect();
        // 定义 BufferedReader输入流来读取URL的响应
        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream(), charset));
        String line;
        while ((line = in.readLine()) != null) {
            content.append(line);
        }
//        System.out.println("content:" + content.toString());

        JSONObject jsonRoot = JSON.parseObject(content.toString());
        // 随机从返回列表中取一个
        JSONObject jsonData = JSON.parseObject(jsonRoot.getString("data"));
//        int count = jsonData.getInteger("iTotalRecords");
//        int index = (int) Math.random() % count;
        // 服务数组
        List<String> result = new ArrayList();
        JSONArray srvArray = jsonData.getJSONArray("aaData");

        StringBuffer ipLog = new StringBuffer();
        for (int i = 0; i < srvArray.size(); i++) {
            String address = srvArray.getJSONObject(i).getString("address");
            result.add(address);
            ipLog.append(address).append("|");
        }
        logger.info("esf获取ip[{}]", ipLog.toString());
        return result;
    }

//    public static void main(String[] args) {
//        try {
//            A001IPs.add("1");
//            A001IPs.add("2");
//            A001IPs.add("3");
//            A001IPs.add("4");
//            A001IPs.add("5");
//
//            for (int i = 0; i < 1000; i++) {
//                String ip = getA001RandomIP("");
//                System.out.println(ip);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}