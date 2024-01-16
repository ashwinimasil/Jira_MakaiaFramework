package com.framework.jira.tests.rest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class TC001_CreateIssue extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testcaseName = "Create Issue";
		testDescription = "Create Issue using REST API";
		authors = "Ashwini";
		category = "REST";
		//dataProvider
		dataFileName = "TC001";
	    dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData")
	public void createIncident(File file) {			
		Response response = postWithBodyAsKeyAndUrl("key","{\n"
				+ "    \"fields\": {\n"
				+ "        \"project\": {\n"
				+ "            \"key\": \"RES\"\n"
				+ "        },\n"
				+ "        \"summary\": \"Forgot id\",\n"
				+ "        \"description\": \"Unable to reach HCM supervisor\",\n"
				+ "        \"issuetype\": {\n"
				+ "            \"name\": \"Bug\"\n"
				+ "        }\n"
				+ "    }\n"
				+ "}", "issue");		
		response.prettyPrint();
		verifyContentType(response, "application/json");
		verifyResponseCode(response, 201);	
		key= extractResponseContent(response, "key");

	}	
		
		
	}























