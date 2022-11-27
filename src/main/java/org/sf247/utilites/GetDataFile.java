package org.sf247.utilites;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sf247.enumenators.StudyProfile;
import org.sf247.modelclass.Student;
import org.sf247.modelclass.University;

import java.io.FileInputStream;
import java.util.*;

public class GetDataFile {
    static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static Iterator<Row> rowIterator;
    private static Row row;
    private static FileInputStream fis;

    private GetDataFile() { }

    public static List<Student> getStudent() {
        try {
            fis = new FileInputStream("src\\main\\resources\\universityInfo.xlsx");
            workbook = new XSSFWorkbook(fis);

            sheet = workbook.getSheet("Студенты");
            rowIterator = sheet.iterator();
            List<Student> students = new ArrayList<>();

            rowIterator.next();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                students.add(new Student(row.getCell(1).getStringCellValue(), row.getCell(0).getStringCellValue(),
                        (int) row.getCell(2).getNumericCellValue(), (float) row.getCell(3).getNumericCellValue()));
            }
            return students;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<University> getUniver() {
        try{
            fis = new FileInputStream("src\\main\\resources\\universityInfo.xlsx");
            workbook = new XSSFWorkbook(fis);

            sheet = workbook.getSheet("Университеты");
            rowIterator = sheet.iterator();
            List<University> universities = new ArrayList<>();

            rowIterator.next();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                universities.add(new University(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(), (int) row.getCell(3).getNumericCellValue(), StudyProfile.valueOf(row.getCell(4).getStringCellValue())));
            }
            return universities;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

