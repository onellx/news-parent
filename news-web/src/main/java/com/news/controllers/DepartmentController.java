package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import com.news.po.DepartmentPo;
import com.news.po.NewsResult;
import com.news.pojo.Catalog;
import com.news.pojo.DepartmentInfo;
import com.news.service.DepartmentService;
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
 * @ClassName DepartmentController
 * @Author One_llx
 * @Date 2018/11/28 0028 下午 3:27
 * @Version 1.0
 */

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "department-list",method = RequestMethod.GET)
    @SystemControllerLog(description = "获取部门列表")
    public String departmentList(Model model){
        List<DepartmentPo> departmentPos = (List<DepartmentPo>) departmentService.departmentPoList().getData();
        model.addAttribute("departmentPos",departmentPos);
        return "department-list";
    }

    @RequestMapping(value="department/upatestate",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String changestate( String id,String state){
        DepartmentInfo departmentInfo=new DepartmentInfo();
        departmentInfo.setDepartmentId(JsonUtils.jsonToPojo(id,Integer.class));
        departmentInfo.setDepartmentState(state);
        NewsResult newsResult = departmentService.updateDepartment(departmentInfo);
        if (newsResult.getStatus()!=200){
            return "false";
        }
        return "true";
    }

    @RequestMapping(value = "department-edit/{id}",method = RequestMethod.GET)
    @SystemControllerLog(description = "修改部门信息页面")
    public String editCatalog(Model model, @PathVariable Integer id){



        return "department-edit";
    }

    @RequestMapping(value="department/update",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String manager_update(Catalog catalog){

        return "false";
    }






}
