package com.interactions.automation.interactions;

import com.interactions.automation.constants.AssignmentConstants;
import com.jayway.restassured.RestAssured;


public class RestAPIHelper {
	
	
	public  String getRestAPI(String path) {
		System.out.println("Getting API for : " + AssignmentConstants.BASEURI+path);
	//	logger.info(LoginToRestAPI.loginresponse.getCookies());
		String resp =
		
		RestAssured.given().log().all().relaxedHTTPSValidation()
        .queryParam("q", "London,UK")
        .queryParam("appid", "b1b1 5 e88fa797225412429c1c50c122a1")
        .when().get(AssignmentConstants.BASEURI+AssignmentConstants.ASSIGNMENT_API+path).then()
        .log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("The Response of the API : " + resp);
		return resp;
	}


}
