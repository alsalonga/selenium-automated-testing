package mvp.cc.testing.CCData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * Created by asalonga on 12/08/2018.
 */
public class UtilExcelFile {
    XSSFWorkbook wb;
    XSSFSheet sheet;

    public UtilExcelFile(String excelPath) {
        try {
            File src = new File(excelPath);
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getData(int sheetNumber, int row, int column) {
        String data;
        sheet = wb.getSheetAt(sheetNumber);
        data = sheet.getRow(row).getCell(column).getStringCellValue();
        return data;
    }

    public int getRowCount(int sheetIndex) {
        int row = wb.getSheetAt(sheetIndex).getLastRowNum();
        row = row + 1;
        return row;
    }

    public void failTest(){

    }

    public void passTest(){

    }
}
