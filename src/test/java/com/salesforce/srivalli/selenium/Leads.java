package com.salesforce.srivalli.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Leads {
	public static WebDriver driver = BrowserLaunch.driver;
	
	static void leadsTab_TC20() throws InterruptedException{
		SFDCLoginpage.login_To_SalesForce_2();
		driver.findElement(By.xpath("//ul[contains(@class,'zen-inlineList zen-tabMenu')]//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		String val = driver.findElement(By.xpath("//h2[@class='pageDescription']")).getText();
		System.out.println(val);
		System.out.println("TC20 pass");
	
	}
	
	
	static void leadsSelectView_TC21() throws InterruptedException{
		SFDCLoginpage.login_To_SalesForce_2();
		driver.findElement(By.xpath("//ul[contains(@class,'zen-inlineList zen-tabMenu')]//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		String viewdropdown = driver.findElement(By.xpath("//select[@name='fcf']")).getText();
		//System.out.println(viewdropdown);
		String viewval = "All Open Leads\nMy Unread Leads\nRecently Viewed Leads\nToday's Leads\nView - Custom 1\nView - Custom 2";
	if (viewval.equals(viewdropdown)){
		System.out.println("TC21 pass");
	}else 
		System.out.println("TC21 fail");
	}

	static void defaultView_TC22() throws InterruptedException{
		SFDCLoginpage.login_To_SalesForce_2();
		driver.findElement(By.xpath("//ul[contains(@class,'zen-inlineList zen-tabMenu')]//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		
		Select select = new Select(driver.findElement(By.xpath("//select[@name='fcf']")));

		WebElement option = select.getFirstSelectedOption();

		String defaultItem_beforelogout = option.getText();

		System.out.println(defaultItem_beforelogout );
		
		//logging out 
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		Actions act = new Actions(driver);
		act.moveToElement(logout).build().perform();
		Thread.sleep(2000);
		logout.click();
		
		//login again
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(TestApp.username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(TestApp.pswd);
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@id='phHeaderLogoImage']"))));
		
		//Lead tab
		driver.findElement(By.xpath("//ul[contains(@class,'zen-inlineList zen-tabMenu')]//a[contains(text(),'Leads')]")).click();
			//driver.findElement(By.id("tryLexDialogX")).click();
		Select select1 = new Select(driver.findElement(By.xpath("//select[@name='fcf']")));
		WebElement option1 = select1.getFirstSelectedOption();
		String defaultItem_afterlogout = option1.getText();
		System.out.println(defaultItem_afterlogout );
		
		if(defaultItem_beforelogout.equals(defaultItem_beforelogout)){
			System.out.println("TC22 pass");
		}else 
			System.out.println("TC22 fail");
		
	}

	static void TodaysLeads_TC23() throws InterruptedException{
		SFDCLoginpage.login_To_SalesForce_2();
		driver.findElement(By.xpath("//ul[contains(@class,'zen-inlineList zen-tabMenu')]//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		WebElement viewdropdown = driver.findElement(By.xpath("//select[@name='fcf']"));
		Select viewdropdown1=new Select(viewdropdown);
		viewdropdown1.selectByVisibleText("Today's Leads");
		String val = "Today's Leads";
		
		Select select1 = new Select(driver.findElement(By.xpath("//select[@name='fcf']")));
		WebElement option1 = select1.getFirstSelectedOption();
		String defaultItem_afterlogout = option1.getText();
		
		if(defaultItem_afterlogout.equals(val)){
			System.out.println("TC23 pass");
		}else 
			System.out.println("TC23 fail");
		
	}
	
	
	static void NewLead_TC24() throws InterruptedException{
		
		SFDCLoginpage.login_To_SalesForce_2();
		driver.findElement(By.xpath("//ul[contains(@class,'zen-inlineList zen-tabMenu')]//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		driver.findElement(By.xpath("//input[@name='new']")).click();
		driver.findElement(By.xpath("//input[contains(@name,'name_lastlea2')]")).sendKeys((String)TestApp.myProps.get("leadlname"));
		driver.findElement(By.xpath("//input[contains(@name,'lea3')]")).sendKeys((String)TestApp.myProps.get("leadcompany"));
		driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//input[1]")).click();
		String lname = driver.findElement(By.xpath("//h2[contains(@class,'topName')]")).getText();
				//System.out.println(lname);
				//String lnameval = (String)TestApp.myProps.get("leadlname");
				//System.out.println(lnameval);
				
				if(lname.equals((String)TestApp.myProps.get("leadlname"))){
					System.out.println("TC24 pass");
				}else 
					System.out.println("TC24 fail");
		
		
	}
}
