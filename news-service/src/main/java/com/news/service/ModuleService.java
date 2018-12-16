package com.news.service;

import com.news.po.NewsResult;

import java.util.List;

/**
 * @ClassName ModuleService
 * @Author One_llx
 * @Date 2018/12/12 0012 下午 3:39
 * @Version 1.0
 */
public interface ModuleService {

    /**
     * 通过管理员ID查找出该管理员可以使用的模块信息
     * @param mids
     * @return
     */
    NewsResult findModuleByMids(List<Integer> mids);
}
