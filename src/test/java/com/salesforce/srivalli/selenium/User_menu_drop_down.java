package com.salesforce.srivalli.selenium;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class User_menu_drop_down {
	public static WebDriver driver = BrowserLaunch.driver;
	
	static void usermenu_TC05(){
		try{
		SFDCLoginpage.login_To_SalesForce_2();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@id='phHeaderLogoImage']"))));
		
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		
		
		WebElement usermenu = driver.findElement(By.xpath("//div[@id='userNavMenu']"));
		//System.out.println(usermenu.getText());
		
		String usermenu_content = "My Profile\nMy Settings\nDeveloper Console\nSwitch to Lightning Experience\nLogout";
		
		//System.out.println(usermenu_content);
		
		if(usermenu_content.equals(usermenu.getText())){
			System.out.println("TC05 testcase pass");
		}
		else
			System.out.println("Testcase fail");
		
		
		
	} catch(Exception e){
		System.out.println("Exception occured in usermenu_TC05 "+e);
	}
		
	}
	
	
	static void myProfile_TC06() throws InterruptedException{
		SFDCLoginpage.login_To_SalesForce_2();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@id='phHeaderLogoImage']"))));
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		
		WebElement myprofile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		Actions act = new Actions(driver);
		act.moveToElement(myprofile).build().perform();
		Thread.sleep(2000);
		myprofile.click();
		Thread.sleep(2000);
		
		/*//editlastname
		driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img")).click();
		driver.switchTo().frame("contactInfoContentId");
		driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
		driver.findElement(By.xpath("//input[contains(@name,'lastName')]")).clear();
		driver.findElement(By.xpath("//input[contains(@name,'lastName')]")).sendKeys("lastname");
		driver.findElement(By.xpath("//input[contains(@class,'zen-btn zen-primaryBtn zen-pas')]")).click();
		*/
		
		/*//post
		
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]")).click();
		WebElement post = driver.findElement(By.xpath("//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]"));
		driver.switchTo().frame(post);
		System.out.println("inside post");
		WebElement text = driver.findElement(By.cssSelector("body"));
			text.sendKeys("test post");
			driver.findElement(By.id("publishersharebutton")).click();
			*/
			
		//file
		/*
			driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]")).click();
			driver.findElement(By.id("chatterUploadFileAction")).click();
			//driver.findElement(By.id("chatterFile")).click();
			driver.findElement(By.id("chatterFile")).sendKeys("C:\\Users\\abhi_\\Desktop\\Tekarch_tra‌ining\\dragendrop.png");
			*/
			
		//add photo works only when there is no photo.
			driver.findElement(By.xpath("//span[@class='profileImage chatter-avatarFull chatter-avatar']//img[@class='chatter-photo']")).click();
			driver.findElement(By.id("uploadLink")).click();
			WebElement photo = driver.findElement(By.id("uploadPhotoContentId"));
			driver.switchTo().frame(photo);
			driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile")).sendKeys("C:\\Users\\abhi_\\Desktop\\Tekarch_tra‌ining\\addphoto.jpg");
			driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("j_id0:j_id7:save")).click();
			Thread.sleep(2000);
	}
	
	
	
	static void mysettings_TC07() throws InterruptedException{
		SFDCLoginpage.login_To_SalesForce_2();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@id='phHeaderLogoImage']"))));
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		
		WebElement setting = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		Actions act = new Actions(driver);
		act.moveToElement(setting).build().perform();
		Thread.sleep(2000);
		setting.click();
		Thread.sleep(2000);
		
		//personal 
		/*WebElement personal = driver.findElement(By.xpath("//span[@class='folderText'][contains(text(),'Personal')]"));
		
		act.moveToElement(personal).build().perform();
		Thread.sleep(2000);
		personal.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Login History')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]")).click();
		Thread.sleep(3000);
		*/
		//display&layout
		
		WebElement display = driver.findElement(By.xpath("//span[@id='DisplayAndLayout_font']"));
		act.moveToElement(display).build().perform();
		Thread.sleep(2000);
		display.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Customize My Tabs')]")).click();
		WebElement seletab = driver.findElement(By.xpath("//select[contains(@name,'duel_select_0')]"));
		String addtab = (String)TestApp.myProps.get("removetab");
		Select tabdropDown1=new Select(seletab);
		tabdropDown1.selectByVisibleText(addtab);
		
		driver.findElement(By.xpath("//img[contains(@class,'rightArrowIcon')]")).click();
		driver.findElement(By.xpath("//td[contains(@class,'pbButtonb')]//input[contains(@name,'save')]")).click();
		
	}
	
	
	
	static void usermenu_TC08() throws InterruptedException{
		usermenu_TC05();
		WebElement Developer_Console = driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']"));
		Actions act = new Actions(driver);
		act.moveToElement(Developer_Console).build().perform();
		Thread.sleep(2000);
		Developer_Console.click();
		ArrayList<String> windowTabs = new ArrayList(driver.getWindowHandles());
			System.out.println(windowTabs.size()); 
			driver.switchTo().window(windowTabs.get(1));
			driver.close();
		System.out.println("TC08--- testcase pass");
		
	}

	static void usermenu_TC09() throws InterruptedException{
		
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
		System.out.println("Logout successful ----- TC09 testcase pass");
	}


}
