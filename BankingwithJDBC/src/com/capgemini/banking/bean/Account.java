package com.capgemini.banking.bean;

import java.util.ArrayList;

public class Account {
	static Integer accountNo = 501235897;
	private String accountType;
	private double balance;
	private Customer customer;

	private ArrayList<Transaction> transaction;

	public void addTransaction(Transaction transaction) {
		this.transaction.add(transaction);
	}
	public Account() {
		super();
		this.transaction = new ArrayList<Transaction>();
	}

	public Account(String accountType, double balance, Customer customer, ArrayList<Transaction> transaction) {
		super();
		this.accountType = accountType;
		this.balance = balance;
		this.customer = customer;
		this.transaction = transaction;
	}

	public ArrayList<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(ArrayList<Transaction> transaction) {
		this.transaction = transaction;
	}

	

	public Integer getAccountNo() {
		return accountNo++;
	}
	public Customer getCustomer() {
		return customer;
	}

	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double currentBalance) {
		this.balance = currentBalance;
	}

	@Override
	public String toString() {
		return "Account [accountType=" + accountType + ", balance=" + balance + ", customer=" + customer + "]";
	}
	

}
