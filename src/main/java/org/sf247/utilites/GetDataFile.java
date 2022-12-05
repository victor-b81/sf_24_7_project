/**
 * Утилитарный класс GetDataFile, с заблокированной возможностью создавать экземпляры.
 * Методы класса:
 * Публичный getStudent(String path)            Возвращает коллекцию студентов из файла xls, путь к которому передан
 *                                              в переменной path
 * Публичный getUniver(String path)             Возвращает коллекцию университетов из файла xls, путь к которому передан
 *                                              в переменной path
 */
package org.sf247.utilites;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sf247.enumenators.StudyProfile;
import org.sf247.modelclass.Student;
import org.sf247.modelclass.University;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetDataFile {
    static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static Iterator<Row> rowIterator;
    private static Row row;
    private static FileInputStream fis;
    private static final Logger log = LogManager.getLogger(GetDataFile.class);

    private GetDataFile() { }           // согласно заданию блокиную создание экземпляров.

    /**
     * Публичный метод getStudent
     * Принимает адрес файла-справочника в переменной path и возвращает коллекцию students
     */
    public static List<Student> getStudent(String path) {
        try {
            fis = new FileInputStream(path);
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
            log.info("Список студентов извелечен из файла");
            return students;
        } catch (FileNotFoundException e) {
            log.error("Фаил " + path + " необнаружен");
            throw new RuntimeException();
        } catch (Exception e) {
            log.error("Неизестная ошибка");
            throw new RuntimeException();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("Немогу закрыть фаил, т.к. он не открыт");
            }
        }
    }

    /**
     * Публичный метод getUniver
     * Принимает адрес файла-справочника в переменной path и возвращает коллекцию universities
     */
    public static List<University> getUniver(String path) {
        try{
            fis = new FileInputStream(path);
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
            log.info("Список университетов извелечен из файла");
            return universities;
        } catch (FileNotFoundException e) {
            log.error("Фаил " + path + " необнаружен");
            throw new RuntimeException();
        } catch (Exception e) {
            log.error("Неизестная ошибка");
            throw new RuntimeException();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("Немогу закрыть фаил, т.к. он не открыт");
            }
        }
    }
}

