package com.jira.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.selenium.jira.pages.Loginpage;
import com.framework.testng.api.base.BaseMethods;


public class TC_001Create_Issue extends BaseMethods{
	@BeforeTest
	public void setfileName() {
		excelFileName="CreateIssue";
		testcaseName="CreateIssue";
		testDescription ="Test data with mandatory Field";
		authors="Ashwini";
		category="Funtional";
	
	}
	@Test//(dataProvider="fetchData")
	public void runCreateIncident() throws IOException, InterruptedException {
		new Loginpage()
		.enterCredentials()
		.clickAll()
		.clickIncident()
		.clickNewOption()
		.getIncidentNum()
		.enterShortDescription()
		.clickSubmitButton()
		.getTheIncident();
		
		}
	

}
