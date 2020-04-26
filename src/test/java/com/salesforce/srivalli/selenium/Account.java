package com.salesforce.srivalli.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Account {

	
	public static WebDriver driver = BrowserLaunch.driver;
	
	static void newAccount_TC10() throws InterruptedException{
		
		SFDCLoginpage.login_To_SalesForce_2();
	
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();

		driver.findElement(By.xpath("//a[@class='listRelatedObject accountBlock title']")).click();
		
		driver.findElement(By.id("tryLexDialogX")).click();
		
		driver.findElement(By.xpath("//input[@name='new']")).click();
		
		driver.findElement(By.id("acc2")).sendKeys((String)TestApp.myProps.get("accountname"));
		
		
		WebElement type=driver.findElement(By.id("acc6"));
		Select typedropDown1=new Select(type);
		typedropDown1.selectByValue((String)TestApp.myProps.get("type"));
		
		WebElement priority=driver.findElement(By.id("00N5w00000HQkWG"));
		Select prioritydropDown1=new Select(priority);
		prioritydropDown1.selectByValue((String)TestApp.myProps.get("priority"));
		
		driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]")).click();
		System.out.println("TC10 TestcasePass");
		
	}
	static void createView_TC11() throws InterruptedException{
		SFDCLoginpage.login_To_SalesForce_2();
		
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
	
		driver.findElement(By.xpath("//a[@class='listRelatedObject accountBlock title']")).click();
		
		driver.findElement(By.id("tryLexDialogX")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		driver.findElement(By.id("fname")).sendKeys((String)TestApp.myProps.get("viewname"));
		driver.findElement(By.id("devname")).sendKeys((String)TestApp.myProps.get("viewuniquename"));
		driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']")).click();
		
		
		
	}
	
	static void Editview_TC12() throws InterruptedException{
		SFDCLoginpage.login_To_SalesForce_2();
		
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
	
		driver.findElement(By.xpath("//a[@class='listRelatedObject accountBlock title']")).click();
		
		driver.findElement(By.id("tryLexDialogX")).click();
		
		WebElement viewsearch=driver.findElement(By.id("fcf"));
		Select viewsearchdropDown1=new Select(viewsearch);
		viewsearchdropDown1.selectByVisibleText((String)TestApp.myProps.get("viewname"));
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'filterLinks')]//a[contains(text(),'Edit')]"))));
		
		driver.findElement(By.xpath("//div[contains(@class,'filterLinks')]//a[contains(text(),'Edit')]")).click();
		
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys((String)TestApp.myProps.get("newviewname"));
		driver.findElement(By.id("fscope0")).click();
		
		WebElement field=driver.findElement(By.id("fcol1"));
		Select fielddropDown1=new Select(field);
		fielddropDown1.selectByVisibleText("Account Name");
		
		WebElement Operator=driver.findElement(By.id("fop1"));
		Select OperatordropDown1=new Select(Operator);
		OperatordropDown1.selectByVisibleText("contains");
		driver.findElement(By.id("fval1")).sendKeys("a");
		driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[1]")).click();
		System.out.println("Saved");
		
		
		
		
	}

	static void Merge_accounts_TC13() throws InterruptedException{
		SFDCLoginpage.login_To_SalesForce_2();
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();

		driver.findElement(By.xpath("//a[@class='listRelatedObject accountBlock title']")).click();
		
		driver.findElement(By.id("tryLexDialogX")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]")).click();
		driver.findElement(By.id("srch")).sendKeys((String)TestApp.myProps.get("findacc"));
		driver.findElement(By.xpath("//input[contains(@name,'srchbutton')]")).click();
		
		Thread.sleep(4000);
//		String noaccmsgverify = "No records to merge";
//		String noaccmsg = driver.findElement(By.xpath("//th[contains(@class,'noRowsHeader')]")).getText();
//		System.out.println(noaccmsg);
//		if(noaccmsgverify.equals(noaccmsg)){
//			System.out.println("No accounts found to merg");
//		}else{
			
			driver.findElement(By.id("cid0")).click();
			driver.findElement(By.id("cid1")).click();
			driver.findElement(By.xpath("//div[contains(@class,'pbTopButtons')]//input[contains(@name,'goNext')]")).click();
			
			driver.findElement(By.xpath("//div[contains(@class,'pbTopButtons')]//input[contains(@name,'save')]")).click();
		
			driver.switchTo().alert().accept();
			
			System.out.println("TC13-----testcase pass");
		
	}

	static void Report_TC14() throws InterruptedException{
		
		SFDCLoginpage.login_To_SalesForce_2();
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();

		driver.findElement(By.xpath("//a[@class='listRelatedObject accountBlock title']")).click();
		
		driver.findElement(By.id("tryLexDialogX")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]")).click();
		
		WebElement waitele = driver.findElement(By.id("ext-comp-1053"));
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(waitele));
		
//		WebElement datefield = driver.findElement(By.id("ext-gen148"));
//		Actions act = new Actions(driver);
//		act.moveToElement(datefield).build().perform();
//		Thread.sleep(2000);
//		datefield.click();
//		
//		WebElement datefield1 = driver.findElement(By.id("ext-gen265"));
//		Select datefielddropDown1=new Select(datefield1);
//		datefielddropDown1.selectByVisibleText("Last Modified Date");
		
		driver.findElement(By.id("ext-gen152")).click();
		driver.findElement(By.xpath("//button[contains(@class,'x-btn-text')][contains(text(),'Today')]")).click();
		
		driver.findElement(By.id("ext-gen154")).click();
		driver.findElement(By.cssSelector("#ext-gen298")).click();
		
		driver.findElement(By.cssSelector("#ext-gen49")).click();
		
		driver.findElement(By.xpath("//input[contains(@name,'reportName')]")).sendKeys((String)TestApp.myProps.get("reportname"));
		driver.findElement(By.xpath("//input[contains(@name,'reportDevName')]")).sendKeys((String)TestApp.myProps.get("reportUname"));
		
		
		driver.findElement(By.xpath("//button[contains(text(),'Save and Run Report')]")).click();
	
	System.out.println("TC14 is PAss");
	
	
	}
	
	
}
