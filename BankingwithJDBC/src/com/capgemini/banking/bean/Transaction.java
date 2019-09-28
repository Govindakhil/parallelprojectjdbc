package com.capgemini.banking.bean;

public class Transaction {
	static Integer initialTransactionId=1000233;
	private Integer transactionId;
	private String transactionType;
	private double transactionAmount;
	
	public Transaction(String transactionType, double transactionAmount) {
		super();
		this.setTransactionId();
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
	}
	public Transaction() {
		super();
		this.setTransactionId();
	}
	public void setTransactionId() {
		this.transactionId = initialTransactionId++;
	}

	public Integer getTransactionId() {
		return transactionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", transactionAmount=" + transactionAmount + "]";
	}
	
	
}
