package com.itheima.crm.staff.web.action;

import com.itheima.crm.base.BaseAction;
import com.itheima.crm.staff.daomain.CrmStaff;
import com.opensymphony.xwork2.ActionContext;

public class StaffAction extends BaseAction<CrmStaff> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	//Ա����¼
	public String login(){
		CrmStaff findStaff = getStaffService().login(getModel());
		if(findStaff != null){
			ActionContext.getContext().getSession().put("loginStaff", findStaff);
			return "success";
		}
		
		this.addFieldError("", "�û��������벻ƥ��");
		return "login";
	}

	
	//��ʾ��ҳ
	public String home(){
		return "home";
	}
	

}
