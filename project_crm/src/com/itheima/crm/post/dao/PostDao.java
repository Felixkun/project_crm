package com.itheima.crm.post.dao;

import java.util.List;

import com.itheima.crm.base.BaseDao;
import com.itheima.crm.department.daomain.CrmDepartment;
import com.itheima.crm.post.daomain.CrmPost;

public interface PostDao extends BaseDao<CrmPost> {
	
	/**
	 * ��ѯָ�����ŵ�����ְ��
	 * @param department
	 * @return
	 */
	public List<CrmPost> findAll(CrmDepartment department);
}
