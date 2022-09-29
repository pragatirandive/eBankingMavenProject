package com.ebanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xlfile ,String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		int rowCount = sheet.getLastRowNum();
		fi.close();
		workbook.close();
		return rowCount;
	}
	
	public static int getCellCount(String xlfile ,String xlsheet, int rownum ) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		int cellCount = row.getLastCellNum();
		fi.close();
		workbook.close();
		return cellCount;
	}
	public static String getCellData(String xlfile ,String xlsheet, int rownum , int column) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(column);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String celldata = formatter.formatCellValue(cell);
			return celldata;
		} catch (Exception e) {
			data = "";
		}
		fi.close();
		workbook.close();
		return data;
		}
	public static void setCellData(String xlfile ,String xlsheet, int rownum , int column , String data) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(column);
		cell = row.createCell(column);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	
}
