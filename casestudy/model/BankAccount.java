package com.casestudy.model;

import java.util.List;
import java.util.ArrayList;

class BankAccount {
	private static long AccountNumberCount = 1001;
	private long AccountNumber;
	private long MobileNumber;
	private double Balance;
	private String CustomerName;
	private String AccountType;
	private String Branch;
	private List<TransactionAccount> transactions;
	
	//Constructor creation
	public BankAccount(String CustomerName, long MobileNumber, String AccountType, String Branch)
	{
		this.AccountNumber=AccountNumberCount++;
		this.CustomerName=CustomerName;
		this.MobileNumber=MobileNumber;
		if("savings".equalsIgnoreCase(AccountType)||"current".equalsIgnoreCase(AccountType))
		{
			this.AccountType=AccountType;
		}
		else
		{
			this.AccountType="Savings";
		}
		this.Branch=Branch;
		this.Balance=0.0;
		transactions=new ArrayList<>();  
	}
	//getter
	public long getAccountNumber()
	{
		return AccountNumber;
	}
	
	public String getCustomerName()
	{
		return CustomerName;
	}
	
	public long getMobileNumber()
	{
		return MobileNumber;
	}
	
	public String getAccountType()
	{
		return AccountType;
	}
	
	public String getBranch()
	{
		return Branch;
	}
	
	public double getBalance()
	{
		return Balance;
	}
	
	//deposit method
	public void deposit(double amount)
	{
		if(amount>0)
		{
			Balance+=amount;
			System.out.println("Deposited amount: ₹"+amount);
			System.out.println("Total Balance: ₹" + Balance);
		}
		else
		{
			System.out.println("Invalid deposit Amount");
		}
	}
	
	//Update method
	public void withdraw(double amount)
	{
		if(amount>0 && amount<=Balance)
		{
			Balance-=amount;
			System.out.println("Deposited amount: ₹"+amount);
			System.out.println("Total Balance: ₹" + Balance);
		}
		else
		{
			System.out.println("Invalid withdrawal Amount");
		}
	}
	
	//Customer details method
	public void showCustomerDetails()
	{
		System.out.println("Account Number: "+ AccountNumber);
		System.out.println("Customer Name: "+ CustomerName);
		System.out.println("Mobile Number: +91"+ MobileNumber);
		System.out.println("Account Type: "+ AccountType);
		System.out.println("Branch Name: "+ Branch);
		System.out.println("Balance: ₹" + Balance);
	}
	
	
	public void addTransaction(TransactionAccount transactionAccount) 
	{
		transactions.add(transactionAccount);
	}
	public void showTransactionDetails() 
	{
		for(TransactionAccount transactionAccount : transactions)
		{
			transactionAccount.displayTransaction();
		}
	}
	public List<TransactionAccount> getTransactions()
	{
		return transactions;
	}
	
}



