package com.itheima.crm.base;

import java.lang.reflect.ParameterizedType;


import com.itheima.crm.department.service.DepartmentService;
import com.itheima.crm.post.service.PostService;
import com.itheima.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	//1.封装数据
	private T t;
	
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return t;
	}

	//1.1实例化t
	public BaseAction(){
		try{
			//获得运行时class
			ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) paramType.getActualTypeArguments()[0];
			t = clazz.newInstance();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	
	
	//2.spring注入service，多个
	
	//2.1 员工
	private StaffService staffService;

	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	
	
	
	
	//2.2部门
	private DepartmentService departmentService;
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
	
	
	
	
	//2.3职务
	private PostService postService;

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	
	
	
	
	//3.简化值栈操作
	public void push(Object o){
		ActionContext.getContext().getValueStack().push(o);
	}
	
	public void set(String key , Object o){
		ActionContext.getContext().getValueStack().set(key, o);
	}
	
	public void put(String key , Object o){
		ActionContext.getContext().put(key, o);
	}
	
	public void putSession(String key , Object o){
		ActionContext.getContext().getSession().put(key, o);
	}
	
	
	public void putApplication(String key , Object o){
		ActionContext.getContext().getApplication().put(key, o);
	}
	
	
	
	
	
	
	
	
	
	
	
}
