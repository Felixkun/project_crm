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
	
	//Ĭ�ϰ�������ע��
	private  StaffService  staffService;
	public void staffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	
	
	//Ա����¼
	public String login(){
		CrmStaff findStaff = staffService.login(staff);
		
		if(findStaff != null){
			ActionContext.getContext().getSession().put("loginStaff", findStaff);
			return "success";
		}
		
		this.addFieldError("", "�û��������벻ƥ��");
		return "ligin";
	}

	
	//��ʾ��ҳ
	public String home(){
		return "home";
	}
	

}
