package com.itheima.crm.staff.daomain;

import java.util.Date;

import com.itheima.crm.post.daomain.CrmPost;

/**
 * 员工信息表
 * @author felix
 *
 */
public class CrmStaff {
/*
	`staffId` varchar(255) NOT NULL PRIMARY KEY,
	  `loginName` varchar(100) DEFAULT NULL,
	  `loginPwd` varchar(100) DEFAULT NULL,
	  `staffName` varchar(100) DEFAULT NULL,
	  `gender` varchar(20) DEFAULT NULL,
	  `onDutyDate` datetime DEFAULT NULL,
	  `postId` varchar(255) DEFAULT NULL,
	*/
	
	private String staffId;
	private String loginName;
	private String staffName;
	private String loginPwd;
	private String gender;
	private Date onDutyDate;
	
	  
	//多个员工对应一个职位
	private CrmPost post;


	public String getStaffId() {
		return staffId;
	}


	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public String getStaffName() {
		return staffName;
	}


	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}


	public String getLoginPwd() {
		return loginPwd;
	}


	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getOnDutyDate() {
		return onDutyDate;
	}


	public void setOnDutyDate(Date onDutyDate) {
		this.onDutyDate = onDutyDate;
	}


	public CrmPost getPost() {
		return post;
	}


	public void setPost(CrmPost post) {
		this.post = post;
	}
	
	
}
