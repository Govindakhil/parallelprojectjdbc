package com.capgemini.banking.service;

import java.sql.SQLException;

import com.capgemini.banking.bean.Account;
import com.capgemini.banking.bean.Transaction;
import com.capgemini.banking.dao.BankingDaoImpl;
import com.capgemini.banking.exception.AccountNotFoundException;
import com.capgemini.banking.exception.InsufficientBalanceException;

public class BankingServiceImpl implements Bankingservice {

	BankingDaoImpl dao=new BankingDaoImpl();
	@Override
	public void createAccount(Account account) {

		dao.createAccount(account);
	}

	@Override
	public void deposit(Integer amount, Integer accountNo) throws SQLException, AccountNotFoundException {
		Account account = dao.getAccount(accountNo);
		if (account == null)
			throw new AccountNotFoundException("Account not found............");
		else {
			dao.updateBalance(accountNo, account.getBalance() + amount);
			
			dao.addTransaction( new Transaction("Credit", amount), account);
		}
		
	}

	@Override
	public void withdraw(Integer amount, Integer accountNo) throws SQLException, InsufficientBalanceException {
		Account account = dao.getAccount(accountNo);
		if (account == null)
			System.out.println("No accounts found................");
		else {
			if (account.getBalance() > amount) {
				dao.updateBalance(accountNo, account.getBalance() - amount);
				dao.addTransaction( new Transaction("Debit", amount), account);
			} else {
				throw new InsufficientBalanceException("Insufficient Balance..........");
			}
		}

	}

	@Override
	public void checkBalance(Integer accountNo) throws AccountNotFoundException {
		Account account;
		try {
			account = dao.getAccount(accountNo);
			if (account == null)
				throw new AccountNotFoundException("NO Accounts Found...");
			else {
				System.out.println(account.getBalance());
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}

	}

	@Override
	public void fundtransfer(Integer accountNo1, Integer accountNo2,Float amount) throws SQLException
	{
		if (accountNo1 != accountNo2)
		{
			double sent, recieved;
			sent = dao.getAccount(accountNo1).getBalance();
			recieved = dao.getAccount(accountNo2).getBalance();
			System.out.println("Enter the amount to be transfered");
			if (sent < amount) 
			{
				System.out.println(" Enter the amount with in limit");
			} 
			else 
			{
				Account account1 = dao.getAccount(accountNo1);
				Account account2 = dao.getAccount(accountNo2);
			
				sent = dao.getAccount(accountNo1).getBalance() - amount;
				recieved = dao.getAccount(accountNo2).getBalance() + amount;
								
				dao.updateBalance(accountNo1, sent);
				dao.addTransaction(new Transaction("Debit", sent), account1);
				dao.updateBalance(accountNo1, recieved);
				dao.addTransaction(new Transaction("Credit", recieved), account2);
			}
		}
	}

	@Override
	public void transactionList(Integer accountNo) {
		Account account;
		try {
			account = dao.getAccount(accountNo);
			if (account == null)
				System.out.println("No accounts found...............");
			System.out.println(dao.getTransactions(accountNo));
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}
	
}
