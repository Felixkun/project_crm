package com.itheima.crm.page;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

public class PageHibernateCallBack<T> implements HibernateCallback <List<T>> {

	private String hql;
	private Object[] params;
	private int startIndex;
	private int pageSize;
	
	



	@Override
	public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
		
		//1.通过hql语句，获得Query对象
		Query queryObject = session.createQuery(hql);
		//2. 条件设置
		for( int i =0 ; i < params.length ; i++){
			queryObject.setParameter(i, params[i]);
		}
		
		//3.分页
		queryObject.setFirstResult(startIndex);
		queryObject.setMaxResults(pageSize);
		
		return queryObject.list();
	}


	public PageHibernateCallBack<T> setHql(String hql) {
		this.hql = hql;
		return this;
	}


	public PageHibernateCallBack<T> setParams(Object[] params) {
		this.params = params;
		return this;
	}


	public PageHibernateCallBack<T> setStartIndex(int startIndex) {
		this.startIndex = startIndex;
		return this;
	}


	public PageHibernateCallBack<T> setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

}
