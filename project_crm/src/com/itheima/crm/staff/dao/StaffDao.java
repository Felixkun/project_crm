package com.itheima.crm.staff.dao;

import com.itheima.crm.base.BaseDao;
import com.itheima.crm.staff.daomain.CrmStaff;

public interface StaffDao extends BaseDao<CrmStaff>{

	/**
	 * �����û������û���������û�
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public CrmStaff find(String loginName , String loginPwd);
	
}
