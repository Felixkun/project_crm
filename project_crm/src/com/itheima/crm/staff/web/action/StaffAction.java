package com.itheima.crm.staff.web.action;

import java.util.List;

import com.itheima.crm.base.BaseAction;
import com.itheima.crm.department.daomain.CrmDepartment;
import com.itheima.crm.page.PageBean;
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
	
	
	//查询所有员工
	public String findAll(){
		
		//1查询所有部门
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
				
		put("allDepartment" ,allDepartment );
//		
//		
//		//2.查询所有员工
//		List<CrmStaff> allStaff = this.getStaffService().findAllStaff();
//		
//		put("allStaff" , allStaff);
//		return "findAll";
		
		
		//2.分页+条件查询所有员工
		PageBean<CrmStaff> pageBean = this.getStaffService().findAll(this.getModel() , getPageNum() , getPageSize());
		put("pageBean" , pageBean);
		return "findAll";
	}
	
	
	
	public String editUI(){
		//1通过id查询员工
		CrmStaff findStaff = this.getStaffService().findById(this.getModel().getStaffId());
		push(findStaff);
		
		//2查询所有部门
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		
		set("allDepartment" ,allDepartment );
		
		return "editUI";
	}
	
	
	
	public String edit(){
		this.getStaffService().updateStaff(this.getModel());
		return "edit";
	}
	
	
	public String add(){
		
		//2查询所有部门
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
				
		set("allDepartment" ,allDepartment );
		
		return "add";
		
	}
	
	public String addStaff(){
		
		this.getStaffService().saveStaff(this.getModel());
		
		return "edit";
	}
	
	

	
	public String findAllDepartment(){
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		set("allDepartment" ,allDepartment );
		return "none";
	}
	
	

	
	
	
	

}
