package com.dreamsathis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	private Double amount;
	private boolean status;
	private String createdAt;
	private String updatedAt;
	public Long getPaymentId() {
		return paymentId;
	}
	public Double getAmount() {
		return amount;
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
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
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
	
	
}
