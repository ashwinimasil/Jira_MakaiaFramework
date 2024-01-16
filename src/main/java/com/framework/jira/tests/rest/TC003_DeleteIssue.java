package com.framework.jira.tests.rest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.RestAssured;
public class TC003_DeleteIssue extends RESTAssuredBase{
@BeforeTest // Reporting
public void setValues() {
	testcaseName = "Delete Issue";
	testDescription = "Delete Issue using REST API";
	authors = "Ashwini";
	category = "REST";
	// dataProvider
	dataFileName = "TC003";
	dataFileType = "JSON";
}

@Test(dependsOnMethods="com.framework.jira.tests.rest.TC002_UpdateIssue.updateIssue")

	public void deleteIssue() {
		
		response = RestAssured.delete("issue/" + key);
		System.out.println("Delete issue is completed");
	}

}
