package com.itheima.crm.department.service.impl;

import java.util.List;

import com.itheima.crm.department.dao.DepartmentDao;
import com.itheima.crm.department.daomain.CrmDepartment;
import com.itheima.crm.department.service.DepartmentService;

public class DepartServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public List<CrmDepartment> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}

}
