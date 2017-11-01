package com.itheima.crm.staff.dao.impl;

import java.util.List;


import com.itheima.crm.base.impl.BaseDaoImpl;
import com.itheima.crm.staff.dao.StaffDao;
import com.itheima.crm.staff.daomain.CrmStaff;

public class StaffDaoImpl<T> extends BaseDaoImpl<CrmStaff> implements StaffDao {

	@Override
	public CrmStaff find(String loginName, String loginPwd) {
		System.out.println("StaffDaoImpl++++++++++++++++++++=");
		List<CrmStaff> list = this.getHibernateTemplate().find("from CrmStaff where loginName =? and loginPwd = ?", loginName,loginPwd);
		if(list.size() == 1){
			return list.get(0);
		}
		return null;
	}

}
