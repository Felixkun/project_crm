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
	 * ����id����
	 * @param id
	 * @return
	 */
	public T findById(Serializable id);
	
	/**
	 * ��������
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * ������ѯ
	 * @param condition
	 * @param params
	 * @return
	 */
	public List<T> findAll(String condition , Object[] params);
	
	/**
	 * ���� ��ѯ������
	 * @param condition
	 * @param params
	 * @return
	 */
	public int getTotalRecord(String condition , Object[] params);
	
	/**
	 * ��ҳ������ѯ
	 * @param condition
	 * @param params
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<T> findAll(String condition , Object[] params , int startIndex , int pageSize);
	
	/**
	 * ���߲�ѯ��ʹ��QBC
	 * @param criteria
	 * @return
	 */
	public List<T> findAll(DetachedCriteria criteria);
	
	
	/**
	 * ���߷�ҳ��ѯ
	 * @param criteria
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public List<T> findAll(DetachedCriteria criteria , int startIndex , int endIndex);
	
}
