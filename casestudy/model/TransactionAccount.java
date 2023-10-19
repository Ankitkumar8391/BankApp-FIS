package com.casestudy.model;
import java.text.SimpleDateFormat;
import java.util.*;

public class TransactionAccount {
	private static int TransIdCount = 1;
	private int TransId;
	private long AccNoFrom;
	private long AccNoTo;
	private double Amount;
	private Date dateofTrans;
	private String TransType;
	private double Balance;
	
	//Constructor
	public TransactionAccount(long AccNoFrom,long AccNoTo,double Amount,String TransType,double Balance)
	{
		this.TransId=TransIdCount++;
		this.AccNoFrom=AccNoFrom;
		this.AccNoTo=AccNoTo;
		this.Amount=Amount;
		this.dateofTrans=new Date();
		this.TransType=TransType;
		this.Balance=Balance;
	}
	
	public int getTransId()
	{
		return TransId;
	}
	public long getAccNoFrom()
	{
		return AccNoFrom;
	}
	
	public long getAccNoTo()
	{
		return AccNoTo;
	}
	
	public double getAmount ()
	{
		return Amount;
	}
	
	public Date getDateOfTrans()
	{
		return dateofTrans;
	}
	
	public String getTransType()
	{
		return TransType;
	}
	
	public double getBalance()
	{
		return Balance;
	}
	
	//display transaction method.
	public void displayTransaction()
	{
		SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		System.out.println("Transaction ID: "+ TransId);
		System.out.println("From Account: "+ AccNoFrom);
		System.out.println("To Account: "+ AccNoTo);
		System.out.println("Amount to be sent: "+ Amount);
		System.out.println("Date: "+ dt.format(dateofTrans));
		System.out.println("Type of Transaction: "+ TransType);
		System.out.println("Balance: ₹" + Balance);
	}
}
