package org.sf247project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GetDataFile {

    FileInputStream fis = new FileInputStream("universityInfo.xlsx");
    public GetDataFile() throws FileNotFoundException {
      //  Workbook workbook = new XSSFWorkbook(fis);
    }
}
