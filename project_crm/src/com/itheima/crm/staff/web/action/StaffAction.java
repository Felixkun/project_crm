package com.itheima.crm.staff.web.action;

import java.util.List;

import com.itheima.crm.base.BaseAction;
import com.itheima.crm.department.daomain.CrmDepartment;
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
	
	
	
	public String findAll(){
		List<CrmStaff> allStaff = this.getStaffService().findAllStaff();
		
		put("allStaff" , allStaff);
		return "findAll";
	}
	
	
	
	public String editUI(){
		//1ͨ��id��ѯԱ��
		CrmStaff findStaff = this.getStaffService().findById(getModel().getStaffId());
		push(findStaff);
		
		//2��ѯ���в���
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		
		set("allDepartment" ,allDepartment );
		
		return "editUI";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
