package tma.sharing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelFileHandle {

    public static void main(String[] args) {
        WriteExcelFile();

    }

    public static void ReadExcelFile() {

        FileInputStream fis;
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        Row row;
        Cell cell;

        try {
            fis = new FileInputStream("src/main/resources/files/credentials.xlsx");
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            int rowTotal = sheet.getLastRowNum();
            int colTotal = sheet.getRow(0).getLastCellNum();
            System.out.println("Row total: " + rowTotal);
            System.out.println("Column total: " + colTotal);

            for (int j = 0; j < colTotal; j++) {
                System.out.println();
                for (int i = 0; i < rowTotal; i++) {
                    row = sheet.getRow(i);
                    cell = row.getCell(j);
                    System.out.println(cell);
                    cell.setCellValue("Cell testing");
                }
            }

        } catch (FileNotFoundException fif) {
            fif.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void WriteExcelFile() {

        FileInputStream fis;
        FileOutputStream fos;
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        Row row;
        Cell cell;

        try {
            // Create input stream to read sheet, row, cell for writing
            fis = new FileInputStream("src/main/resources/files/Test.xlsx");
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("Sheet1");

            // Create row, cell to write data
            row = sheet.createRow(1);
            cell = row.createCell(1);

            // Set data
            cell.setCellValue("SoftwareTestingMaterial.com");

            // Use output stream to open file and write data
            fos = new FileOutputStream("src/main/resources/files/Test.xlsx");
            workbook.write(fos);
            fos.close();
            System.out.println("END OF WRITING DATA IN EXCEL");

        } catch (FileNotFoundException fif) {
            fif.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}