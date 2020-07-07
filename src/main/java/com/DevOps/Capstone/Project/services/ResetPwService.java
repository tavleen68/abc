package com.DevOps.Capstone.Project.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.DevOps.Capstone.Project.Controller.ResetPWContoller;
import com.DevOps.Capstone.Project.HTML.ResetPwHTML;
import com.DevOps.Capstone.Project.TableDB.LoginTB;
import com.DevOps.Capstone.Project.repository.LoginRepository;

@Service
@Transactional
public class ResetPwService 
{
	@Autowired
	LoginRepository repoObj;
	
	@Autowired 
	ResetPWContoller resetCtrl;
	
	public String getUserID(String userId2) throws EntityNotFoundException
	{ 
		Optional<LoginTB> obj = repoObj.findById(userId2);
		if (obj.isPresent())
		{
		String Userid = obj.get().getUserID();
		System.out.println("userID from Db in getUserID function: "+Userid);
		return Userid;
		}
		else
		{
			return null;
		}
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
