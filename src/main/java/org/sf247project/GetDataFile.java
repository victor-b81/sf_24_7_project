package org.sf247project;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.*;

public class GetDataFile {
    private final XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private Iterator<Row> rowIterator;
    private Row row;

    public GetDataFile() {
        try {
            FileInputStream fis = new FileInputStream("G:\\Мой диск\\Java_Idea\\sf_24_7_project\\src\\main\\resources\\universityInfo.xlsx");
            workbook = new XSSFWorkbook(fis);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<Student> getStudent() {
        try {
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
//            for (Student str : students){
//                System.out.println(str);
//            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<University> getUniver() {
        try{
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

