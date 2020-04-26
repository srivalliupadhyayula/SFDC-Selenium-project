package com.salesforce.srivalli.selenium;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
public class Newwindowpopupclose {
	public static WebDriver driver = BrowserLaunch.driver;

	static void windowclose(){
				
		ArrayList<String> windowTabs = new ArrayList(driver.getWindowHandles());
			System.out.println(windowTabs.size()); 
			
			if(windowTabs.size()>1){
				driver.switchTo().window(windowTabs.get(1));
				driver.close();
			}
	}
}
