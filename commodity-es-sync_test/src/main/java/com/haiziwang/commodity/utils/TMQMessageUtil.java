package com.haiziwang.commodity.utils;

import com.alibaba.fastjson.JSON;
import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.model.dto.EsCommodityDTO;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class TMQMessageUtil {


    private static Logger logger = LoggerFactory.getLogger(TMQMessageUtil.class);

    /**
     * 批量推送商品信息
     *
     * @param esCommodity
     * @return
     */
    public static synchronized int SendTMQ(EsCommodityDTO esCommodity) {
        Map<String, Object> param = new HashedMap();
        Map<String, Object> req = new HashedMap();
        req.put("appcode", Constant.APP_CODE);
        req.put("topic", Constant.MQ_TOPIC);
        req.put("token", Constant.MQ_TOKEN);
        req.put("msgkey", esCommodity.getFspuid());
        req.put("_platform_num", esCommodity.getFplatformid());
        req.put("content", JSON.toJSONString(esCommodity));
        //String jsonData = JSON.toJSONString(esCommodity);
        //req.put("_platform_num", riskEvenet.getPlatformId());
        param.put("req", req);
        String strParam = JSON.toJSONString(param);
        logger.debug("--->Send Tmq Msg: \n{}", strParam);

        String resp = doPost(Constant.MQ_URL, strParam);
        if (StringUtils.isEmpty(resp)) {
            logger.error("发送TQM消息失败， 消息[{}]", strParam);
            return -1;
        } else {
            logger.debug("resp: {}", resp);
            Map<String, Object> respMap = JSON.parseObject(resp);
            if (respMap != null && respMap.size() > 0) {
                if (respMap.containsKey("errno") && (Integer) respMap.get("errno") == 0) {
                    logger.debug(">>发送TQM消息成功， url[{}], data[{}]", Constant.MQ_URL, strParam);
                    return 0;
                }
            }
            logger.error(">>发送风险事件回参错误, resp[{}] data[{}]", resp, strParam);
        }
        return -1;
    }

    private static String doPost(String url, Map params) {
        BufferedReader in = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(10000).setConnectionRequestTimeout(10000)
                .setSocketTimeout(10000).build();
        httpPost.setConfig(requestConfig);
//        httpPost.setHeader("Accept", "application/json; charset=utf-8");
//        httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
        try {
            httpPost.setURI(new URI(url));
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (Iterator iter = params.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String value = String.valueOf(params.get(name));
                nvps.add(new BasicNameValuePair(name, value));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
            HttpResponse response = httpclient.execute(httpPost);
            int code = response.getStatusLine().getStatusCode();
            if (code == 200)    //请求成功
            {
                in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }
                in.close();
                return sb.toString();
            } else {
                logger.error("HTTP Post请求{}失败， code:{}", url, code);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String doPost(String url, String params) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String responseBody = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader(HttpHeaders.ACCEPT, "application/json; charset=utf-8");
            httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
            httpPost.setHeader(HttpHeaders.CONNECTION, "close");
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(10000).setConnectionRequestTimeout(10000)
                    .setSocketTimeout(10000).build();
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = new StringEntity(params, "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            httpPost.setEntity(stringEntity);
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response)
                        throws ClientProtocolException, IOException {//
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException(
                                "Unexpected response status: " + status);
                    }
                }
            };
            try {
                responseBody = httpclient.execute(httpPost, responseHandler);
            } catch (IOException e) {
                logger.error("HTTP Post请求{}异常， msg:{}", url, getErrorStack(e, 0));
            }
            httpPost.releaseConnection();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseBody;
    }

    public static String getErrorStack(Exception e, int length) {
        String error = null;
        if (e != null) {
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                e.printStackTrace(ps);
                error = baos.toString();
                if (length > 0) {
                    if (length > error.length()) {
                        length = error.length();
                    }
                    error = error.substring(0, length);
                }
                baos.close();
                ps.close();
            } catch (Exception e1) {
                error = e.toString();
            }
        }
        /*
         * try{ String str=new String(error.getBytes("ISO-8859-1"),"GBK");
         * return str; }catch(Exception e1) { e1.printStackTrace(); }
         */
        return error;
    }




}
