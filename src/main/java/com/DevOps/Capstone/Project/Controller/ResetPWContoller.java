package com.DevOps.Capstone.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.DevOps.Capstone.Project.HTML.ResetPwHTML;
import com.DevOps.Capstone.Project.services.ResetPwService;

@Controller
public class ResetPWContoller 
{
	@Autowired
	ResetPwService resetService;

	private String password;

	@RequestMapping("/forgotPassword")
	public String resetPW()
	{
		return "ResetPassword";
	}


	@RequestMapping(value = "/forgotPassword/Ack", produces = "application/HTML")
	public String ResetPWack(@ModelAttribute ResetPwHTML HTMLobj , BindingResult result, ModelMap model) 
	{
		String UserId = HTMLobj.getUserId();
		System.out.println("UserId from resetPW form: "+UserId);

		try
		{ 
			String userID = resetService.getUserID(HTMLobj);
			System.out.println("userID from resetService :"+userID);
			if (userID != null)
			{		
				if (userID.equals(UserId))
				{
					System.out.println("userId matched");
					setPassword(HTMLobj.getPassword());
					String confirmPW = HTMLobj.getConfirmPW();

					if (getPassword().equals(confirmPW))
					{
						System.out.println("passwords are same");

						resetService.updatePassword(userID);

						model.addAttribute("userID",UserId);

						return "ResetPWack";					
					}

					else
					{
						String error = "Password mismatch";
						System.out.println(error);
						model.addAttribute("error",error);
						return "Error";
					}
				}
			}
				else
				{
					String error = "Please enter correct User ID";
					System.out.println(error);
					model.addAttribute("error",error);
					return "Error";
				}
			}
			catch (Exception e)
			{ 
				e.printStackTrace();
			}
			return null;		
		}


		// getters and setters for variables
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}	

	}