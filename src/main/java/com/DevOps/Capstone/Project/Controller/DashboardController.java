package com.DevOps.Capstone.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.DevOps.Capstone.Project.HTML.LoginHTML;
import com.DevOps.Capstone.Project.services.DashboardService;
import com.DevOps.Capstone.Project.services.EnquiryService;
import com.DevOps.Capstone.Project.services.loginService;

@Controller
public class DashboardController 
{
	@Autowired
	loginService logService;
	@Autowired
	DashboardService dashService;
	@Autowired
	EnquiryService enqService;

	private String UserName, Currency,UserID;
	private int Bal, accountnumber;

	@RequestMapping(value = "/BankAppTomcat/dashboard", produces = "application/HTML")
	public String Dashboard(@ModelAttribute LoginHTML HTMLobj , BindingResult result, ModelMap model) 
	{
		UserID = HTMLobj.getUserId();		
		System.out.println("UserUserID from HTML input:" + UserID);

		String password = HTMLobj.getPassword();
		System.out.println("Password from HTML input:" + password);
		System.out.println("checking userUserID and password");

		try
		{ 
			String userID = logService.getID(UserID);
			System.out.println("userUserID from loginService:" + userID);
			if (userID.equals(UserID))
			{
				System.out.println("userUserID matched");

				String passwrd = logService.getPassword(UserID);
				System.out.println("passwrd from loginService:" + passwrd);
				if (passwrd.equals(password))
				{
					System.out.println("password matched");

					UserName=dashService.findUserName(userID);
					System.out.println("UserName from dashboard service: "+UserName);				
					accountnumber=dashService.findAccountNumber(userID);
					System.out.println("accountnumber from dashboard service: "+accountnumber);				
					Bal = enqService.findBalance(accountnumber);
					System.out.println("Bal from enquiry service: "+Bal);				
					Currency = enqService.findCurrency(accountnumber);
					System.out.println("Currency from enquiry service: "+Currency);

					model.addAttribute("name",UserName);
					model.addAttribute("Balance",Bal);
					model.addAttribute("Currency",Currency);

					return "Dashboard";
				}
				else
				{
					String error = "Password incorrect";
					System.out.println(error);
					model.addAttribute("error",error);
					return "Error";
				}
			}
		}
		catch (Exception e)
		{ 
			e.printStackTrace();
		}
		return null;		
	}


	@RequestMapping(value = "/BankAppTomcat/dashboard/AccSummary")
	public String AccSummary(ModelMap model)
	{
		Bal = enqService.findBalance(accountnumber);

		model.addAttribute("name",UserName);
		model.addAttribute("Balance",Bal);
		model.addAttribute("Currency",Currency);

		return "Dashboard";
	}


	//getters and setters for variables
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public int getBal() {
		return Bal;
	}

	public void setBal(int bal) {
		Bal = bal;
	}

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

}
