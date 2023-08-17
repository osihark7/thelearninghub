package com.dreamsathis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String productName;
	
	private String description;
	
	private Long categoryId;
	
	
	private Long wegiht;
	
	private String amount;
	
	private String mrp;
	
	private String discount;   // %
	
	private String image1;
	private String image2;
	private String image3;
	
	private String imgUrl;
	
	private boolean status;
	private String createdAt;
	private String updatedAt;
	public Long getId() {
		return id;
	}
	public String getProductName() {
		return productName;
	}
	public String getDescription() {
		return description;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public Long getWegiht() {
		return wegiht;
	}
	
	public String getImage1() {
		return image1;
	}
	public String getImage2() {
		return image2;
	}
	public String getImage3() {
		return image3;
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
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public void setWegiht(Long wegiht) {
		this.wegiht = wegiht;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public void setImage3(String image3) {
		this.image3 = image3;
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
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getAmount() {
		return amount;
	}
	public String getMrp() {
		return mrp;
	}
	public String getDiscount() {
		return discount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setMrp(String mrp) {
		this.mrp = mrp;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	

}
