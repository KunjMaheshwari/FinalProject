package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    public static void writeBikeDataToExcel(String filePath, List<String> names, List<String> prices, List<String> launchDates) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Upcoming Bikes");

        // Create header row
        XSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("Bike Name");
        header.createCell(1).setCellValue("Price");
        header.createCell(2).setCellValue("Expected Launch Date");

        // Fill data rows
        for (int i = 0; i < names.size(); i++) {
            XSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(names.get(i));
            row.createCell(1).setCellValue(prices.get(i));
            row.createCell(2).setCellValue(launchDates.get(i));
        }

        // Write to file
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        }

        workbook.close();
    }
    public static void writeCarDataToExcel(String filePath, List<String> carNames) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Used Car");

        // Create header row
        XSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("Popular Car Name");

        // Fill data rows
        for (int i = 0; i < carNames.size(); i++) {
            XSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(carNames.get(i));
        }

        // Write to file
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        }

        workbook.close();
    }

}