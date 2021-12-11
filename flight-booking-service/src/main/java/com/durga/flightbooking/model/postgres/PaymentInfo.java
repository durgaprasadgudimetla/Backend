package com.durga.flightbooking.model.postgres;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PAYMENT_INFO")
public class PaymentInfo {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2",strategy = "org.hibernate.id.UUIDGenerator")
	private String paymentId;
	private String accountNo;
	private Double amount;
	private String cardType;
	private Long passangerId;
	
	public PaymentInfo() {
		super();
	}
	
	public PaymentInfo(String paymentId, String accountNo, Double amount, String cardType, Long passangerId) {
		super();
		this.paymentId = paymentId;
		this.accountNo = accountNo;
		this.amount = amount;
		this.cardType = cardType;
		this.passangerId = passangerId;
	}
	@Override
	public String toString() {
		return "PaymentInfo [accountNo=" + accountNo + ", amount=" + amount + ", cardType=" + cardType
				+ ", passangerId=" + passangerId + ", paymentId=" + paymentId + "]";
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public Long getPassangerId() {
		return passangerId;
	}
	public void setPassangerId(Long passangerId) {
		this.passangerId = passangerId;
	}

}
