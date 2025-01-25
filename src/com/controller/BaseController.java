package com.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Controller 基类 其他Controller继承此类的同时也继承了此类里面的各个方法 省掉了重新定义 实例化的麻烦 作者 QQ :
 * 709664889
 */
@Controller
public class BaseController {

	/* 日志 */
	protected final Log log = LogFactory.getLog(getClass());

	/* 获取基本环境 */
	public Map<String, String[]> getParameters() {// 封装为Map的requestParameters
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attrs.getRequest().getParameterMap();
	}

	public HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attrs.getRequest();
	}

	public HttpSession getSession() {
		HttpSession session = null;
		try {
			session = this.getRequest().getSession();
		} catch (Exception e) {
		}
		return session;
	}

}

// 本类作者QQ : 709664889 提供程序有偿修改服务 本类制作日期 ：2021-01-14
// 代做毕业设计程序 JSP || Servlet || Struts2 || SSH || SSM || SpringBoot || ThinkPHP ||
// ASP.NET(三层架构)
// 数据库 MySQL || MSSQL || Oracle
// 程序开发 数据库建设 环境调试
// 单对单 单对多 另有海量成品 欢迎惠顾
