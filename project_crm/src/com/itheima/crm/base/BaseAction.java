package com.itheima.crm.base;

import java.lang.reflect.ParameterizedType;

import com.itheima.crm.staff.service.StaffService;
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
	private StaffService staffService;

	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	
	
	
}
