package com.salesforce.srivalli.selenium;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestApp {
	static String username;
	static String pswd;
	
	static Properties myProps;
	
	public static void main(String[] args) throws Throwable {
		
		try {
			myProps = getProps();
			
			
			username = (String) myProps.get("username");
			pswd = (String) myProps.get("password");
			
			BrowserLaunch.launchBrowser("ch");
//			
//			SFDCLoginpage.login_To_SalesForce_2();
//			SFDCLoginpage.login_Error_Message_1();
//			SFDCLoginpage.check_RememberMe_3();
//			SFDCLoginpage.forgot_Password_4A();
//			SFDCLoginpage.forgot_Password_4B();	
//			
//			User_menu_drop_down.usermenu_TC05();
//			User_menu_drop_down.myProfile_TC06();
//			User_menu_drop_down.mysettings_TC07(); 
//			User_menu_drop_down.usermenu_TC08();
//			User_menu_drop_down.usermenu_TC09();
//			
//			Account.newAccount_TC10();
//			Account.createView_TC11();
//			Account.Editview_TC12();
//			Account.Merge_accounts_TC13();
//			Account.Report_TC14();
			
//			Opportunities.opportunities_dropdown_TC15();
//			Opportunities.opportunity_create_TC16();
//			Opportunities.opportunityPipelineReport_TC17();
//			Opportunities.stuckOpportunitiesReport_TC18();
//			Opportunities.quarterlySummaryReport_TC19();
			
			
			//Leads.leadsTab_TC20();
			//Leads.leadsSelectView_TC21();
			//Leads.defaultView_TC22();
			//Leads.TodaysLeads_TC23();
			//Leads.NewLead_TC24();
			
			//Contacts.newcontact_TC25();
			//Contacts.newview_contact_TC26();
			//Contacts.recentlycreated_TC27();
			//Contacts.mycontact_TC28();
			//Contacts.viewcontact_TC29();
			//Contacts.createview_error_TC30();
			//Contacts.createNewView_cancle_TC31();
			//Contacts.createNewView_SavenNew_TC32();
			
			//RandomScenarios.homepage_TC33();
			//RandomScenarios.editLastName_TC34();
			
			//RandomScenarios.customisetabs_TC35();
			/*Prerequisit-- the required should be available to delete
			this will show its fail if both Authotisation form is removed and authorisation form data use is there.but the testcase is pass*/
			
			//RandomScenarios.calanderevent_TC36();
		
			//RandomScenarios.recurranceevent_TC37();

		
			BrowserLaunch.quitBrowser();
			
			
		} catch (IOException io) {
			System.out.println("Cannot load proprties.");
		}
		
		
	}
	
	public static Properties getProps() throws IOException {
		
		InputStream inp = TestApp.class.getClassLoader().getResourceAsStream("myprops.properties");
		
		Properties props = new Properties();
		
		props.load(inp);
		
		return props;
		
	}

}
