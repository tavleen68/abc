package com.DevOps.Capstone.Project.UnitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

import com.DevOps.Capstone.Project.HTML.LoginHTML;
import com.DevOps.Capstone.Project.HTML.ResetPwHTML;
import com.DevOps.Capstone.Project.Test.Controller.LoginTestController;
import com.DevOps.Capstone.Project.Test.Controller.ResetPWTestController;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class Tests {
	
	@Autowired
	LoginTestController loginCtrl;

     @Autowired
	ResetPWTestController resetCtrl;


	@Test
    @Order(1)
	public void testLoginSuccess()
	{
	System.out.println("Running unit test case - 'testLoginSuccess'");

	LoginHTML HTMLobj = new LoginHTML();

	HTMLobj.setUserID("W111");
	HTMLobj.setPassword("W111@1");


	String actual = loginCtrl.Logintest(HTMLobj);

	System.out.println("actual: "+actual);

	String expected = "Login Success";

	System.out.println("checking assertions");

	assertEquals(expected, actual);

	System.out.println("testLoginSuccess Test case ended");
	System.out.println();
	}


	@Test
    @Order(2)
	public void testLoginIncorrectPasswordFailure()
	{
	System.out.println("Running unit test case - 'testLoginIncorrectPasswordFailure'");

	LoginHTML HTMLobj = new LoginHTML();

	HTMLobj.setUserID("W111");
	HTMLobj.setPassword("12345");

	String actual = loginCtrl.Logintest(HTMLobj);

	System.out.println("actual: "+actual);

	String expected = "Password incorrect";

	System.out.println("checking assertions");

	assertEquals(expected, actual);

	System.out.println("testLoginIncorrectPasswordFailure Test case ended");
	System.out.println();
	}


	@Test
    @Order(3)
	public void testResetPasswordSuccess()
	{
	System.out.println("Running unit test case - 'testResetPasswordSuccess'");

	ResetPwHTML HTMLobj = new ResetPwHTML();

	HTMLobj.setUserId("W111");
	HTMLobj.setPassword("1234");
	HTMLobj.setConfirmPW("1234");


	String actual = resetCtrl.ResetPWack(HTMLobj);

	System.out.println("actual: "+actual);

	String expected = "Password has been reset successfully";

	System.out.println("checking assertions");

	assertEquals(expected, actual);

	System.out.println("testResetPasswordSuccess Test case ended");
	System.out.println();
	}


	@Test
    @Order(4)
	public void testResetPasswordMismatchfailure()
	{
	System.out.println("Running unit test case - 'testResetPasswordMismatchfailure'");

	ResetPwHTML HTMLobj = new ResetPwHTML();

	HTMLobj.setUserId("W111");
	HTMLobj.setPassword("1234");
	HTMLobj.setConfirmPW("12");


	String actual = resetCtrl.ResetPWack(HTMLobj);

	System.out.println("actual: "+actual);

	String expected = "Password mismatch";

	System.out.println("checking assertions");

	assertEquals(expected, actual);

	System.out.println("testResetPasswordMismatchfailure Test case ended");
	System.out.println();
	}

	@Test
    @Order(5)
	public void testResetPasswordIncorrectUserIDfailure()
	{
	System.out.println("Running unit test case - 'testResetPasswordIncorrectUserIDfailure'");

	ResetPwHTML HTMLobj = new ResetPwHTML();

	HTMLobj.setUserId("W1");
	HTMLobj.setPassword("1234");
	HTMLobj.setConfirmPW("1234");


	String actual = resetCtrl.ResetPWack(HTMLobj);

	System.out.println("actual: "+actual);

	String expected = "Please enter correct User ID";

	System.out.println("checking assertions");

	assertEquals(expected, actual);

	System.out.println("testResetPasswordIncorrectUserIDfailure Test case ended");
	System.out.println();
	}
	}


