package com.testTask.app.LogicComponent;

import com.testTask.data.GlobalTestData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class LogicComponents  {
	
	public String validateTestAPI(String categoriesValue, String catalogueValue)  {

		// Base URL Or Host
		RestAssured.baseURI = GlobalTestData.BaseURI;
		// response in Raw format
		Response res = given().param("catalogue",catalogueValue).when()
				.get("/v1/Categories/" + categoriesValue + "/Details.json").then()
				.assertThat().statusCode(200)
				.extract().response();
		return res.asString();
	}
	
	
}
