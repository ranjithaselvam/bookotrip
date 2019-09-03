package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class UtilsTest {

public static  String[][] excel(String path) throws IOException {
File file = new File(path);
FileInputStream fileInput = new FileInputStream(file);
XSSFWorkbook book = new XSSFWorkbook(fileInput);
XSSFSheet sheet = book.getSheetAt(0);
int row1 = sheet.getLastRowNum();
row1 += 1;
// System.out.println(row1);
int col = sheet.getRow(0).getLastCellNum();
String array[][] = new String[row1][col];
int count = 0;
for (Row row : sheet) {
int count1 = 0;
for (Cell cell : row) {
String Data = cell.toString();
array[count][count1] = Data;
count1++;
}
count++;
}

return array;
}
	}

	


	