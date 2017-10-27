package com.itheima.crm.department.daomain;

import java.util.HashSet;
import java.util.Set;

import com.itheima.crm.post.daomain.CrmPost;

/**
 * 部门bean
 * @author felix
 *
 */
public class CrmDepartment {

	private String depId;//部门id
	
	private String depName;//部门名称
	
	//一对多、一个部门队友多个职务
	private Set<CrmPost> postSet = new HashSet<CrmPost>();

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Set<CrmPost> getPostSet() {
		return postSet;
	}

	public void setPostSet(Set<CrmPost> postSet) {
		this.postSet = postSet;
	}
	
	
}
