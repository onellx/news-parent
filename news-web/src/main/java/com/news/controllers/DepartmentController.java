package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import com.news.po.DepartmentPo;
import com.news.po.NewsResult;
import com.news.pojo.Catalog;
import com.news.pojo.DepartmentInfo;
import com.news.service.CatalogService;
import com.news.service.DeparmentCatalogService;
import com.news.service.DepartmentService;
import com.news.service.ManagerService;
import com.news.utils.JsonUtils;
import com.news.utils.ListUtils;
import com.news.utils.SysConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private DeparmentCatalogService deparmentCatalogService;

    @RequestMapping(value = "department-list",method = RequestMethod.GET)
    @SystemControllerLog(description = "获取部门列表")
    public String departmentList(Model model){
        List<DepartmentPo> departmentPos = (List<DepartmentPo>) departmentService.findDepartmentPoList().getData();
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
        DepartmentPo departmentPo = (DepartmentPo) departmentService.findDepartmentPoById(id).getData();
        model.addAttribute("departmentPo",departmentPo);
        List<Catalog> catalogs = (List<Catalog>) catalogService.findCatalogList().getData();
        List<Catalog> catalogs1 = ListUtils.removeList(catalogs, departmentPo.getCatalogs());
        model.addAttribute("catalogs",catalogs1);
        return "department-edit";
    }

    @RequestMapping(value="department/update",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String department_update(DepartmentInfo departmentInfo,String catalogId){
        List<Integer> cids = new ArrayList<Integer>();
        if (departmentInfo.getDepartmentId()!=SysConstant.SUPER_DEPARMENT_ID) {
            if (catalogId!=null){
                String[] split = catalogId.split(",");
                for (String s : split) {
                    cids.add(Integer.parseInt(s));
                }
            }

        }
        departmentService.updateDepartment(departmentInfo,cids);
        return "true";
    }

    @RequestMapping(value="department/checkname",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String department_checkName(String departmentName){

        NewsResult newsResult = departmentService.findDepartmentByName(departmentName);
        if (newsResult.getStatus()==200){
            return "false";
        }
        return "true";
    }

    @RequestMapping(value="department/checklikman",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String department_checkLinkman(String departmentLikman){
        NewsResult newsResult = managerService.finManagerByName(departmentLikman);
        if (newsResult.getStatus()==200){
            return "true";
        }
        return "false";
    }

    @RequestMapping(value = "department-add",method = RequestMethod.GET)
    @SystemControllerLog(description = "显示添加部门页面")
    public String savedepartment(Model model){
        List<Catalog> catalogs = (List<Catalog>) catalogService.findCatalogList().getData();
        model.addAttribute("catalogs",catalogs);
        return "department-add";
    }

    @RequestMapping(value="department/add",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String department_add(DepartmentInfo departmentInfo,String catalogId){
        String[] split = catalogId.split(",");
        List<Integer> cids=new ArrayList<Integer>();
        for (String s:split){
            cids.add(Integer.parseInt(s));
        }
        departmentService.saveDepartment(departmentInfo,cids);
        return "true";
    }






}
