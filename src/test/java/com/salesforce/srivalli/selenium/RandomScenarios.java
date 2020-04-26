package com.salesforce.srivalli.selenium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RandomScenarios {
	public static WebDriver driver = BrowserLaunch.driver;
	
	static void homepage_TC33() throws InterruptedException{
		SFDCLoginpage.login_To_SalesForce_2();
		driver.findElement(By.xpath("//li[@class='zen-firstItem']//a[contains(text(),'Home')]")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		String username = (String)TestApp.myProps.get("usernamexpath");
		
		driver.findElement(By.xpath("//a[contains(text(),'"+username+"')]")).click();
		String Uname= driver.findElement(By.xpath("//span[contains(@class,'tailNode cxTailNode')]")).getText();
		System.out.println(username);
		System.out.println(Uname);
		
		if(username.equals(Uname.trim())){
			System.out.println("TC33---pass");
		}else 
			System.out.println("TC33---fail");
	}
	
	static void editLastName_TC34() throws InterruptedException{
		SFDCLoginpage.login_To_SalesForce_2();
		driver.findElement(By.xpath("//li[@class='zen-firstItem']//a[contains(text(),'Home')]")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		String username = (String)TestApp.myProps.get("usernamexpath");
		driver.findElement(By.xpath("//a[contains(text(),'"+username+"')]")).click();
		driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img")).click();
		driver.switchTo().frame("contactInfoContentId");
		driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
		
		driver.findElement(By.xpath("//input[@name='firstName']")).clear();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("srivalli");
		driver.findElement(By.xpath("//input[contains(@name,'lastName')]")).clear();
		driver.findElement(By.xpath("//input[contains(@name,'lastName')]")).sendKeys("u");
		driver.findElement(By.xpath("//input[contains(@class,'zen-btn zen-primaryBtn zen-pas')]")).click();
	}
	
	static void customisetabs_TC35() throws InterruptedException{
		SFDCLoginpage.login_To_SalesForce_2();
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
		driver.findElement(By.xpath("//input[contains(@name,'customize')]")).click();
		WebElement seletab = driver.findElement(By.xpath("//select[contains(@name,'duel_select_1')]"));
		String removetab = (String)TestApp.myProps.get("removetab");
		Select tabdropDown1=new Select(seletab);
		tabdropDown1.selectByVisibleText(removetab);
		
		driver.findElement(By.xpath("//img[contains(@class,'leftArrowIcon')]")).click();
		driver.findElement(By.xpath("//td[contains(@class,'pbButtonb')]//input[contains(@name,'save')]")).click();
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		Actions act = new Actions(driver);
		act.moveToElement(logout).build().perform();
		Thread.sleep(2000);
		logout.click();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(TestApp.username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(TestApp.pswd);
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		WebElement tablist = driver.findElement(By.xpath("//div[contains(@class,'brdPalette zen-headerBottom zen-hasTabOrganizer')]//nav"));
		String tabliststr = tablist.getText();
		System.out.println(tabliststr);
		System.out.println(removetab);
		if(tabliststr.contains(removetab)){
			System.out.println("TC35-----fail");
		}else 
			System.out.println("TC35----pass");

		
	}

	static void calanderevent_TC36() throws InterruptedException{
		SFDCLoginpage.login_To_SalesForce_2();
		driver.findElement(By.xpath("//li[@class='zen-firstItem']//a[contains(text(),'Home')]")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		driver.findElement(By.xpath("//span[contains(@class,'pageDescription')]//a")).click();
		driver.findElement(By.xpath("//a[contains(text(),'8:00 AM')]")).click();
		driver.findElement(By.xpath("//img[contains(@class,'comboboxIcon')]")).click();
		
		//System.out.println(driver.getTitle());
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> handlesIterator = handles.iterator();
		
		String mainWindowHandle = handlesIterator.next();
		
 		String subWindowHandle = handlesIterator.next();
		
		WebDriver frameDriver = driver.switchTo().window(subWindowHandle);
		driver.findElement(By.xpath("//a[contains(text(),'Other')]")).click();
		driver.switchTo().window(mainWindowHandle);
		driver.findElement(By.xpath("//td[@class='pbButton']//input[@name='save']")).click();
		
		
	}
	
	static void recurranceevent_TC37() throws InterruptedException{
		SFDCLoginpage.login_To_SalesForce_2();
		
		
		
		driver.findElement(By.xpath("//li[@class='zen-firstItem']//a[contains(text(),'Home')]")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		driver.findElement(By.xpath("//span[contains(@class,'pageDescription')]//a")).click();
		driver.findElement(By.xpath("//a[contains(text(),'8:00 AM')]")).click();
		driver.findElement(By.xpath("//img[contains(@class,'comboboxIcon')]")).click();
		
		//System.out.println(driver.getTitle());
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> handlesIterator = handles.iterator();
		
		String mainWindowHandle = handlesIterator.next();
		
 		String subWindowHandle = handlesIterator.next();
		
		WebDriver frameDriver = driver.switchTo().window(subWindowHandle);
		driver.findElement(By.xpath("//a[contains(text(),'Other')]")).click();
		driver.switchTo().window(mainWindowHandle);
		driver.findElement(By.xpath("//input[@name='IsRecurrence']")).click();
		driver.findElement(By.xpath("//input[@id='rectypeftw']")).click();
		driver.findElement(By.xpath("//label[3]")).click();
		driver.findElement(By.xpath("//span[@id='maxRecurrence']//a")).click();
		driver.findElement(By.xpath("//div[@id='ep']//div[contains(@class,'pbHeader')]//input[1]")).click();
		
	}

}
