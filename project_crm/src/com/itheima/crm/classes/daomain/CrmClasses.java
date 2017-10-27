package com.itheima.crm.classes.daomain;

import java.util.Date;

import com.itheima.crm.courseType.daomain.CrmCourseType;

public class CrmClasses {
	private String classId;
	
	private String name;
	private Date beginTime;
	private Date endTime;
	
	private String stauts;
	private Integer totalCount;
	private Integer upgradeCount;
	
	private Integer changeCount;
	private Integer runoffCount;
	private String remark;
	
	private Date uploadTime;
	private String uploadPath;
	private String uploadFilename;
	
	//一个班级对应一个课程
	private CrmCourseType courseType;
	
	
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getStauts() {
		return stauts;
	}

	public void setStauts(String stauts) {
		this.stauts = stauts;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getUpgradeCount() {
		return upgradeCount;
	}

	public void setUpgradeCount(Integer upgradeCount) {
		this.upgradeCount = upgradeCount;
	}

	public Integer getChangeCount() {
		return changeCount;
	}

	public void setChangeCount(Integer changeCount) {
		this.changeCount = changeCount;
	}

	public Integer getRunoffCount() {
		return runoffCount;
	}

	public void setRunoffCount(Integer runoffCount) {
		this.runoffCount = runoffCount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getUploadFilename() {
		return uploadFilename;
	}

	public void setUploadFilename(String uploadFilename) {
		this.uploadFilename = uploadFilename;
	}

	public CrmCourseType getCourseType() {
		return courseType;
	}

	public void setCourseType(CrmCourseType courseType) {
		this.courseType = courseType;
	}

	
	
	
}
