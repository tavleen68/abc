package com.DevOps.Capstone.Project.services;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DevOps.Capstone.Project.repository.EnquiryRepository;

@Service
public class EnquiryService {
	@Autowired
	EnquiryRepository repoObj;
	
	public int findBalance(int ID) throws EntityNotFoundException
	{ 
		int Balance = repoObj.getOne(ID).getBal();
		System.out.println("Balance from db in enquiry service: "+Balance);
		return Balance;
	
	}

	public String findCurrency(int ID) throws EntityNotFoundException
	{ 
		String Currency = repoObj.getOne(ID).getCurrency();
		System.out.println("Currency from db in enquiry service: "+Currency);
		return Currency;
	
	}
	
	public String findStatus(int ID) throws EntityNotFoundException
	{ 
		String Status = repoObj.getOne(ID).getStatus();
		System.out.println("Status from db in enquiry service: "+Status);
		return Status;
	
	}
}
