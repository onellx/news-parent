package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import com.news.po.ManagerPo;
import com.news.po.NewsResult;
import com.news.pojo.DepartmentInfo;
import com.news.pojo.Manager;
import com.news.pojo.Role;
import com.news.service.DepartmentService;
import com.news.service.ManagerRoleService;
import com.news.service.ManagerService;
import com.news.service.RoleService;
import com.news.utils.Encrypt;
import com.news.utils.JsonUtils;
import com.news.utils.SysConstant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.SecurityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ManagerController
 * @Author One_llx
 * @Date 2018/11/20 0020 上午 8:43
 * @Version 1.0
 */
@Controller
public class ManagerController {


    @Autowired
    private ManagerService managerService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private DepartmentService departmentService;



    @RequestMapping(value = "admin-list",method = RequestMethod.GET)
    @SystemControllerLog(description = "获取管理员列表")
    public String managerList(Model model){
        NewsResult newsResult = managerService.managerList();


        List<ManagerPo> managers= (List<ManagerPo>) newsResult.getData();
        model.addAttribute("managerpos",managers);
        return "admin-list";
    }
    @RequestMapping(value = "welcome",method = RequestMethod.GET)
    @SystemControllerLog(description = "欢迎页")
    public String welcome(Model model){
        return "welcome";
    }


    @RequestMapping(value="manager/upatestate",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String changestate( String id,String state){
        Manager manager=new Manager();
        manager.setManagerId(JsonUtils.jsonToPojo(id,Integer.class));
        manager.setManagerState(state);
        managerService.updateManager(manager);
        return "true";
    }

    @RequestMapping(value = "admin-edit/{id}",method = RequestMethod.GET)
    @SystemControllerLog(description = "修改管理员个人信息页面")
    public String editAdmin(Model model, @PathVariable Integer id){

        List<Role> roles= (List<Role>) roleService.RoleList().getData();
        List<DepartmentInfo> departmentInfos= (List<DepartmentInfo>) departmentService.departmentList().getData();
        model.addAttribute("roles",roles);
        model.addAttribute("departmentInfos",departmentInfos);

        if (id!=null&&id!=0){
            NewsResult newsResult = managerService.findManagerById(id);
            ManagerPo managerPo= (ManagerPo) newsResult.getData();
            model.addAttribute("managerPo",managerPo);
        }

        return "admin-edit";
    }

    @RequestMapping(value = "admin-add",method = RequestMethod.GET)
    @SystemControllerLog(description = "添加管理员页面")
    public String updateAdmin(Model model){

        List<Role> roles= (List<Role>) roleService.RoleList().getData();
        List<DepartmentInfo> departmentInfos= (List<DepartmentInfo>) departmentService.departmentList().getData();
        model.addAttribute("roles",roles);
        model.addAttribute("departmentInfos",departmentInfos);

        return "admin-add";
    }


    @RequestMapping(value = "change-password",method = RequestMethod.GET)
    @SystemControllerLog(description = "修改个人密码")
    public String editPasswd(Model model){

        return "change-password";
    }

    @RequestMapping(value=" manager/checkpasswd",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String check_passwd( Integer id,String passwd){
        ManagerPo managerPo = (ManagerPo) managerService.findManagerById(id).getData();
        String md5Pass = Encrypt.md5(passwd, managerPo.getManager().getManagerNumber());
        if (!managerPo.getManager().getManagerPasswd().equals(md5Pass)){
            return "false";
        }
        return "true";
    }

    @RequestMapping(value="manager/editpasswd",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String edit_passwd( String newpassword){
        Subject subject=SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getPrincipal();
        manager.setManagerPasswd(newpassword);
        NewsResult newsResult = managerService.updateManagerPasswd(manager);
        if (newsResult.getStatus()==200){
            //销毁session重新登录
            return "true";
        }
        return "503";
    }

    @RequestMapping(value="manager/update",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String manager_update( Manager manager){
        Subject subject=SecurityUtils.getSubject();
        Manager m = (Manager) subject.getPrincipal();
        manager.setManagerId(m.getManagerId());
        NewsResult newsResult = managerService.updateManager(manager);
        if (newsResult.getStatus()==200){
            m.setManagerName(manager.getManagerName());
            return "true";
        }
        return "false";
    }

    @RequestMapping(value="manager/add",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String manager_add( Manager manager,String roleIds){
        String[] split = roleIds.split(",");
        List<Integer> roles=new ArrayList<Integer>();
        for (String s:split) {
            roles.add(Integer.parseInt(s));
        }
        NewsResult newsResult = managerService.insertManager(manager,roles);
        if (newsResult.getStatus()==200){
            return "true";
        }
        return "503";
    }

    @RequestMapping(value="manager/chechnum",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String check_managerNumber(String managerNumber){
        NewsResult newsResult = managerService.findManagerByNumber(managerNumber);
        if (newsResult.getStatus()==200){
            return "true";
        }
        return "false";
    }






}
