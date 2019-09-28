package com.capgemini.banking.service;

import java.sql.SQLException;

import com.capgemini.banking.bean.Account;
import com.capgemini.banking.exception.AccountNotFoundException;
import com.capgemini.banking.exception.InsufficientBalanceException;

public interface Bankingservice {
	public void createAccount(Account account) throws SQLException;
	public void deposit(Integer amount,Integer accountNo) throws SQLException, AccountNotFoundException;
	public void withdraw(Integer amount,Integer accountNo) throws SQLException, InsufficientBalanceException;
	public void checkBalance(Integer accountNo) throws SQLException, AccountNotFoundException;
	public void fundtransfer(Integer accountNo1,Integer accountNo2,Float amount) throws SQLException;
	public void transactionList(Integer accountNo) throws SQLException;
	
}
