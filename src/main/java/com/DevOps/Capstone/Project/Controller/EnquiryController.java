package com.DevOps.Capstone.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.DevOps.Capstone.Project.services.DashboardService;
import com.DevOps.Capstone.Project.services.EnquiryService;

@Controller
public class EnquiryController 
{
	@Autowired
	DashboardController dashCtrl;
	@Autowired
	DashboardService dashService;
	@Autowired
	EnquiryService enqService;
	
	@RequestMapping(value = "/BankAppTomcat/dashboard/AccountInfo")
	public String AccountInfo(ModelMap model)
	{
		String UserId = dashCtrl.getUserID();
		System.out.println("UserId from dashboard controller:"+UserId);
		String Username = dashCtrl.getUserName();
		System.out.println("Username from dashboard controller:"+Username);
		int Balance = dashCtrl.getBal();
		System.out.println("Balance from dashboard controller:"+Balance);
		String Currency = dashCtrl.getCurrency();
		System.out.println("Currency from dashboard controller:"+Currency);
		
		int accNumber = dashService.findAccountNumber(UserId);
		System.out.println("accNumber from dashboard service: "+accNumber);
		String Status = enqService.findStatus(accNumber);
		System.out.println("Status from enquiry service: "+Status);
				
		model.addAttribute("name",Username);
		model.addAttribute("AccNumber",accNumber);
		model.addAttribute("Balance",Balance);
		model.addAttribute("Currency",Currency);
		model.addAttribute("Status",Status);
		
		return "Enquiry";
	}
	
}
