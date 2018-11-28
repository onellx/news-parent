package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import com.news.po.NewsResult;
import com.news.pojo.Catalog;
import com.news.service.CatalogService;
import com.news.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @ClassName CatalogController
 * @Author One_llx
 * @Date 2018/11/21 0021 下午 4:16
 * @Version 1.0
 */
@Controller
public class CatalogController {

    @Autowired
    private CatalogService catalogService;


    @RequestMapping(value = "system-category",method = RequestMethod.GET)
    @SystemControllerLog(description = "获取栏目列表")
    public String catalogList(Model model){
        List<Catalog> catalogs = (List<Catalog>) catalogService.catalogList().getData();
        model.addAttribute("catalogs",catalogs);
        return "system-category";
    }

    @RequestMapping(value="catalog/upatestate",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String changestate( String id,String state){

        Catalog catalog=new Catalog();
        catalog.setCatalogId(JsonUtils.jsonToPojo(id,Integer.class));
        catalog.setCatalogState(state);
        NewsResult newsResult = catalogService.updateCatalog(catalog);
        if (newsResult.getStatus()!=200){
            return "false";
        }
        return "true";
    }

    @RequestMapping(value = "catalog-edit/{id}",method = RequestMethod.GET)
    @SystemControllerLog(description = "修改栏目信息页面")
    public String editCatalog(Model model, @PathVariable Integer id){
        Catalog catalog= (Catalog) catalogService.findCatalogById(id).getData();
        model.addAttribute("catalog",catalog);
        return "system-category-edit";
    }

    @RequestMapping(value="catalog/update",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String manager_update(Catalog catalog){
        System.out.println(catalog.getCatalogId()+"ss"+catalog.getCatalogName());
        NewsResult newsResult = catalogService.updateCatalog(catalog);
        if (newsResult.getStatus()==200){
            return "true";
        }
        return "false";
    }



}
