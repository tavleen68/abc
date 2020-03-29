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
public class DebitService 
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
		System.out.println("branchCode from db in debit service: "+branchCode);

		int balance = enqRepo.getOne(Id).getBal();
		System.out.println("balance from db in debit service: "+balance);

		int closingBal = balance - fundCrtl.getAmt();
		System.out.println("closing balance after debiting is: "+closingBal);

		SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = obj.format(new Date());
		System.out.println("date in string: "+date);

		// inserting details in customer transaction table
		FundTransferTB DBobj = new FundTransferTB();		
		DBobj.setAccountNumber(Id);
		DBobj.setBranchCode(branchCode);
		DBobj.setClosingBalance(closingBal);
		DBobj.setDateTime(date);
		DBobj.setWithdrawal(fundCrtl.getAmt());
		DBobj.setDeposit(0);
		DBobj.setDescription(fundCrtl.getRemark());		
		repoObj.save(DBobj);

		// updating account balance in enquiry table
		EnquiryTB enqDBobj = enqRepo.findById(Id).get();
		enqDBobj.setBal(closingBal);
		enqRepo.save(enqDBobj);

		return null;		
	}
}
