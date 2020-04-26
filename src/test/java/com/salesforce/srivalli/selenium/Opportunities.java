package com.salesforce.srivalli.selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Opportunities {
	public static WebDriver driver = BrowserLaunch.driver;
	
	static void opportunities_dropdown_TC15() throws InterruptedException{
		
		SFDCLoginpage.login_To_SalesForce_2();
		driver.findElement(By.xpath("//ul[@class='zen-inlineList zen-tabMenu']//a[contains(text(),'Opportunities')]")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		
		String Opplist = driver.findElement(By.xpath("//select[@name='fcf']")).getText();
		
		String opplistverify = "All Opportunities\nClosing Next Month\nClosing This Month\nMy Opportunities\nNew Last Week\nNew This Week\nOpportunity Pipeline\nPrivate\nRecently Viewed Opportunities\nWon";

		if(opplistverify.equals(Opplist)){
			System.out.println("TC15------Testcase pass");
		} else
			System.out.println("TC15----- Testcase fail");
		
		
	}
	
	
	static void opportunity_create_TC16() throws InterruptedException{
		
		SFDCLoginpage.login_To_SalesForce_2();
		driver.findElement(By.xpath("//ul[@class='zen-inlineList zen-tabMenu']//a[contains(text(),'Opportunities')]")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		driver.findElement(By.xpath("//input[@name='new']")).click();
		
		driver.findElement(By.xpath("//input[contains(@name,'opp3')]")).sendKeys((String)TestApp.myProps.get("Oppname") + (int)Math.random());
		driver.findElement(By.xpath("//span[contains(@class,'lookupInput')]//input[contains(@name,'opp4')]")).sendKeys((String)TestApp.myProps.get("accountname"));
		driver.findElement(By.xpath("//a[contains(text(),'4')]")).click();
		driver.findElement(By.xpath("//td[contains(@class,'last dataCol')]//img[contains(@class,'lookupIcon')]")).click();
			
		Thread.sleep(4000);
		
		Set<String> windowsHandles = driver.getWindowHandles();
		
		System.out.println(windowsHandles);
		System.out.println(windowsHandles.size());
		
		Iterator<String> handlesIterator = windowsHandles.iterator();
		String mainWindowHandle = handlesIterator.next();
		
 		String subWindowHandle = handlesIterator.next();
		
		driver.switchTo().window(subWindowHandle);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		WebElement result = driver.findElement(By.xpath("//frame[@name='resultsFrame']"));
		driver.switchTo().frame(result);
		//System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(@class,'dataCell')]")).click();
		driver.switchTo().window(mainWindowHandle);
		
		WebElement stage=driver.findElement(By.xpath("//select[@name='opp11']"));
		Select stagedropDown1=new Select(stage);
		stagedropDown1.selectByVisibleText("Prospecting");
		
		WebElement leadsource=driver.findElement(By.xpath("//select[contains(@name,'opp6')]"));
		Select leadsourcedropDown1=new Select(leadsource);
		leadsourcedropDown1.selectByVisibleText("Phone Inquiry");
		
		driver.findElement(By.xpath("//input[contains(@name,'opp12')]")).clear();
		driver.findElement(By.xpath("//input[contains(@name,'opp12')]")).sendKeys("5");
		
		
		
		driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//input[1]")).click();
		
	}

	static void opportunityPipelineReport_TC17() throws InterruptedException{
		
		SFDCLoginpage.login_To_SalesForce_2();
		driver.findElement(By.xpath("//ul[@class='zen-inlineList zen-tabMenu']//a[contains(text(),'Opportunities')]")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
				
		driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]")).click();
		System.out.println("Tetstcase 17 pass");
	}
	
	static void stuckOpportunitiesReport_TC18() throws InterruptedException{
		SFDCLoginpage.login_To_SalesForce_2();
		driver.findElement(By.xpath("//ul[@class='zen-inlineList zen-tabMenu']//a[contains(text(),'Opportunities')]")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]")).click();
		System.out.println("TC18 pass");
	}
	
	static void quarterlySummaryReport_TC19() throws InterruptedException{
		SFDCLoginpage.login_To_SalesForce_2();
		driver.findElement(By.xpath("//ul[@class='zen-inlineList zen-tabMenu']//a[contains(text(),'Opportunities')]")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		
		WebElement Interval=driver.findElement(By.xpath("//select[@name='quarter_q']"));
		Select IntervaldropDown1=new Select(Interval);
		IntervaldropDown1.selectByVisibleText("Current and Next FQ");
		
		WebElement include =driver.findElement(By.xpath("//select[@name='open']"));
		Select includedropDown1=new Select(include);
		includedropDown1.selectByVisibleText("All Opportunities");
		
		driver.findElement(By.xpath("//table[@class='opportunitySummary']//input[@name='go']")).click();
		
//		String interval = driver.findElement(By.xpath("//select[contains(@name,'quarter_q')]")).getText();
//		System.out.println(interval);
		
		System.out.println("Tc19 is pass");
		
		
		
	}
	
	
	
	
	
}
