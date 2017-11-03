package com.itheima.crm.staff.service;

import java.util.List;

import com.itheima.crm.page.PageBean;
import com.itheima.crm.staff.daomain.CrmStaff;

public interface StaffService {
	
	/**
	 * �û���¼
	 * @param staff
	 * @return
	 */
	public CrmStaff login(CrmStaff staff);

	CrmStaff findById(String staffId);

	List<CrmStaff> findAllStaff();

	public void updateStaff(CrmStaff model);

	public void saveStaff(CrmStaff staff);

	public PageBean<CrmStaff> findAll(CrmStaff model, int pageNum, int pageSize);
}
