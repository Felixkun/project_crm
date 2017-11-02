package com.itheima.crm.post.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.crm.base.impl.BaseDaoImpl;
import com.itheima.crm.department.daomain.CrmDepartment;
import com.itheima.crm.post.dao.PostDao;
import com.itheima.crm.post.daomain.CrmPost;

public class PostDaoImpl extends BaseDaoImpl<CrmPost> implements PostDao {

	@Override
	public List<CrmPost> findAll(CrmDepartment department) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from CrmPost where department = ?", department);
	}

	
}
