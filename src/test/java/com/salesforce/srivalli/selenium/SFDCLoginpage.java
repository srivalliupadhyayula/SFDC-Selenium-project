package com.salesforce.srivalli.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SFDCLoginpage {
	
	public static WebDriver driver = BrowserLaunch.driver;
	

	//Successful login to safesforce 
	
	static void login_To_SalesForce_2() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Login')]"))));
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//label[@class='label usernamelabel']"))));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#main")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(TestApp.username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(TestApp.pswd);
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		System.out.println("Login successfull");
		System.out.println("Login To SalesForce -2 testcase pass");
		
	}
	
	static void login_Error_Message_1(){
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Login')]"))));
	driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//label[@class='label usernamelabel']"))));
	
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys(TestApp.username);
	//driver.findElement(By.xpath("//input[@id='password']")).sendKeys(TestApp.pswd);
	driver.findElement(By.xpath("//input[@id='Login']")).click();
	String Errormsg = "Please enter your password.";
	String msg = (String) driver.findElement(By.xpath("//div[@id='error']")).getText();
	//System.out.println(msg);
	if(Errormsg.equals(msg)){
		System.out.println("Login Error Message - 1 -----Testcase pass");
	}else
		System.out.println("Login Error Message - 1-----testcase Fail");

}

	static void check_RememberMe_3(){
		try {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Login')]"))));
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//label[@class='label usernamelabel']"))));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(TestApp.username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(TestApp.pswd);
		driver.findElement(By.xpath("//input[@id='rememberUn']")).click();
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@id='phHeaderLogoImage']"))));
		
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		Actions act = new Actions(driver);
		act.moveToElement(logout).build().perform();
		Thread.sleep(2000);
		logout.click();
		//System.out.println("Logout Successful");
		String uid = (String)driver.findElement(By.id("username_container")).getText();	
		//System.out.println(uid);
		WebElement Rememberme = driver.findElement(By.id("rememberUn"));
		Boolean x = true;
		
		if(!Rememberme.isSelected()){
			//System.out.println("Remenmer me checkbox is not checked");
			x=false;
			
			}
		//else
			//System.out.println("Remember me checkbox is checked");
		
				
		if((TestApp.username.equals(uid))&& (x == true)){
			System.out.println("Check RemeberMe - 3 ----Testcase Pass");
		}else
			System.out.println("Check RemeberMe - 3----Testcase Fail");
		}
		catch (Exception e){
			System.out.println("Exception found in Check_RememberMe");
		}
		
	}

	static void forgot_Password_4A(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Login')]"))));
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//label[@class='label usernamelabel']"))));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("forgot_password_link")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("header"))));
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys(TestApp.username);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		String ResetMsg = driver.findElement(By.xpath("//p[contains(text(),'ve sent you an email ')]")).getText();
		String resetmsgveriy = "We’ve sent you an email with a link to finish resetting your password.";
		if(resetmsgveriy.equals(ResetMsg)){
			System.out.println("Forgot Password- 4 A---Testcase Pass");
		}else
			System.out.println("Forgot Password- 4 A-----Testcase Fail");
	}
	
	static void forgot_Password_4B(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Login')]"))));
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//label[@class='label usernamelabel']"))));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("22131");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		String Errormsgvalidate = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String Errormsg = driver.findElement(By.xpath("//div[@id='error']")).getText();
		if(Errormsgvalidate.equals(Errormsg)){
			System.out.println("Forgot Password- 4 B---Testcase Pass");
		}else
			System.out.println("Forgot Password- 4 B-----Testcase Fail");
		
	}














}
