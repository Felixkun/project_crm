package com.itheima.crm.base;

import java.lang.reflect.ParameterizedType;


import com.itheima.crm.department.service.DepartmentService;
import com.itheima.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	//1.��װ����
	private T t;
	
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return t;
	}

	//1.1ʵ����t
	public BaseAction(){
		try{
			//�������ʱclass
			ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) paramType.getActualTypeArguments()[0];
			t = clazz.newInstance();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	
	
	//2.springע��service�����
	
	//2.1 Ա��
	private StaffService staffService;

	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	
	//2.2����
	private DepartmentService departmentService;
	
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	
	
	
	
	
	
	//3.��ֵջ����
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
