package com.news.shiro;

import java.util.ArrayList;
import java.util.List;
import com.news.pojo.Manager;
import com.news.pojo.Module;
import com.news.po.NewsResult;
import com.news.pojo.Role;
import com.news.service.ManagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.news.utils.SysConstant;
import com.news.service.RoleResService;

public class AuthRealm extends AuthorizingRealm{

	@Autowired
	private ManagerService managerService;

	@Autowired
	private RoleResService roleResService;
	
	
	public RoleResService getRoleResService() {
		return roleResService;
	}

	public void setRoleResService(RoleResService roleResService) {
		this.roleResService = roleResService;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	//授权   当页面出现Shiro标签时，就会执行授权方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		System.out.println("授权");
		Manager user = (Manager) pc.fromRealm(this.getName()).iterator().next();//根据realm的名字去找对应的realm
		
		List<String> permissions = new ArrayList<String>();
		
		//得到该用户所有资源权限
		NewsResult result=roleResService.getResByManagerId(user.getManagerId());

		if(result.getStatus()==200) {
			List<Module> modules =(List<Module>) result.getData();
			for(Module module :modules){
				
				permissions.add(module.getModuleName());
			}
		}
		System.out.println(permissions);
//		permissions.add("功能菜单");
//		permissions.add("基础档案");
//		permissions.add("商业公司档案");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(permissions);//添加用户的模块（权限）
		return info;
	}

	@Override
	//认证   token 代表用户在界面输入的用户名和密码
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("认证");
		
		//1.向下转型
		UsernamePasswordToken upToken  = (UsernamePasswordToken) token;
		
		//2.调用业务方法，实现根据工号查询
		//
		NewsResult result=managerService.findManagerByNumber(upToken.getUsername());

		//如果查询成功
		if(result.getStatus()==200) {
			List<Manager> list =(List<Manager>) result.getData();

			if(list.size()==0) {
				throw new UnknownAccountException(); //用户名错误
			}
			Manager user = list.get(0);
			
			if(user==null){
				throw new UnknownAccountException(); //如果用户名错误
			}
			
			AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getManagerPasswd(),this.getName());
			
			//去除密码,将user对象序列化
			user.setManagerPasswd(null);
			NewsResult resultRoles=roleResService.getRoleByManagerId(user.getManagerId());
			List<Role> roles=null;
			if (resultRoles.getStatus()==200){
				roles= (List<Role>) resultRoles.getData();
				String name=roles.get(0).getRoleName();
				roles.get(0).setRoleName(name.substring(5,name.length()));
			}
			
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute(SysConstant.CURRENT_MANAGER_INFO, user);
			session.setAttribute(SysConstant.CURRENT_MANAGER_ROLE,roles.get(0));
			return info;   //此处如果返回，就会立即进入到密码比较器
		}
		return null;//就会出现异常
	}

}
