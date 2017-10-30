package com.itheima.crm.staff.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.itheima.crm.staff.dao.StaffDao;
import com.itheima.crm.staff.daomain.CrmStaff;

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

	@Override
	public CrmStaff find(String loginName, String loginPwd) {
		// TODO Auto-generated method stub
		List<CrmStaff> list = this.getHibernateTemplate().find("from CrmStaff where loginName =? and loginPwd = ?", loginName,loginPwd);
		if(list.size() == 1){
			return list.get(0);
		}
		return null;
	}

}
