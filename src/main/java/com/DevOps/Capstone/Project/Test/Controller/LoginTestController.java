package com.DevOps.Capstone.Project.Test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DevOps.Capstone.Project.HTML.LoginHTML;
import com.DevOps.Capstone.Project.services.DashboardService;
import com.DevOps.Capstone.Project.services.loginService;

@RestController
public class LoginTestController {
	@Autowired
	loginService logService;
	@Autowired
	DashboardService dashService;

	public String Logintest(LoginHTML HTMLobj)
	{
		String UserID = HTMLobj.getUserId();
		String password = HTMLobj.getPassword();
		try
		{
			String userID = logService.getID(UserID);
			if (userID.equals(UserID)) 
			{
				String passwrd = logService.getPassword(UserID);
				if (passwrd.equals(password))
				{
					return "Login Success";
				}
				else
				{

					return "Password incorrect";
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
		
}
