package com.framework.jira.tests.rest;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.config.ConfigurationManager;
import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.response.Response;

public class TC002_UpdateIssue extends RESTAssuredBase {
	
	@BeforeTest // Reporting
	public void setValues() {
		testcaseName = "Update Issue";
		testDescription = "Update Issue using REST API";
		authors = "Ashwini";
		category = "REST";
		// dataProvider
		dataFileName = "TC002";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData", dependsOnMethods = "com.framework.jira.tests.rest.TC001_CreateIssue.createIncident")
	public void updateIssue(File file) {
		 response = putWithBodyParam("key",
				"{\r\n" + "    \"fields\": {\r\n" + "        \"project\": {\r\n" + "            \"key\": \"RES\"\r\n"
						+ "        },\r\n" + "        \"summary\": \"Forgot id\",\r\n"
						+ "        \"description\": \"Unable to reach HCM supervisor -- update query\",\r\n"
						+ "        \"issuetype\": {\r\n" + "            \"name\": \"Bug\"\r\n" + "        }\r\n"
						+ "    }\r\n" + "}",
				"issue" + "/"+key);
		verifyResponseCode(response, 204);
	}
}