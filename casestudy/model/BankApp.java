package com.casestudy.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<BankAccount> accounts = new ArrayList<>();
		
		while(true)
		{
			System.out.println("   Bank Services...!");
			System.out.println("******************************************************");
			System.out.println("1. Create Account");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Show Customer details");
			System.out.println("5. Fund Transfer");
			System.out.println("6. Show Transaction Details");
			System.out.println("7. Exit");
			System.out.println("******************************************************");
			
			System.out.println("Enter your Choice");
			int choice = sc.nextInt();
			//Implementation of the Scanner Class
			switch(choice)
			{
			case 1:
				sc.nextLine();
				System.out.print("Enter Customer Name: ");
				String CustomerName = sc.nextLine();
				
				System.out.print("Enter Mobile Number: ");
				long MobileNumber = sc.nextLong();
				sc.nextLine();
				
				System.out.print("Enter your desired Account Type: ");
				String AccountType = sc.nextLine();
				
				System.out.print("Enter your desired Branch: ");
				String Branch = sc.nextLine();
			
				
				if("savings".equalsIgnoreCase(AccountType) || "current".equalsIgnoreCase(AccountType))
				{
					boolean isMobNumUniq=isMobNumUniq(accounts,MobileNumber);
					if(isMobNumUniq)
					{
						BankAccount account = new BankAccount(CustomerName, MobileNumber, AccountType, Branch);
						accounts.add(account);
						System.out.println("Account Created Succesfully");
						account.showCustomerDetails();
					}
					else
					{
						System.out.println("Phone Number already exists");
					}
				}
				else
				{
					System.out.println("Invalid Account type!!Choose one (Savings/Current)");
				}
				
				
//				BankAccount account = new BankAccount(CustomerName,MobileNumber,AccountType,Branch);
//				accounts.add(account);
//				
//				System.out.println("Account Created Successfully");
//				account.showCustomerDetails();
				
				break;
				
			case 2:
				//Implementing Deposit logic with exception handling
				System.out.println("Enter Account Number to Deposit: ");
				long depositAccount = sc.nextLong();
				System.out.println("Enter your desired Deposit Amount");
				double depositAmount = sc.nextDouble();
				
				try {
					BankAccount depositAcc = FindAccount(accounts, depositAccount);
					depositAcc.deposit(depositAmount);
				}
				catch(NullPointerException e)
				{
					System.out.println("Sorry! Account Not Found");
				}
				break;
				
			case 3:
				//Implementing Withdraw logic with exception handling
				System.out.println("Enter Account Number to Withdraw: ");
				long WithdrawalAccount = sc.nextLong();
				System.out.println("Enter your desired Withdrawal Amount");
				double WithdrawalAmount = sc.nextDouble();
				
				try {
					BankAccount WithdrawalAcc = FindAccount(accounts, WithdrawalAccount);
					WithdrawalAcc.withdraw(WithdrawalAmount);
				}
				catch(NullPointerException e)
				{
					System.out.println("Sorry! Account Not Found");
				}
				
				break;
				
			case 4:
				//Implementing Show customer details logic with exception handling
				System.out.println("Enter Your Account Number");
				long detailsAccount = sc.nextLong();
				try {
					BankAccount detailsAcc = FindAccount(accounts, detailsAccount);
					detailsAcc.showCustomerDetails();
				}
				catch(NullPointerException e)
				{
					System.out.println("Sorry! Account Not Found");
				}
				break;
				
			case 5:
				//Implementing Fund transfer b/w two accounts logic with exception handling
				System.out.println("Enter Source Account Number: ");
				long sourceAcc=sc.nextLong();
				System.out.println("Enter Destination Account Number: ");
				long destinationAcc=sc.nextLong();
				System.out.println("Enter Amount to be transferred: ");
				double Amount=sc.nextDouble();
				System.out.println("Enter your prefered Transaction Type: ");
				String transType=sc.nextLine();
				
				
				try {
					BankAccount sourceAccount = FindAccount(accounts,sourceAcc);
					BankAccount destinationAccount = FindAccount(accounts,destinationAcc);
					
					if(sourceAccount != null && destinationAccount != null)
					{
						if(sourceAccount.getBalance() >= Amount)
						{
							sourceAccount.withdraw(Amount);
							destinationAccount.deposit(Amount);
					
							TransactionAccount sourceTrans = new TransactionAccount(sourceAcc, destinationAcc, Amount, transType,sourceAccount.getBalance());
							TransactionAccount destTrans = new TransactionAccount(sourceAcc, destinationAcc, Amount, transType, destinationAccount.getBalance());
							
							sourceAccount.addTransaction(sourceTrans);
							destinationAccount.addTransaction(destTrans);
							System.out.println("Congratulations!! Fund Transfer has been successfull");
						}
						else {
							System.out.println("Insufficient Balance in the source Account.");
						}
					}
					else
					{
						System.out.println("Any of the accounts not valid.");
					}
				}
				catch(NullPointerException e) {
					System.out.println("Account Invalid. ");
				}
				break;
				
			case 6:
				//Implementing Show transaction details logic and exception handling
				System.out.println("Enter the Account Number: ");
				long TransAccountNum = sc.nextLong();
				
				try {
					BankAccount transAccount = FindAccount(accounts,TransAccountNum);
					List<TransactionAccount> transactions = transAccount.getTransactions();
					if(transactions.isEmpty())
					{
						System.out.println("No Transactions have taken place from this account");
					}
					else
					{
						System.out.println("Transaction Details for the Account Number: "+TransAccountNum);
						for(TransactionAccount transactionAccount : transactions)
						{
							transactionAccount.displayTransaction();
							System.out.println("-----------------------------");
						}
					}					
				}
				catch(NullPointerException e)
				{
					System.out.println("Account not found.");
				}
				
				break;
			
			case 7:
				//Exciting the Bank Application.
				System.out.println("Exiting the Bank Application. Thank You");
				sc.close();
				System.exit(0);
				break;
				
			default:
				//Default Case.
				System.out.println("Invalid Choice!! Please Try Again.");
			}
			
		}
	}
	
	//Method to check Unique property of Mobile Number 
	private static boolean isMobNumUniq(List<BankAccount> accounts, long MobileNumber) {
		for(BankAccount account:accounts)
		{
			if(account.getMobileNumber()==MobileNumber) {
				return false;
			}
		}
		return true;
	}

	//Method to findAccount if Available or not.
	private static BankAccount FindAccount(List<BankAccount> accounts, long AccountNumber)
	{
		for(BankAccount account : accounts)
		{
			if(account.getAccountNumber()== AccountNumber)
			{
				return account;
			}
		}
		return null;
	}
}
