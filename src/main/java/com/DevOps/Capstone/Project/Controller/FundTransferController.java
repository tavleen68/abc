package com.DevOps.Capstone.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.DevOps.Capstone.Project.HTML.FundTransferHTML;
import com.DevOps.Capstone.Project.services.CreditService;
import com.DevOps.Capstone.Project.services.DebitService;
import com.DevOps.Capstone.Project.services.EnquiryService;

@Controller
public class FundTransferController 
{
	@Autowired
	DebitService debitService;
	@Autowired
	CreditService creditService;
	@Autowired
	EnquiryService enqService;
	@Autowired
	DashboardController dashCrtl;

	private int fromAcc,toAcc, amt;
	private String remark;

	@RequestMapping("/dashboard/FundTransfer")
	public String FundTransfer(Model model)
	{

		model.addAttribute("name",dashCrtl.getUserName());
		model.addAttribute("fromAcc",dashCrtl.getAccountnumber());
		model.addAttribute("Balance",dashCrtl.getBal());

		return "FundTransferForm";
	}
	

	@RequestMapping(value = "/dashboard/FundTransfer/confirm", produces = "application/HTML")
	public String FundTransferConfirm(@ModelAttribute FundTransferHTML HTMLobj , BindingResult result, ModelMap model) 
	{
		fromAcc = HTMLobj.getFromAcc();
		System.out.println("fromAcc from Fund Transfer form: "+fromAcc);		
		try
		{ 
			toAcc = HTMLobj.getToAcc();
			System.out.println("toAcc from Fund Transfer form: "+toAcc);
			String Status = enqService.findStatus(toAcc);
			if (Status.equalsIgnoreCase("Active"))
			{
				System.out.println("beneficiary account is active");

				amt = HTMLobj.getAmount();
				System.out.println("amt from Fund Transfer form: "+amt);
				int amount = enqService.findBalance(fromAcc);
				if (amount >= amt)
				{
					System.out.println("enough balance to transfer funds");

					remark = HTMLobj.getRemark();
					System.out.println("Description from Fund transfer form: "+remark);
					
					model.addAttribute("name",dashCrtl.getUserName());
					model.addAttribute("fromAcc",fromAcc);
					model.addAttribute("toAcc",toAcc);		
					model.addAttribute("amount",amt);
					model.addAttribute("Remark",remark);

					return "FundTransferConfirm";					
				}

				else
				{
					String error = "User does not have enough balance to transfer funds";
					System.out.println(error);
					model.addAttribute("error",error);
					return "Error";
				}
			}

			else
			{
				String error = "Beneficiary account is not active";
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


	@RequestMapping(value="/dashboard/FundTransfer/confirm/ack", produces = "application/HTML")
	public String FundTransferAck(ModelMap model) 
	{
		try 
		{
			debitService.updateDetails(fromAcc);
			System.out.println("account " + fromAcc + " has been debited successfully");
		
			creditService.updateDetails(toAcc);
			System.out.println("account " + toAcc + " has been credited successfully");

			model.addAttribute("name",dashCrtl.getUserName());
			model.addAttribute("fromAcc",fromAcc);
			model.addAttribute("toAcc",toAcc);		
			model.addAttribute("amount",amt);

			return "FundTransferAck";
		}
		catch (Exception e)
		{ 
			e.printStackTrace();
		}
		return null;
	}


	// getters and setters for variables
	public int getFromAcc() {
		return fromAcc;
	}

	public void setFromAcc(int fromAcc) {
		this.fromAcc = fromAcc;
	}

	public int getToAcc() {
		return toAcc;
	}

	public void setToAcc(int toAcc) {
		this.toAcc = toAcc;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
