package com.salesforce.srivalli.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {

public static WebDriver driver = null;
	
	static void launchBrowser(String sBrowser) throws InterruptedException{
		
		if(sBrowser.startsWith("ch")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		}
		else if(sBrowser.startsWith("fire")){
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
		}
		
		else {
			System.out.println("You have not given browser type correctly");
		}
		
		driver.manage().window().maximize(); 
		
		driver.get("https://www.salesforce.com/"); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	static void quitBrowser(){
		driver.quit();
	}
	
	static void waitForPageElementToVisible(WebElement eleToWait) {
		WebDriverWait wait = new WebDriverWait(BrowserLaunch.driver, 30);
		System.out.println("trying to wait");
		wait.until(ExpectedConditions.visibilityOf(eleToWait));
		
	}

}
