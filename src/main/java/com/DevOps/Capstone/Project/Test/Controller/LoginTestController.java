package com.DevOps.Capstone.Project.Test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DevOps.Capstone.Project.HTML.LoginHTML;
import com.DevOps.Capstone.Project.services.DashboardService;
import com.DevOps.Capstone.Project.services.loginService;

@Controller
public class LoginTestController {
@Autowired
loginService logService;
@Autowired
DashboardService dashService;


private String UserID;

@RequestMapping("/login/unitTest")
public String Logintest(LoginHTML HTMLobj)
{
UserID = HTMLobj.getUserId();
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
