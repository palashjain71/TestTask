package com.testTask.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.testTask.app.config.TestSetup;

import io.restassured.path.json.JsonPath;

public class Util extends TestSetup {

	static String content[][] = null;
	static FileInputStream file = null;
	static XSSFWorkbook workbook = null;
	static XSSFSheet sheet = null;
	static String pathName = System.getProperty("user.dir") + "/TestData/";
	static Properties props = new Properties();
	static String strFileName = "config.properties";
	static String strValue;

	/**
	 * Function to create folder.
	 * 
	 * @param folderPath
	 * @author Palash
	 * @return boolean create folder result.
	 */
	public static boolean createFolder(String folderPath) {
		boolean result = false;
		File directory = new File(folderPath);
		if (!directory.exists()) {
			result = directory.mkdir();
		}
		return result;
	}

	/**
	 * validate json to create folder.
	 * 
	 * @author Palash
	 * @param responseJson
	 * @param field
	 *            to verify
	 * 
	 * @throws FrameworkException
	 */

	public static void validateJsonItem(String condition, String responseJson, String fieldToBeVerify,
			String expectedValue) throws FrameworkException {
		try {

			JsonPath js = new JsonPath(responseJson);
			boolean valueMatchFlag = false;
			switch (condition) {
			case "equal":
				valueMatchFlag = js.get(fieldToBeVerify).toString().equals(expectedValue);
				break;
			case "contains":
				valueMatchFlag = js.get(fieldToBeVerify).toString().contains(expectedValue);
				break;
			default:
				valueMatchFlag = false;
				break;
			}
			if (valueMatchFlag) {
				test.pass(fieldToBeVerify + " tag present and match criteria " + condition + " --> Expected "
						+ expectedValue + "  Actual --> " + js.get(fieldToBeVerify).toString());
			} else {
				throw new FrameworkException(fieldToBeVerify + " tag present but not match criteria " + condition
						+ "  --> Expected " + expectedValue + "  Actual --> " + js.get(fieldToBeVerify).toString());
			}
		} catch (NullPointerException e) {
			throw new FrameworkException("Field is not present in response JSON " + fieldToBeVerify);
		}
	}

	/**
	 * Function to create folder.
	 * 
	 * @author Palash
	 * @return random number.
	 */

	public static String randomNum() {
		return new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()).toString();
	}

	/**
	 * Funtion to get todaysDate
	 * 
	 * @author Palash
	 * @return Todays date in yyyyMMdd
	 * 
	 */
	public static String todaysDate() {
		return new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()).toString();
	}

	/**
	 * This function is defined to read content from spreadsheet. This will
	 * return content only and will not return headers.
	 * 
	 * @author Palash
	 * @param fileName
	 *            - Complete file name with extension.
	 * @param sheetName
	 *            - Sheet from where data needs to be retrieved.
	 * @return The content from spreadsheet @ in case of error.
	 * @throws FrameworkException
	 */
	public static String[][] Read_Excel(String fileName, String sheetName) throws FrameworkException {
		try {
			String[][] tabArray = null;
			String CellVal;
			DataFormatter df = new DataFormatter();
			String FilePath = pathName + fileName;
			file = new FileInputStream(new File(FilePath));
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
			int totalRows = sheet.getLastRowNum();
			int startRow = 1; // as first row is header / column values
			int startCol = 0;
			// get Column count
			int totalCols = sheet.getRow(0).getLastCellNum();
			tabArray = new String[totalRows][totalCols];

			for (int i = startRow; i <= totalRows; i++) {
				for (int j = startCol; j < totalCols; j++) {
					Row row = sheet.getRow(i);
					CellVal = df.formatCellValue(row.getCell(j));
					tabArray[i - 1][j] = CellVal;
				}
			}

			workbook.close();
			return tabArray;
		} catch (FileNotFoundException e) {
			throw new FrameworkException("File " + fileName + " not found for reading.");
		} catch (IOException e) {
			throw new FrameworkException("Exception occured while reading " + fileName);
		} catch (Exception e) {
			throw new FrameworkException("Unknown Exception while reading " + fileName + "&" + sheetName + "---"
					+ e.getClass() + "---" + e.getMessage());
		}
	}

	/**
	 * Function to read config parameter from Configuration file.
	 * 
	 * @param strKey
	 *            - Configuration name
	 * @return - string value with configuration name, returns null in case
	 *         configuration parameter not found. @ in case of error.
	 * @throws FrameworkException
	 */
	public static String getProperty(String strKey) throws FrameworkException {
		try {
			File f = new File(strFileName);
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				strValue = props.getProperty(strKey);
				in.close();
			} else
				throw new FrameworkException("Configuration File not found.");
		} catch (Exception e) {
			throw new FrameworkException("Unknown Error encountered while reading " + strKey
					+ " from configuration file. ---" + e.getClass() + "---" + e.getMessage());
		}
		if (strValue != null) {
			return strValue;
		} else {

			throw new FrameworkException(
					"Value '" + strKey + "' not configured in config file. Contact automation team");
		}

	}

}
