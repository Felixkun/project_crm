package com.itheima.crm.staff.service.impl;

import java.util.List;

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

}
