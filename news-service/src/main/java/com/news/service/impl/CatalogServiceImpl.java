package com.news.service.impl;

import com.news.mapper.CatalogMapper;
import com.news.po.NewsResult;
import com.news.pojo.Catalog;
import com.news.pojo.CatalogExample;
import com.news.pojo.Manager;
import com.news.service.CatalogService;
import com.news.service.DeparmentCatalogService;
import com.news.service.ManagerService;
import com.news.utils.StateListUtils;
import com.news.utils.SysConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CatalogServiceImpl
 * @Author One_llx
 * @Date 2018/11/27 0027 下午 11:19
 * @Version 1.0
 */
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogMapper catalogMapper;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private DeparmentCatalogService deparmentCatalogService;


    @Override
    public NewsResult findCatalogList() {
        CatalogExample catalogExample=new CatalogExample();
        CatalogExample.Criteria criteria = catalogExample.createCriteria();
        criteria.andCatalogStateIn(StateListUtils.getStateList());
        List<Catalog> catalogs = catalogMapper.selectByExample(catalogExample);
        return NewsResult.ok(catalogs);
    }

    @Override
    public NewsResult updateCatalog(Catalog catalog) {
        catalogMapper.updateByPrimaryKeySelective(catalog);
        if (catalog.getCatalogState()!=null){
            if (catalog.getCatalogState().equals("3")){
                deparmentCatalogService.deleteDepartmentCatalogByCid(catalog.getCatalogId());
            }
        }
        return NewsResult.ok();
    }

    @Override
    public NewsResult findCatalogById(Integer id) {
        Catalog catalog = catalogMapper.selectByPrimaryKey(id);
        return NewsResult.ok(catalog);
    }

    @Override
    public NewsResult saveCatalog(Catalog catalog) {
        catalog.setCatalogState("1");
        catalogMapper.insertSelective(catalog);
        Integer cid=catalog.getCatalogId();
        //
        deparmentCatalogService.saveDeparmentCatalog(cid,SysConstant.SUPER_DEPARMENT_ID);
        return NewsResult.ok();
    }

    @Override
    public NewsResult findCatalogByName(String cataologName) {
        CatalogExample catalogExample=new CatalogExample();
        CatalogExample.Criteria criteria = catalogExample.createCriteria();
        criteria.andCatalogNameEqualTo(cataologName);
        criteria.andCatalogStateIn(StateListUtils.getStateList());
        List<Catalog> catalogs = catalogMapper.selectByExample(catalogExample);
        if (catalogs.isEmpty()){
            return NewsResult.build(400,"该栏目不存在");
        }
        return NewsResult.ok();
    }
}
