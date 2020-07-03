package com.DevOps.Capstone.Project.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.DevOps.Capstone.Project.Controller.ResetPWContoller;
import com.DevOps.Capstone.Project.HTML.ResetPwHTML;
import com.DevOps.Capstone.Project.TableDB.LoginTB;
import com.DevOps.Capstone.Project.repository.LoginRepository;

@Service
public class ResetPwService 
{
	@Autowired
	LoginRepository repoObj;
	
	@Autowired
	ResetPWContoller resetCtrl;
	
	public String getUserID(@RequestBody String userId2) throws EntityNotFoundException
	{ 
		String Userid = repoObj.getOne(userId2.getUserId()).getUserID();
		System.out.println("userID from Db in getUserID function: "+Userid);
		return Userid;
	}

	public String updatePassword(String Id) throws EntityNotFoundException
	{
		LoginTB DBobj = repoObj.findById(Id).get();
		System.out.println("Password from resetPW controller: "+resetCtrl.getPassword());
		DBobj.setPassword(resetCtrl.getPassword());
		repoObj.save(DBobj);
		System.out.println("Password updated successfully for "+Id);
		return null;		
	}
}
