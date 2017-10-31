package com.itheima.crm.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {

	public void save(T t);
	public void update(T t);
	public void delete(T t);
	public void saveOrUpdate(T t);
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public T findById(Serializable id);
	
	/**
	 * 查找所有
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 条件查询
	 * @param condition
	 * @param params
	 * @return
	 */
	public List<T> findAll(String condition , Object[] params);
	
	/**
	 * 条件 查询总条数
	 * @param condition
	 * @param params
	 * @return
	 */
	public int getTotalRecord(String condition , Object[] params);
	
	/**
	 * 分页条件查询
	 * @param condition
	 * @param params
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<T> findAll(String condition , Object[] params , int startIndex , int pageSize);
	
	/**
	 * 离线查询，使用QBC
	 * @param criteria
	 * @return
	 */
	public List<T> findAll(DetachedCriteria criteria);
	
	
	/**
	 * 离线分页查询
	 * @param criteria
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public List<T> findAll(DetachedCriteria criteria , int startIndex , int endIndex);
	
}
