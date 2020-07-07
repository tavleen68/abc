package com.DevOps.Capstone.Project.services;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevOps.Capstone.Project.repository.LoginRepository;

@Service
@Transactional
public class DashboardService 
{
	@Autowired
	LoginRepository repoObj;
	public String findUserName(String ID) throws EntityNotFoundException
	{ 
		String UserName = repoObj.getOne(ID).getName();
		System.out.println("UserName from db in dashboard service: "+UserName);
		return UserName;
	
	}

	public int findAccountNumber(String ID) throws EntityNotFoundException
	{ 
		int AccNumber = repoObj.getOne(ID).getAccount_number();
		System.out.println("AccNumber from db in dashboard service: "+AccNumber);
		return AccNumber;
	
	}
}
