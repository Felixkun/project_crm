package com.itheima.crm.post.daomain;

import java.util.HashSet;
import java.util.Set;

import com.itheima.crm.department.daomain.CrmDepartment;
import com.itheima.crm.staff.daomain.CrmStaff;

/**
 * 职务表
 * @author felix
 *
 */
public class CrmPost {

	private String postId;//职务编号
	private String postName;//职务名称

	
	//多对一 多个职务对应一个部门
	private CrmDepartment department;

	
	private Set<CrmStaff> staffSet = new HashSet<CrmStaff>();
	

	public String getPostId() {
		return postId;
	}


	public void setPostId(String postId) {
		this.postId = postId;
	}





	public Set<CrmStaff> getStaffSet() {
		return staffSet;
	}


	public void setStaffSet(Set<CrmStaff> staffSet) {
		this.staffSet = staffSet;
	}


	public String getPostName() {
		return postName;
	}


	public void setPostName(String postName) {
		this.postName = postName;
	}


	public CrmDepartment getDepartment() {
		return department;
	}


	public void setDepartment(CrmDepartment department) {
		this.department = department;
	}
	
	
}
