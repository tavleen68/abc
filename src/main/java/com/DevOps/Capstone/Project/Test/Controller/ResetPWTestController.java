package com.DevOps.Capstone.Project.Test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.DevOps.Capstone.Project.HTML.ResetPwHTML;
import com.DevOps.Capstone.Project.services.ResetPwService;

@Controller
public class ResetPWTestController
{
@Autowired
ResetPwService resetService;


@RequestMapping(value = "/forgetPassword/unitTest")
public String ResetPWack(ResetPwHTML HTMLobj)
{
String UserId = HTMLobj.getUserId();


try
{
String userID = resetService.getUserID(UserId);
if (userID != null)
{
if (userID.equals(UserId))
{

String password = HTMLobj.getPassword();
String confirmPW = HTMLobj.getConfirmPW();

if (password.equals(confirmPW))
{


resetService.updatePassword(userID);

return "Password has been reset successfully";
}

else
{
return "Password mismatch";
}
}
}
else
{
return "Please enter correct User ID";
}
}
catch (Exception e)
{
e.printStackTrace();
}
return null;
}

}