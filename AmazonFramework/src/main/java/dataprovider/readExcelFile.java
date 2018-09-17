package dataprovider;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcelFile {

	public void readExcel() throws IOException {

		// Create an object of File class to open xlsx file

		File file = new File("/Users/rajendra/Desktop/TestAutomation/AmazonFramework/data.xlsx");

		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		Workbook guru99Workbook = null;


		guru99Workbook = new XSSFWorkbook(inputStream);

		// Read sheet inside the workbook by its name

		Sheet guru99Sheet = guru99Workbook.getSheetAt(0);

		// Find number of rows in excel file
		
		System.out.println(guru99Sheet.getRow(1).getCell(0).getStringCellValue());
		
		System.out.println(guru99Sheet.getRow(1).getCell(1).getStringCellValue());

		guru99Workbook.close();

	}

	// Main function is calling readExcel function to read data from excel file

	public static void main(String... strings) throws IOException {

		// Create an object of ReadGuru99ExcelFile class

		readExcelFile objExcelFile = new readExcelFile();

		// Call read file method of the class to read data

		objExcelFile.readExcel();

	}

}