package com.haiziwang.commodity.cpp.service;

import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.cpp.CachePeerIp;
import com.haiziwang.commodity.cpp.request.GetPathByErpClassId_WGReq;
import com.haiziwang.commodity.cpp.request.GetPathByNavId_WGReq;
import com.haiziwang.commodity.cpp.response.GetPathByErpClassId_WGResp;
import com.haiziwang.commodity.cpp.response.GetPathByNavId_WGResp;
import com.haiziwang.commodity.cpp.response.NavEntryDdo;
import com.haiziwang.commodity.model.dto.EsCommodityDTO;
import com.haiziwang.commodity.utils.PerformanceUtil;
import com.paipai.component.c2cplatform.WebStubCntl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class CppCategaryService {

    private static final Logger logger = LoggerFactory.getLogger(CppCategaryService.class);

    public Vector<NavEntryDdo> queryPathByNavId(EsCommodityDTO es, Long navId, Long mapId) {
        PerformanceUtil performanceUtil = new PerformanceUtil();
        GetPathByNavId_WGResp resp = getPathByNavId(es, navId, mapId);
        logger.debug("GetPathByNavId_WGReq获取类目耗时：[{}]", performanceUtil.PERFORM_TIME());
        return null == resp ? null : resp.getFullPath();
    }

    public Vector<NavEntryDdo> queryPathByErpClassId(EsCommodityDTO es, String erpClassId, Long mapId) {
        PerformanceUtil performanceUtil = new PerformanceUtil();
        GetPathByErpClassId_WGResp resp = getPathByErpClassId(es, erpClassId, mapId);
        logger.debug("GetPathByErpClassId_WGReq获取类目耗时：[{}]", performanceUtil.PERFORM_TIME());
        return null == resp ? null : resp.getFullPath();
    }

    /**
     * 根据分类id 获取线上发布导航4个节点
     *
     * @param navId
     * @param mapId
     * @return
     */
    private GetPathByNavId_WGResp getPathByNavId(EsCommodityDTO es, Long navId, Long mapId) {
        WebStubCntl cppStub = new WebStubCntl();
        String ip = CachePeerIp.getInstance().getA001RandomIP("A001");
        cppStub.setPeerIPPort(ip, Constant.CPP_SERVICE_PORT);
        cppStub.setTimeout_ms(10000); // 1.5秒超时
        //cppStub.setDwUin(uid);

        GetPathByNavId_WGReq req = new GetPathByNavId_WGReq();
        GetPathByNavId_WGResp resp = new GetPathByNavId_WGResp();
        req.setSource("haiziwang PMC");
        req.setMachineKey(this.getClass().getName());
        req.setSceneId(0L);
        req.setNavId(navId);
        req.setMapId(mapId);

        try {
            cppStub.invoke(req, resp, 1024 * 1024);
        } catch (Exception ex) {
            logger.error("GetPathByNavId_WGResp 获取发布导航信息异常，es[{}] navId[{}] mapId[{}] ex[{}]", es.toString(), navId, mapId, ex.getMessage());
            return null;
        }
        return resp;
    }

    private GetPathByErpClassId_WGResp getPathByErpClassId(EsCommodityDTO es, String erpClassId, Long mapId) {
        WebStubCntl cppStub = new WebStubCntl();
        String ip = CachePeerIp.getInstance().getA001RandomIP("A001");
        cppStub.setPeerIPPort(ip, Constant.CPP_SERVICE_PORT);
        cppStub.setTimeout_ms(10000); // 1.5秒超时
        //cppStub.setDwUin(uid);

        GetPathByErpClassId_WGReq req = new GetPathByErpClassId_WGReq();
        GetPathByErpClassId_WGResp resp = new GetPathByErpClassId_WGResp();
        req.setSource("haiziwang PMC");
        req.setMachineKey(this.getClass().getName());
        req.setSceneId(0L);
        req.setErpClassId(erpClassId);
        req.setMapId(mapId);

        try {
            cppStub.invoke(req, resp, 1024 * 1024);
        } catch (Exception ex) {
            logger.error("GetPathByNavId_WGResp 获取发布导航信息异常，es[{}] erpClassId[{}] mapId[{}] ex[{}]", es.toString(), erpClassId, mapId, ex.getMessage());
            return null;
        }
        return resp;
    }

}