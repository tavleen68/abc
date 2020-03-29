package com.DevOps.Capstone.Project.TableDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login_details", schema = "bankapp" )
public class LoginTB 
{
	@Id
	@Column(name="user_id")
	private String userID;
	
	@Column(name="password")
	private String password;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="Account_number")
	private int Account_number;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAccount_number() {
		return Account_number;
	}

	public void setAccount_number(int account_number) {
		Account_number = account_number;
	}
	
	
	
}
