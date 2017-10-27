package com.itheima.crm.courseType.daomain;

import java.util.HashSet;
import java.util.Set;

import com.itheima.crm.classes.daomain.CrmClasses;

/**
 * 课程类别
 * @author felix
 *
 */
public class CrmCourseType {
	
	private String courseTypeId;
	private String courseCost;
	private Integer total;
	private String courseName;
	private String remark;
	
	//一个课程类别对应多个班级
	private Set<CrmClasses> classes = new HashSet<CrmClasses>();

	public String getCourseTypeId() {
		return courseTypeId;
	}

	public void setCourseTypeId(String courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	public String getCourseCost() {
		return courseCost;
	}

	public void setCourseCost(String courseCost) {
		this.courseCost = courseCost;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<CrmClasses> getClasses() {
		return classes;
	}

	public void setClasses(Set<CrmClasses> classes) {
		this.classes = classes;
	}
	
	
}
