package com.itheima.crm.staff.web.action;

import com.itheima.crm.staff.daomain.CrmStaff;
import com.itheima.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff> {

	private CrmStaff staff = new CrmStaff();
	
	@Override
	public CrmStaff getModel() {
		// TODO Auto-generated method stub
		return staff;
	}
	
	//默认按照名称注入
	private  StaffService  staffService;
	public void staffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	
	
	//员工登录
	public String login(){
		CrmStaff findStaff = staffService.login(staff);
		
		if(findStaff != null){
			ActionContext.getContext().getSession().put("loginStaff", findStaff);
			return "success";
		}
		
		this.addFieldError("", "用户名与密码不匹配");
		return "ligin";
	}

	
	//显示首页
	public String home(){
		return "home";
	}
	

}
