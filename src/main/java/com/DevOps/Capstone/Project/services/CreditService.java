package com.DevOps.Capstone.Project.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevOps.Capstone.Project.Controller.FundTransferController;
import com.DevOps.Capstone.Project.TableDB.EnquiryTB;
import com.DevOps.Capstone.Project.TableDB.FundTransferTB;
import com.DevOps.Capstone.Project.repository.EnquiryRepository;
import com.DevOps.Capstone.Project.repository.FundTransferRepository;

@Service
public class CreditService 
{
	@Autowired
	FundTransferRepository repoObj;
	@Autowired
	EnquiryRepository enqRepo;
	@Autowired
	FundTransferController fundCrtl;
	
	public String updateDetails(int Id) throws EntityNotFoundException
	{
		int branchCode = enqRepo.getOne(Id).getBranchCode();
		System.out.println("branchCode from db in credit service: "+branchCode);
		
		int balance = enqRepo.getOne(Id).getBal();
		System.out.println("balance from db in credit service: "+balance);
		
		int closingBal = balance + fundCrtl.getAmt();
		System.out.println("closing balance after crediting is: "+closingBal);
		
		SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = obj.format(new Date());
		System.out.println("date in string: "+date);
		
		// inserting details in customer transaction table
		FundTransferTB fundDBobj = new FundTransferTB();		
		fundDBobj.setAccountNumber(Id);
		fundDBobj.setBranchCode(branchCode);
		fundDBobj.setClosingBalance(closingBal);
		fundDBobj.setDateTime(date);
		fundDBobj.setWithdrawal(0);
		fundDBobj.setDeposit(fundCrtl.getAmt());
		fundDBobj.setDescription(fundCrtl.getRemark());		
		repoObj.save(fundDBobj);
		
		// updating account balance in enquiry table
		EnquiryTB enqDBobj = enqRepo.findById(Id).get();
		enqDBobj.setBal(closingBal);
		enqRepo.save(enqDBobj);
		
		return null;		
	}
}
