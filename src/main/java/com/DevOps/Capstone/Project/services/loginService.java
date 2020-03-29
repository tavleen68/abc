package com.DevOps.Capstone.Project.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DevOps.Capstone.Project.repository.LoginRepository;

@Service
public class loginService 
{
	@Autowired
	LoginRepository repoObj;
	
	public String getID(String ID) throws EntityNotFoundException
	{ 
		String Userid = repoObj.getOne(ID).getUserID();
		System.out.println("userID from Db in findUserId function: "+Userid);
		return Userid;
	}
	
	public String getPassword(String ID) throws EntityNotFoundException
	{
		String password = repoObj.getOne(ID).getPassword();
		System.out.println("password from Db in findpassword function: "+password);
		return password;
	}
}
