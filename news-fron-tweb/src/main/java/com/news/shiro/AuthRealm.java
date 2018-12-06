package com.news.shiro;

import java.util.ArrayList;
import java.util.List;
import com.news.pojo.Manager;
import com.news.pojo.Module;
import com.news.po.NewsResult;
import com.news.pojo.Role;
import com.news.pojo.UserInfo;
import com.news.service.ManagerService;
import com.news.service.UserService;
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
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//授权   当页面出现Shiro标签时，就会执行授权方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		System.out.println("授权");

		return null;
	}

	@Override
	//认证   token 代表用户在界面输入的用户名和密码
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("认证");
		
		//1.向下转型
		UsernamePasswordToken upToken  = (UsernamePasswordToken) token;
		
		//2.调用业务方法，实现根据工号查询
		//
		NewsResult result=userService.findUserByEmail(upToken.getUsername());

		//如果查询成功
		if(result.getStatus()==200) {
			List<UserInfo> list =(List<UserInfo>) result.getData();

			if(list.size()==0) {
				throw new UnknownAccountException(); //用户名错误
			}
			UserInfo user = list.get(0);
			
			if(user==null){
				throw new UnknownAccountException(); //如果用户名错误
			}
			
			AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getUserPasswd(),this.getName());
			
			//去除密码,将user对象序列化
			user.setUserPasswd(null);

			List<Role> roles=null;

			
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute(SysConstant.CURRENT_USER_INFO, user);
			return info;   //此处如果返回，就会立即进入到密码比较器
		}
		return null;//就会出现异常
	}

}
