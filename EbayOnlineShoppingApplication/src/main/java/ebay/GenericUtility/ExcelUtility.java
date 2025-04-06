package ebay.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheet, int row, int coloumn) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/ConfigurationData/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(coloumn).getStringCellValue();
		wb.close();
		return data;

	}

	public int getLastRow(String Sheet) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/ConfigurationData/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lastrow=wb.getSheet(Sheet).getLastRowNum();
		return lastrow;
		}
	
	public void writeBackDataToExcel(String sheet, int row, int cell, String value) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/ConfigurationData/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(value);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/ConfigurationData/Book2.xlsx");
		wb.write(fos);
		wb.close();
		
	}
}
