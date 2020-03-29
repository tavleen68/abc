package com.DevOps.Capstone.Project.HTML;

import org.springframework.stereotype.Component;

@Component
public class ResetPwHTML 
{
	public String UserId;
	public String Password;
	public String ConfirmPW;
	
	public ResetPwHTML() { }
	
	public ResetPwHTML(String userId, String password, String confirmPW) {
		super();
		UserId = userId;
		Password = password;
		ConfirmPW = confirmPW;
	}
	
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getConfirmPW() {
		return ConfirmPW;
	}
	public void setConfirmPW(String confirmPW) {
		ConfirmPW = confirmPW;
	}
	
	
}
