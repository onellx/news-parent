package com.news.service.impl;

import com.news.mapper.ModuleMapper;
import com.news.po.NewsResult;
import com.news.pojo.Module;
import com.news.pojo.ModuleExample;
import com.news.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ModuleServiceImpl
 * @Author One_llx
 * @Date 2018/12/12 0012 下午 3:39
 * @Version 1.0
 */
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public NewsResult findModuleByMids(List<Integer> mids) {
        //更据模块id查找模块
        ModuleExample moduleExample=new ModuleExample();
        ModuleExample.Criteria criteria2 = moduleExample.createCriteria();
        criteria2.andModuleIdIn(mids);
        List<Module> resList = moduleMapper.selectByExample(moduleExample);
        return NewsResult.ok(resList);
    }
}
