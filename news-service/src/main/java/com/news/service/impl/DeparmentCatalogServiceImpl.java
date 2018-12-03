package com.news.service.impl;

import com.news.mapper.DepartCatalogMapper;
import com.news.po.NewsResult;
import com.news.pojo.DepartCatalog;
import com.news.pojo.DepartCatalogExample;
import com.news.service.DeparmentCatalogService;
import com.news.utils.SysConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DeparmentCatalogServiceImpl
 * @Author One_llx
 * @Date 2018/11/29 0029 下午 2:51
 * @Version 1.0
 */
@Service
public class DeparmentCatalogServiceImpl implements DeparmentCatalogService {

    @Autowired
    private DepartCatalogMapper departCatalogMapper;

    @Override
    public NewsResult saveDeparmentCatalog(Integer cid, Integer did) {
        DepartCatalog departCatalog=new DepartCatalog();
        departCatalog.setCatalogId(cid);
        departCatalog.setDepartmentId(did);
        departCatalogMapper.insert(departCatalog);
        return NewsResult.ok();
    }

    @Override
    public NewsResult updateDepartmentCatalog(Integer did, List<Integer> cids) {
        if (did!=SysConstant.SUPER_DEPARMENT_ID){
            this.deleteDepartmentCatalogByDid(did);
            return this.saveDepartmentCatalog(did,cids);
        }else {
            return NewsResult.ok();
        }
    }

    @Override
    public NewsResult saveDepartmentCatalog(Integer did, List<Integer> cids) {
        for (Integer cid:cids) {
            this.saveDeparmentCatalog(cid,did);
        }
        return NewsResult.ok();
    }


    @Override
    public NewsResult deleteDepartmentCatalogByCid(Integer cid) {
        DepartCatalogExample departCatalogExample=new DepartCatalogExample();
        DepartCatalogExample.Criteria criteria = departCatalogExample.createCriteria();
        criteria.andCatalogIdEqualTo(cid);
        departCatalogMapper.deleteByExample(departCatalogExample);
        return NewsResult.ok();
    }

    @Override
    public NewsResult deleteDepartmentCatalogByDid(Integer did) {
        DepartCatalogExample departCatalogExample=new DepartCatalogExample();
        DepartCatalogExample.Criteria criteria = departCatalogExample.createCriteria();
        criteria.andDepartmentIdEqualTo(did);
        departCatalogMapper.deleteByExample(departCatalogExample);
        return NewsResult.ok();
    }
}
