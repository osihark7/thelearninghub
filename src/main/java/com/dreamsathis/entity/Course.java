package com.dreamsathis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	
	private Long id;
	private String courseName;
	private String courseDescription;
	private String logo;
	private String imgUrl;
	private String courseAmount;
	private String teacher;
	private String rating;
	private String courseType;
	private String teacherimage;
	private boolean status;
	private String createdAt;
	private String updatedAt;
	public Long getId() {
		return id;
	}
	public String getCourseName() {
		return courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public boolean isStatus() {
		return status;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getLogo() {
		return logo;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getCourseAmount() {
		return courseAmount;
	}
	public String getTeacher() {
		return teacher;
	}
	public String getRating() {
		return rating;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseAmount(String courseAmount) {
		this.courseAmount = courseAmount;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public String getTeacherimage() {
		return teacherimage;
	}
	public void setTeacherimage(String teacherimage) {
		this.teacherimage = teacherimage;
	}

}
