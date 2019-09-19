package com.cv.mailer.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetEmails {

	public List<String> getEmailList(){
		
		List<String> listOfMails = new ArrayList<String>();
		
		File myFile = new File("C://Users//User//Documents//software-house-prog-file.xlsx");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(myFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Finds the workbook instance for XLSX file
		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Return first sheet from the XLSX workbook
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		
		DataFormatter dataFormatter = new DataFormatter();

		// Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = mySheet.iterator();

		// Traversing over each row of XLSX file
		
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			// For each row, iterate through each columns
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				//System.out.printf("%s\t", cell.getStringCellValue());
				if(!cell.getStringCellValue().equals(""))
					listOfMails.add(cell.getStringCellValue());
			}
			System.out.println("");
		}
		
		return listOfMails;
	}
}
