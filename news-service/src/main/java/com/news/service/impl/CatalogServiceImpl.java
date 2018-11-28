package com.news.service.impl;

import com.news.mapper.CatalogMapper;
import com.news.po.NewsResult;
import com.news.pojo.Catalog;
import com.news.pojo.CatalogExample;
import com.news.service.CatalogService;
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


    @Override
    public NewsResult catalogList() {
        CatalogExample catalogExample=new CatalogExample();
        CatalogExample.Criteria criteria = catalogExample.createCriteria();
        List<String> states=new ArrayList<String>();
        states.add("1");
        states.add("2");
        criteria.andCatalogStateIn(states);
        List<Catalog> catalogs = catalogMapper.selectByExample(catalogExample);
        return NewsResult.ok(catalogs);
    }

    @Override
    public NewsResult updateCatalog(Catalog catalog) {
        catalogMapper.updateByPrimaryKeySelective(catalog);
        return NewsResult.ok();
    }

    @Override
    public NewsResult findCatalogById(Integer id) {
        Catalog catalog = catalogMapper.selectByPrimaryKey(id);
        return NewsResult.ok(catalog);
    }
}
