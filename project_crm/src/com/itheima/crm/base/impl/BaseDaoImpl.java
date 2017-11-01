package com.itheima.crm.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.itheima.crm.base.BaseDao;
import com.itheima.crm.page.PageHibernateCallBack;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	
	//T 编译是，注释变量 运行时才可以获得具体类型
	private Class<?>  beanClass;
	
	public BaseDaoImpl(){
		ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
		beanClass = (Class<?>)paramType.getActualTypeArguments()[0];
	}
	
	
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
		
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
		
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
		
	}

	@Override
	public void saveOrUpdate(T t) {
		this.getHibernateTemplate().saveOrUpdate(t);
		
	}

	@Override
	public T findById(Serializable id) {
		return (T) this.getHibernateTemplate().get(beanClass, id);
	}

	@Override
	public List<T> findAll() {
		return this.getHibernateTemplate().find("from " + beanClass.getName());
	}

	@Override
	public List<T> findAll(String condition, Object[] params) {
		String hql = "from " + beanClass.getName() + " where 1=1 " + condition;
		return this.getHibernateTemplate().find(hql, params);
	}

	@Override
	public int getTotalRecord(String condition, Object[] params) {
		String hql = "select count(c) from " + beanClass.getName() + " where 1=1 " + condition;
		List<Long> list = this.getHibernateTemplate().find(hql, params);
		return list.get(0).intValue();
	}

	@Override
	public List<T> findAll(String condition, Object[] params, int startIndex, int pageSize) {
		String hql = "from " + beanClass.getName() + " where 1=1 "+ condition;
		return this.getHibernateTemplate().executeFind(new PageHibernateCallBack<T>().setPageSize(pageSize).setStartIndex(startIndex).setHql(hql).setParams(params));
	}

	@Override
	public List<T> findAll(DetachedCriteria criteria) {
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<T> findAll(DetachedCriteria criteria, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().findByCriteria(criteria, startIndex, pageSize);
	}



}
