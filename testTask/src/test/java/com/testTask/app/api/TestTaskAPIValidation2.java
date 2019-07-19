package com.testTask.app.api;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.testTask.app.LogicComponent.LogicComponents;
import com.testTask.app.util.FrameworkException;

public class TestTaskAPIValidation2 extends LogicComponents {

	@Test(dataProvider = "testAPIData", dataProviderClass = com.testTask.data.TestData.class)
	public void verifyTestAPI(String categoriesValue, String catalogueValue) {
		try {

			String response = categories(categoriesValue, catalogueValue);
			test.info("Response --> " + response);
			assertTrue(validateCatagoriesResponse(response, "Carbon credits:true:2x larger image"), "Validate Response For Categories.");

		} catch (FrameworkException e) {
			test.fail(e.getMessage());
			assertTrue(false, e.getMessage());

		} catch (Exception e) {
			test.fail("API test case failed due to exception " + e.getMessage());
			test.fail("API test case failed due to exception " + e.getClass());
			assertTrue(false, e.getMessage());

		}

	}

}
