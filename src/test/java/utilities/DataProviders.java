package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DataProviders {
  static FileInputStream file;
  static FileOutputStream fo;
  static XSSFWorkbook workbook;
  static XSSFSheet sheet;
  static XSSFRow row;
  static XSSFCell cell;
  static String pathFile =  "C:/Users/2408392/OneDrive - Cognizant/Documents/FinalProjectExcel.xlsx";
	@DataProvider(name="dp")
	public Object[][] loginData() throws IOException {
		
		//Object data[][] = {{"Ujjwal","Bodkhe","5",1,"2003","Male","962345678"," "}};
		
		//return data;
		
		//opening Excel file and fetching the data 
		 file = new FileInputStream(pathFile);
         workbook = new XSSFWorkbook(file);
         sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = 2;
        Object[][] data = new Object[rowCount - 1][colCount];
        System.out.println("Total test cases: " + (rowCount - 1));
        for (int i = 1; i < rowCount; i++) {
             row = sheet.getRow(i);    
            for (int j = 0; j < colCount; j++) {
            	 cell = row.getCell(j);
            	if (cell == null || cell.getCellType() == CellType.BLANK){
            		data[i - 1][j] = "";
            		
            	}else if(cell.getCellType()==CellType.NUMERIC) {
            		int datas = (int) cell.getNumericCellValue(); ;
            		data[i - 1][j] = String.valueOf(datas);
            	}else if(cell.getCellType()==CellType.STRING) {       		
            		data[i-1][j] = cell.getStringCellValue().trim();
            	}
            }

            System.out.println("Row "+i+": "+Arrays.toString(data[i - 1]));

        }
        workbook.close();
        file.close();
        return data;
	}
}
