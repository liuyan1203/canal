package com.haiziwang.commodity.cpp.service;

import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.cpp.CachePeerIp;
import com.haiziwang.commodity.cpp.request.BrandFilter;
import com.haiziwang.commodity.cpp.request.GetBrandByIdReq;
import com.haiziwang.commodity.cpp.request.GetBrandListReq;
import com.haiziwang.commodity.cpp.request.GetBrandsByIdReq;
import com.haiziwang.commodity.cpp.response.Brand;
import com.haiziwang.commodity.cpp.response.GetBrandByIdResp;
import com.haiziwang.commodity.cpp.response.GetBrandListResp;
import com.haiziwang.commodity.cpp.response.GetBrandsByIdResp;
import com.haiziwang.commodity.model.dto.EsCommodityDTO;
import com.haiziwang.commodity.utils.PerformanceUtil;
import com.paipai.component.c2cplatform.WebStubCntl;
import com.paipai.lang.uint32_t;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CppBrandService {
    private static final Logger logger = LoggerFactory.getLogger(CppBrandService.class);

    /**
     * 获取线上品牌（内存）
     *
     * @param brandId
     * @return
     */
    public Brand getBrandsById(EsCommodityDTO es, Long brandId) {
        PerformanceUtil performanceUtil = new PerformanceUtil();
        GetBrandsByIdResp resp = queryBrandsById(es, brandId);
        logger.debug("GetBrandsByIdReq获取品牌耗时：[{}]", performanceUtil.PERFORM_TIME());
        if (resp.getBrands() != null && resp.getBrands().keySet().size() > 0) {
            uint32_t t = new uint32_t();
            t.setValue(brandId);
            return resp.getBrands().get(t);
        }
        return null;
    }

    /**
     * 线上品牌
     *
     * @param brandId
     * @return
     */
    private GetBrandsByIdResp queryBrandsById(EsCommodityDTO es, Long brandId) {
        WebStubCntl cppStub = new WebStubCntl();
        String ip = CachePeerIp.getInstance().getA001RandomIP("A001");
        cppStub.setPeerIPPort(ip, Constant.CPP_SERVICE_PORT);
        cppStub.setTimeout_ms(10000);
        //cppStub.setDwUin(uid);

        GetBrandsByIdReq req = new GetBrandsByIdReq();
        Set<uint32_t> query = new HashSet<>();
        uint32_t t = new uint32_t();
        t.setValue(brandId);
        query.add(t);
        req.setBrandId(query);
        GetBrandsByIdResp resp = new GetBrandsByIdResp();
        try {
            cppStub.invoke(req, resp, 1024 * 1024);
        } catch (Exception ex) {
            logger.error("GetBrandsByIdReq 获取品牌信息异常，es[{}] brandId[{}] ex[{}]", es.toString(), brandId, ex.getMessage());
            return null;
        }
        return resp;
    }

    /**
     * 获取线下品牌
     * @param erpBrandId
     * @return
     */
    public Brand getErpBrand(EsCommodityDTO es, String erpBrandId) {
        WebStubCntl cppStub = new WebStubCntl();
        String ip = CachePeerIp.getInstance().getA016RandomIP("A016");
        cppStub.setPeerIPPort(ip, Constant.CPP_SERVICE_PORT);
        cppStub.setTimeout_ms(10000);

        BrandFilter filter = new BrandFilter();
        filter.setErpBrandId(erpBrandId);
        GetBrandListReq req = new GetBrandListReq();
        req.setInReserve("1");
        req.setFilter(filter);

        GetBrandListResp resp = new GetBrandListResp();
        try {
            cppStub.invoke(req, resp, 1024 * 1024);
        } catch (Exception ex) {
            logger.error("GetBrandsByIdReq 获取线下品牌信息异常， es[{}] erpBrandId[{}] ex[{}]", es.toString(), erpBrandId, ex.getMessage());
            return null;
        }
        List<Brand> brandList = resp.getBrandList();
        return CollectionUtils.isEmpty(brandList) ? null : brandList.get(0);
    }

//    public static void main(String[] args) {
//        Brand brand = getErpBrand("5993");
//        System.out.println(brand.getErpBrandName());
//
//        Brand brand1 = getBrandsById(858L);
//        System.out.println(brand1.getBrandName());
//    }

}