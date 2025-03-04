package com.selenium.automation.achala.TestData;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {
	
	public static void main(String[] args) throws Exception {
		
		
		FileInputStream fis = new FileInputStream("H:\\Workspace\\Achala_Bank\\src\\com\\selenium\\automation\\achala\\TestData\\login_details.xlsx");
		Workbook workbook= WorkbookFactory.create(fis);
		Sheet sheet1=workbook.getSheet("Bank");
//		for (int i = 0; i < sheet1.getLastRowNum(); i++)
//			{
//			for (int j = 0; j < sheet1.getLastRowNum(); j++) {
//				
//			}
//			try {
//				System.out.println(sheet1.getRow(0).getCell(i).getStringCellValue());
//				System.out.println(sheet1.getRow(1).getCell(i).getStringCellValue());
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			
//		}
		
		List data = new ArrayList<>();		
		for (int i = 0; i < sheet1.getLastRowNum(); i++)
		{			
			Row row=sheet1.getRow(i);
			
			for (int j = 0; j < row.getLastCellNum(); j++)
			{				
				Cell cell= row.getCell(j);
				
				if (cell.getCellType()==CellType.NUMERIC) 
				{
			      // System.out.println(cell.getNumericCellValue());
					
			       data.add(cell.getNumericCellValue());					
				}
				else if (cell.getCellType()==CellType.STRING)
				{
					String val=cell.getStringCellValue();
					data.add(val);					
				}
				else if (cell.getCellType()==CellType.BOOLEAN)
				{
					boolean val=cell.getBooleanCellValue();
					data.add(val);
					
				}
				
				
			}
			
			
		}
		
		System.out.print("The Data is   "+data);
		
	}
	

}
	


