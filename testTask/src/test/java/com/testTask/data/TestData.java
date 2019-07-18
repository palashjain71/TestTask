package com.testTask.data;

import org.testng.annotations.DataProvider;

import com.testTask.app.util.FrameworkException;
import com.testTask.app.util.Util;

public class TestData {

	@DataProvider(name = "testAPIData")
	public static Object[][] testAPIData() throws FrameworkException {
		return Util.Read_Excel("TestData.xlsx", "testAPIData");
	}

}
