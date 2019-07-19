package com.testTask.app.LogicComponent;

import com.testTask.app.config.TestSetup;
import com.testTask.app.util.FrameworkException;
import com.testTask.app.util.Util;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;

public class LogicComponents extends TestSetup {

	public String categories(String categoriesValue, String catalogueValue) throws FrameworkException {

		// Base URL Or Host
		RestAssured.baseURI = Util.getProperty("BaseURI");
		// response in Raw format
		Response res = given().param("catalogue", catalogueValue).when()
				.get("/v1/Categories/" + categoriesValue + "/Details.json").then().assertThat().statusCode(200)
				.extract().response();
		return res.asString();
	}

	public boolean validateCatagoriesResponse(String response, String valuesToCompare) throws FrameworkException {
		String[] valuesToCompareArray = valuesToCompare.split(":");

		Util.validateJsonItem("equal", response, "Name", valuesToCompareArray[0]);

		Util.validateJsonItem("equal", response, "CanRelist", valuesToCompareArray[1]);
		JSONArray arr = null;
		boolean isNameFieldGalleryValuePresent = false;
		try {
			JSONObject obj = new JSONObject(response);
			arr = obj.getJSONArray("Promotions");
		} catch (NullPointerException e) {
			throw new FrameworkException("Field Name with Promotions value is not present in response JSON ");
		}
		for (int i = 0; i < arr.length(); i++) {
			if (arr.getJSONObject(i).getString("Name").contains("Gallery")) {
				isNameFieldGalleryValuePresent = true;
				response = arr.getJSONObject(i).toString();
				Util.validateJsonItem("contains", response, "Description", valuesToCompareArray[2]);
				break;
			}
		}

		if (!isNameFieldGalleryValuePresent) {
			throw new FrameworkException("Field Name with Gallery value is not present in response JSON ");
		}
		return true;
	}

}
