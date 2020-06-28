package com.DevOps.Capstone.Project.TableDB;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Enquiry_details")

public class EnquiryTB 
{
		@Id
		@Column(name="Account_number")
		private int accnumber;
	
		@Column(name="Branch_code")
		private int branchCode;
		
		@Column(name="Account_type")
		private String accounttype;
		
		@Column(name="Balance")
		private int bal;

		@Column(name=" Currency") 
		private String currency;
		
		@Column(name="Status") 
		private String status;

		public int getAccnumber() {
			return accnumber;
		}

		public void setAccnumber(int accnumber) {
			this.accnumber = accnumber;
		}

		public int getBranchCode() {
			return branchCode;
		}

		public void setBranchCode(int branchCode) {
			this.branchCode = branchCode;
		}

		public String getAccounttype() {
			return accounttype;
		}

		public void setAccounttype(String accounttype) {
			this.accounttype = accounttype;
		}

		public int getBal() {
			return bal;
		}

		public void setBal(int bal) {
			this.bal = bal;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		
		
		
		
	}
