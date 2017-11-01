package com.itheima.crm.staff.web.action;

import com.itheima.crm.base.BaseAction;
import com.itheima.crm.staff.daomain.CrmStaff;
import com.opensymphony.xwork2.ActionContext;

public class StaffAction extends BaseAction<CrmStaff> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	//员工登录
	public String login(){
		CrmStaff findStaff = getStaffService().login(getModel());
		if(findStaff != null){
			ActionContext.getContext().getSession().put("loginStaff", findStaff);
			return "success";
		}
		
		this.addFieldError("", "用户名与密码不匹配");
		return "login";
	}

	
	//显示首页
	public String home(){
		return "home";
	}
	

}
