package com.news.service.impl;

import com.news.mapper.CatalogMapper;
import com.news.mapper.DepartCatalogMapper;
import com.news.mapper.DepartmentInfoMapper;
import com.news.po.DepartmentPo;
import com.news.po.NewsResult;
import com.news.pojo.*;
import com.news.service.CatalogService;
import com.news.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName DepartmentServiceImpl
 * @Author One_llx
 * @Date 2018/11/22 0022 下午 5:21
 * @Version 1.0
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentInfoMapper departmentInfoMapper;

    @Autowired
    private DepartCatalogMapper departCatalogMapper;
    @Autowired
    private CatalogMapper catalogMapper;
    @Autowired
    private CatalogService catalogService;


    public NewsResult departmentList() {

        List<String> sids=new ArrayList<String>();
        sids.add("1");
        sids.add("2");
        DepartmentInfoExample departmentInfoExample=new DepartmentInfoExample();
        DepartmentInfoExample.Criteria criteria = departmentInfoExample.createCriteria();
        criteria.andDepartmentStateIn(sids);
        List<DepartmentInfo> departmentInfos = departmentInfoMapper.selectByExample(departmentInfoExample);

        return NewsResult.ok(departmentInfos);
    }

    @Override
    public NewsResult departmentPoList() {
        List<DepartmentPo> departmentPos=new ArrayList<DepartmentPo>();
        List<DepartmentInfo> departmentInfos= (List<DepartmentInfo>) this.departmentList().getData();
        List<Catalog> catalogs= (List<Catalog>) catalogService.catalogList().getData();
        Map<Integer,Catalog> catalogMap=catalogs.stream().collect(Collectors.toMap(Catalog::getCatalogId,a->a,(k1,k2)->k1));
        for (DepartmentInfo department:departmentInfos) {
            List<Catalog> catalogList=new ArrayList<Catalog>();
            DepartCatalogExample departCatalogExample=new DepartCatalogExample();
            DepartCatalogExample.Criteria criteria = departCatalogExample.createCriteria();
            criteria.andDepartmentIdEqualTo(department.getDepartmentId());
            List<DepartCatalog> departCatalogs = departCatalogMapper.selectByExample(departCatalogExample);
            for (DepartCatalog dc:departCatalogs) {
                catalogList.add(catalogMap.get(dc.getCatalogId()));
            }
            DepartmentPo departmentPo=new DepartmentPo();
            departmentPo.setDepartmentInfo(department);
            departmentPo.setCatalogs(catalogList);
            departmentPos.add(departmentPo);
        }

        return NewsResult.ok(departmentPos);
    }

    @Override
    public NewsResult updateDepartment(DepartmentInfo departmentInfo) {
        departmentInfoMapper.updateByPrimaryKeySelective(departmentInfo);
        return NewsResult.ok();
    }
}
