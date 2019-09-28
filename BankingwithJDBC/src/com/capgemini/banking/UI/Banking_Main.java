package com.capgemini.banking.UI;

import java.sql.SQLException;
import java.util.Scanner;

import com.capgemini.banking.bean.Account;
import com.capgemini.banking.bean.Customer;
import com.capgemini.banking.bean.Transaction;
import com.capgemini.banking.exception.AccountNotFoundException;
import com.capgemini.banking.exception.InsufficientBalanceException;
import com.capgemini.banking.service.*;

public class Banking_Main {
	static Scanner sc = new Scanner(System.in);
	private static String input(String string) {
		String input=string;
		System.out.println(input);
		return sc.nextLine();
	}
	
	 static Account customerDetails(){
		 Account account=new Account();
			Customer customer=new Customer();
			sc.nextLine();
			customer.setName(input("Enter Name"));
			customer.setPhoneNo(input("Enter Phone number"));
			customer.setEmailId(input("Enter EmailId"));
			customer.setDoorNo(input("Enter DoorNo"));
			customer.setCity(input("Enter City"));
			customer.setPinCode(input("Enter PinCode"));
			customer.setCountry(input("Enter Country"));
			account.setAccountType(input("Enter the Account Type"));
			account.setCustomer(customer);
			return account;
		 
	 }
	public static void main(String[] args) {

		BankingServiceImpl b=new BankingServiceImpl();
		
		int choice = 0;

		do {
			System.out.println("\n");
			System.out.println("welcome to xyz bank...");
			System.out.println("1.Create Account");
			System.out.println("2.Checkbalance");
			System.out.println("3.Deposit");
			System.out.println("4.Withdraw");
			System.out.println("5.Fund Transfer");
			System.out.println("6.Transaction List");
			System.out.println("7.Exit");
			System.out.println("Enter Choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				
				b.createAccount(customerDetails());
				System.out.println("Account is successfully created");
				break;
			case 2:
				System.out.println("Enter the Account Number");
				try {
					b.checkBalance(sc.nextInt());
				} catch (AccountNotFoundException e1) {
					e1.printStackTrace();
				}
				break;
			
			case 3:
				System.out.println("Enter the Amount to be deposited and Account Number ");
				try {
					b.deposit(sc.nextInt(), sc.nextInt());
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (AccountNotFoundException e) {
					e.printStackTrace();
				}
				sc.nextLine();
				System.out.println("Amount is deposited");
				break;

			case 4:
				System.out.println("Enter the amount to be Withdraw and Account Number ");
				try {
					b.withdraw(sc.nextInt(), sc.nextInt());
				} catch (SQLException | InsufficientBalanceException e) {
					e.printStackTrace();
				}
				System.out.println("Amount is Withdrawn");
				break;
			case 5:
				System.out.println("Enter the sender and reciever account numbers");
				try {
					b.fundtransfer(sc.nextInt(), sc.nextInt(), sc.nextFloat());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("Amount is Transfer");
				break;
			case 6:
				System.out.println("Enter the Account Number");
				b.transactionList(sc.nextInt());
				break;
			case 7:
				System.out.println("**********Thank you**********");
				break;

			}
		} while (choice != 7);
	}
}
