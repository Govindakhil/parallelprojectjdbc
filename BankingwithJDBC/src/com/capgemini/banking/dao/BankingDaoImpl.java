package com.capgemini.banking.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.banking.bean.Account;
import com.capgemini.banking.bean.Customer;
import com.capgemini.banking.bean.Transaction;


public class BankingDaoImpl implements BankingDao{

	@Override
	public void createAccount(Account account) {

		try  {
			Connection connection = BankingJDBCUtility.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO Account (accno,accType,Name,city,doorno,phoneno,pincode,initialbalance)  VALUES (ACCNO.nextval,?,?,?,?,?,?,?)",
					new String[] { "ACCNO" });
			statement.setString(1, account.getAccountType());
			statement.setString(2, account.getCustomer().getName());
			statement.setString(3, account.getCustomer().getCity());
			statement.setString(4, account.getCustomer().getDoorNo());
			statement.setString(5, account.getCustomer().getPhoneNo());
			statement.setString(6, account.getCustomer().getPinCode());
			statement.setDouble(7, account.getBalance());
			int i = statement.executeUpdate();
			ResultSet set = statement.getGeneratedKeys();
			set.next();
			account.getAccountNo();

			if (i > 0)
				System.out.println("executed");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateBalance(Integer accountNo, double balance) throws SQLException {
		
		try {
			Connection connection = BankingJDBCUtility.getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE ACCOUNT SET BALANCE=? WHERE ACCOUNTNUMBER=?");
			statement.setDouble(1, balance);
			statement.setInt(2, accountNo);
			if (statement.executeUpdate() > 0) {
				System.out.println("Balance Updated by amount:" + balance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addTransaction(Transaction transaction, Account account) throws SQLException {
		try {
			Connection connection = BankingJDBCUtility.getConnection();
			PreparedStatement statement = connection.prepareStatement("TRANS_ID.nextval,?,?,?");
			statement.setLong(1, account.getAccountNo());
			statement.setDouble(2, transaction.getTransactionAmount());
			statement.setString(3, transaction.getTransactionType());
			if (statement.executeUpdate() > 0) {
				System.out.println(" Transaction is added");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Transaction> getTransactions(Integer accountNo) throws SQLException {
		List<Transaction> transactions = null;
		try {
			transactions = new ArrayList<>();
			Connection connection = BankingJDBCUtility.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from transaction where account = ?");
			statement.setLong(1, accountNo);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Transaction trans = new Transaction();
				trans.setTransactionAmount(resultSet.getDouble(1));		
				trans.setTransactionType(resultSet.getString(2));
				transactions.add(trans);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactions;
	}

	@Override
	public Account getAccount(Integer accountNo) throws SQLException {
		Account account=new Account();
		Customer customer = new Customer();
		try {
			Connection connection = BankingJDBCUtility.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from account where accountnumber = ?");
			statement.setLong(1, accountNo);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				customer.setName(resultSet.getString(4));
				customer.setPhoneNo(resultSet.getString(5));
				account.setBalance(resultSet.getDouble(3));
				account.setAccountType(resultSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;

}

}
