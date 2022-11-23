package org.sf247project;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class GetDataFile {

    FileInputStream fis = new FileInputStream("universityInfo.xlsx");
    public GetDataFile() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
    }
}
