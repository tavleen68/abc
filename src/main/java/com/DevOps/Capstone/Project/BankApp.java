package com.DevOps.Capstone.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BankApp 
{

	public  void bank() throws InterruptedException 
	{
	
		System.setProperty("webdriver.chrome.driver", "/abc/src/main/resources/chromedriver.exe");
//		D://Softwares & Libs//Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// URL
		driver.get("http://localhost:5050/BankAppTomcat/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.name("userID")).sendKeys("W111");
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("W111@1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Account Summary']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Account Information']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Fund Transfer']")).click();
		
		// To select the static drop down list and which is having Select tag name
				driver.findElement(By.name("fromAcc")).click();
				Select s = new Select(driver.findElement(By.name("fromAcc")));
				s.selectByIndex(1);
				Thread.sleep(1000);
				driver.findElement(By.name("toAcc")).sendKeys("111222332");
				Thread.sleep(1000);
				driver.findElement(By.name("amount")).sendKeys("108");
				Thread.sleep(1000);
				driver.findElement(By.name("Remark")).sendKeys("Fund");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@value='Confirm']")).click();
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@value='Submit']")).click();
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[text()='Home']")).click();
				
				driver.findElement(By.xpath("//input[@value='Logout']")).click();
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@value='Forgot Password?']")).click();
				
				driver.findElement(By.name("UserId")).sendKeys("W12");
				Thread.sleep(1000);
				driver.findElement(By.name("Password")).sendKeys("123456");
				Thread.sleep(1000);
				driver.findElement(By.name("ConfirmPW")).sendKeys("123456");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@value='Reset']")).click();
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@value='Login']")).click();
				
				Thread.sleep(3000);
				driver.findElement(By.name("userID")).sendKeys("W12");
				Thread.sleep(1000);
				driver.findElement(By.name("password")).sendKeys("123456");
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@value='Login']")).click();
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@value='Logout']")).click();
				// Close the Browser
				Thread.sleep(5000);
				driver.close();

	}


	
}
