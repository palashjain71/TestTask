package com.testTask.app.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.testTask.app.LogicComponent.LogicComponents;
import com.testTask.app.config.TestSetup;
import com.testTask.app.util.Util;
import com.testTask.data.GlobalTestData;

public class TestTaskAPIValidation extends TestSetup {

	@Test(dataProvider = "testAPIData", dataProviderClass = com.testTask.data.TestData.class)
	public void verifyTestAPI(String categoriesValue, String catalogueValue) {
		try {

			test.info(MarkupHelper.createLabel("Execution started", ExtentColor.ORANGE));
			test.info("BaseURL -- > " + GlobalTestData.BaseURI);
			LogicComponents lg = new LogicComponents();
			String response = lg.validateTestAPI(categoriesValue, catalogueValue);

			test.info("Response --> " + response);

			Util.validateJsonItem("equal", response, "Name", "Carbon credits");

			Util.validateJsonItem("equal", response, "CanRelist", "true");

			JSONObject obj = new JSONObject(response);
			JSONArray arr = obj.getJSONArray("Promotions");

			for (int i = 0; i < arr.length(); i++) {
				if (arr.getJSONObject(i).getString("Name").contains("Gallery")) {
					if (arr.getJSONObject(i).getString("Description").contains("2x larger image")) {
						test.pass(" Description tag present and match Expected  --> 2x larger image Actual --> "
								+ arr.getJSONObject(i).getString("Description"));
					} else {
						test.fail("Description tag present andbut not matched Expected  --> 2x larger image Actual --> "
								+ arr.getJSONObject(i).getString("Description"));
					}

				}
			}

			test.info(MarkupHelper.createLabel("Execution finished ", ExtentColor.ORANGE));

		} catch (Exception e) {
			test.fail("API test case failed due to exception " + e.getMessage());
			test.fail("API test case failed due to exception " + e.getClass());
		}

	}

}
