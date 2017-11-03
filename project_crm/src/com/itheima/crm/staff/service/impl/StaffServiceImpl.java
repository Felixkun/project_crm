package com.itheima.crm.staff.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.itheima.crm.department.daomain.CrmDepartment;
import com.itheima.crm.page.PageBean;
import com.itheima.crm.staff.dao.StaffDao;
import com.itheima.crm.staff.daomain.CrmStaff;
import com.itheima.crm.staff.service.StaffService;
import com.itheima.crm.utils.MyStringUtils;

public class StaffServiceImpl implements StaffService {

	private StaffDao staffDao;
	
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	@Override
	public CrmStaff login(CrmStaff staff) {
		String loginPwd = MyStringUtils.getMD5Value(staff.getLoginPwd());
		return staffDao.find(staff.getLoginName(), loginPwd);
	}

	@Override
	public List<CrmStaff> findAllStaff() {
		// TODO Auto-generated method stub
		return this.staffDao.findAll();
	}

	@Override
	public CrmStaff findById(String staffId) {
		// TODO Auto-generated method stub
		return this.staffDao.findById(staffId);
	}

	@Override
	public void updateStaff(CrmStaff staff) {
		
		
		CrmStaff findStaff = this.staffDao.findById(staff.getStaffId());
		
		if ( !findStaff.getLoginPwd().equals(staff.getLoginPwd())){
			findStaff.setLoginPwd(MyStringUtils.getMD5Value(staff.getLoginPwd()));
		}
		findStaff.setGender(staff.getGender());
		findStaff.setLoginName(staff.getLoginName());
		findStaff.setOnDutyDate(staff.getOnDutyDate());
		findStaff.setPost(staff.getPost());
		findStaff.setStaffName(staff.getStaffName());
		
		
	}

	@Override
	public void saveStaff(CrmStaff staff) {
		staff.setLoginPwd(MyStringUtils.getMD5Value(staff.getLoginPwd()));
		this.staffDao.save(staff);
		
	}

	@Override
	public PageBean<CrmStaff> findAll(CrmStaff model, int pageNum, int pageSize) {
		//1条件查询
		//1.1拼装查询条件
		StringBuilder builder = new StringBuilder();
		
		
		//1.2 拼凑实际参数 ，可以重复
		List<Object> paramsList = new ArrayList<Object>();
		
		
		
		
		//2过滤条件
		//2.1 职务id不为空
		if(model.getPost() != null && StringUtils.isNotBlank(model.getPost().getPostId()) ){
			
			if(StringUtils.isNotBlank(model.getPost().getDepartment().getDepId()));
			
			
			System.out.println(model.getPost().getDepartment().getDepId());
			
			if(model.getPost().getPostId().equals(",")){
			}else if (model.getPost().getPostId().indexOf(",") != -1){
				builder.append(" and postId like ? ");
				paramsList.add("%" + model.getPost().getPostId().replace(", ", "") + "%");
			}
			
		}
		
		
		
		
		//2.2 名字包含
		if(StringUtils.isNotBlank(model.getStaffName())){
			
			builder.append(" and staffName like ? ");
			paramsList.add("%" + model.getStaffName() + "%");
		}
		
		
		//3.使用条件
		String condition = builder.toString();
		Object[] params = paramsList.toArray();
		
		
		//4.分页
		int totalRecord = this.staffDao.getTotalRecord(condition, params);
		
		PageBean<CrmStaff> pageBean = new PageBean<>(pageNum, pageSize, totalRecord);
		List<CrmStaff> data = this.staffDao.findAll(condition, params, pageBean.getPageNum(), pageBean.getPageSize());
		pageBean.setData(data);
		return pageBean;
	}

}
