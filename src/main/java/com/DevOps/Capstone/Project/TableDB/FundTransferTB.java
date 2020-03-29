package com.DevOps.Capstone.Project.TableDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_transactions", schema = "bankapp" )
public class FundTransferTB 
{
	@Id
	@Column(name="Account_number")
	private int accountNumber;
	
	@Column(name="Branch_code")
	private int branchCode;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Withdrawal")
	private int withdrawal;
	
	@Column(name="Deposit")
	private int deposit;
	
	@Column(name="Closing_balance")
	private int closingBalance;
	
	@Column(name="Time")
	private String dateTime;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(int withdrawal) {
		this.withdrawal = withdrawal;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(int closingBalance) {
		this.closingBalance = closingBalance;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String obj) {
		this.dateTime = obj;
	}
	
	

}
