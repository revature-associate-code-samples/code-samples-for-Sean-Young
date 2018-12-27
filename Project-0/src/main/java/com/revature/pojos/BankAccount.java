package com.revature.pojos;

public class BankAccount {
	private int accountId;
	private int type;
	private int owner;
	private double balance;
	
	public BankAccount() {
		
	}
	
	public BankAccount(int accountId, int type, int owner, int balance) {
		super();
		this.accountId = accountId;
		this.type = type;
		this.owner = owner;
		this.balance = balance;
		}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", type=" + type + ", owner=" + owner + ", balance=" + balance
				+ "]";
	}
	
	
}
