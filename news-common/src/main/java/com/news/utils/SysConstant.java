package com.news.utils;

import org.apache.log4j.Logger;

/**
 * @Description:

 * @Author:		chenjie
 * @Company:	
 * @CreateDate:	
 */
/*
 * 系统全局常量配置类
 */
public class SysConstant {
	private static Logger log = Logger.getLogger(SysConstant.class);

	public static String CURRENT_USER_INFO = "_CURRENT_USER";	//当前用户session name
	public static String CURRENT_MANAGER_INFO = "_CURRENT_MANAGER";	//当前用户session name
	public static String USE_DATABASE = "MySql";				//使用的数据库 Oracle/SQLServer
	public static String USE_DATABASE_VER = "5.0";				//使用的数据库版本 10g/2000

	public static String DEFAULT_PASS = "123456";				//默认密码
	public static int PAGE_SIZE = 10;							//分页时一页显示多少条记录

	public static String CURRENT_MANAGER_ROLE="_CURRENT_ROLE";

	public static int SUPER_DEPARMENT_ID=1;//总部id
}
