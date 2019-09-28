package com.capgemini.banking.dao;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.banking.bean.Account;
import com.capgemini.banking.bean.Transaction;

public interface BankingDao {
	void createAccount(Account account) throws SQLException;
	
	void updateBalance(Integer accountNo, double balance) throws SQLException;

	void addTransaction(Transaction transaction, Account account) throws SQLException;

	List<Transaction> getTransactions(Integer accountNo) throws SQLException;

	Account getAccount(Integer accountNo) throws SQLException;
	
}
