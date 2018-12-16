package com.news.service.impl;

import com.news.mapper.CatalogMapper;
import com.news.mapper.DepartCatalogMapper;
import com.news.mapper.DepartmentInfoMapper;
import com.news.po.DepartmentPo;
import com.news.po.NewsResult;
import com.news.pojo.*;
import com.news.service.CatalogService;
import com.news.service.DeparmentCatalogService;
import com.news.service.DepartmentService;
import com.news.utils.StateListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    private CatalogService catalogService;
    @Autowired
    private DeparmentCatalogService deparmentCatalogService;



    public NewsResult findDepartmentList() {
        DepartmentInfoExample departmentInfoExample=new DepartmentInfoExample();
        DepartmentInfoExample.Criteria criteria = departmentInfoExample.createCriteria();
        criteria.andDepartmentStateIn(StateListUtils.getStateList());
        List<DepartmentInfo> departmentInfos = departmentInfoMapper.selectByExample(departmentInfoExample);
        return NewsResult.ok(departmentInfos);
    }

    @Override
    public NewsResult findDepartmentPoList() {
        List<DepartmentPo> departmentPos=new ArrayList<DepartmentPo>();
        List<DepartmentInfo> departmentInfos= (List<DepartmentInfo>) this.findDepartmentList().getData();
        List<Catalog> catalogs= (List<Catalog>) catalogService.findCatalogList().getData();
        Map<Integer,Catalog> catalogMap=catalogs.stream().collect(Collectors.toMap(Catalog::getCatalogId,a->a,(k1,k2)->k1));
        for (DepartmentInfo department:departmentInfos) {
            List<Catalog> catalogList=new ArrayList<Catalog>();
            List<DepartCatalog> departCatalogs = (List<DepartCatalog>) deparmentCatalogService.findDepartmentCatalofListByDid(department.getDepartmentId()).getData();
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
    public NewsResult updateDepartment(DepartmentInfo departmentInfo,List<Integer> cids) {
        this.updateDepartment(departmentInfo);
        deparmentCatalogService.updateDepartmentCatalog(departmentInfo.getDepartmentId(),cids);
        return NewsResult.ok();
    }

    @Override
    public NewsResult updateDepartment(DepartmentInfo departmentInfo) {
        departmentInfoMapper.updateByPrimaryKeySelective(departmentInfo);
        if (departmentInfo.getDepartmentState()!=null){
            if (departmentInfo.getDepartmentState().equals("3")){
                deparmentCatalogService.deleteDepartmentCatalogByDid(departmentInfo.getDepartmentId());
            }
        }
        return NewsResult.ok();
    }

    @Override
    public NewsResult findDepartmentPoById(Integer deparmentId) {
        DepartmentPo departmentPo=new DepartmentPo();
        DepartmentInfo departmentInfo = (DepartmentInfo) this.findDepartmentById(deparmentId).getData();
        departmentPo.setDepartmentInfo(departmentInfo);
        List<DepartCatalog> departCatalogs = (List<DepartCatalog>) deparmentCatalogService.findDepartmentCatalofListByDid(departmentInfo.getDepartmentId()).getData();
        List<Integer> cid=new ArrayList<Integer>();
        for (DepartCatalog dc:departCatalogs) {
            cid.add(dc.getCatalogId());
        }
        List<Catalog> catalogs =new ArrayList<Catalog>();
        if (!cid.isEmpty()){
            catalogs= (List<Catalog>) catalogService.findCatalogListByCids(cid).getData();
        }
        departmentPo.setCatalogs(catalogs);
        return NewsResult.ok(departmentPo);
    }

    @Override
    public NewsResult findDepartmentById(Integer deparmentId) {
        DepartmentInfo departmentInfo = departmentInfoMapper.selectByPrimaryKey(deparmentId);
        return NewsResult.ok(departmentInfo);
    }

    @Override
    public NewsResult findDepartmentByName(String departmentName) {
        DepartmentInfoExample departmentInfoExample=new DepartmentInfoExample();
        DepartmentInfoExample.Criteria criteria = departmentInfoExample.createCriteria();
        criteria.andDepartmentNameEqualTo(departmentName);
        criteria.andDepartmentStateIn(StateListUtils.getStateList());
        List<DepartmentInfo> departmentInfos = departmentInfoMapper.selectByExample(departmentInfoExample);
        if (departmentInfos.isEmpty()){
            return NewsResult.build(400,"该部门不存在");
        }
        return NewsResult.ok(departmentInfos);
    }

    @Override
    public NewsResult saveDepartment(DepartmentInfo departmentInfo,List<Integer> cids) {
        departmentInfo.setDepartmentTime(new Date());
        departmentInfo.setDepartmentState("1");
        departmentInfoMapper.insertSelective(departmentInfo);
        deparmentCatalogService.saveDepartmentCatalog(departmentInfo.getDepartmentId(),cids);
        return NewsResult.ok();
    }

    @Override
    public NewsResult updateDepartmentLikman(String departmentLikman) {
        DepartmentInfoExample departmentInfoExample=new DepartmentInfoExample();
        DepartmentInfoExample.Criteria criteria = departmentInfoExample.createCriteria();
        criteria.andDepartmentLikmanEqualTo(departmentLikman);
        List<DepartmentInfo> departmentInfos = departmentInfoMapper.selectByExample(departmentInfoExample);
        for (DepartmentInfo departmentInfo:departmentInfos){
            departmentInfo.setDepartmentLikman("");
            updateDepartment(departmentInfo);
        }
        return NewsResult.ok();
    }

}
