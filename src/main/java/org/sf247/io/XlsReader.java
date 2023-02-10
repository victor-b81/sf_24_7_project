/**
 * ����������� ����� GetDataFile, � ��������������� ������������ ��������� ����������.
 * ������ ������:
 * ��������� getStudent(String path)            ���������� ��������� ��������� �� ����� xls, ���� � �������� �������
 *                                              � ���������� path
 * ��������� getUniver(String path)             ���������� ��������� ������������� �� ����� xls, ���� � �������� �������
 *                                              � ���������� path
 */
package org.sf247.io;

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
import java.util.logging.Level;
import java.util.logging.Logger;

public class XlsReader {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static Iterator<Row> rowIterator;
    private static Row row;
    private static FileInputStream fis;
    private static final Logger log = Logger.getLogger(XlsReader.class.getName()); // ����������� �����������

    private XlsReader() { }           // �������� ������� �������� �������� �����������.
    /**
     * ��������� ����� getStudent
     * ��������� ����� �����-����������� � ���������� path � ���������� ��������� students
     */
    public static List<Student> getStudent(String path) {
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("��������");
            rowIterator = sheet.iterator();
            List<Student> students = new ArrayList<>();

            rowIterator.next();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                students.add(new Student(row.getCell(1).getStringCellValue(), row.getCell(0).getStringCellValue(),
                        (int) row.getCell(2).getNumericCellValue(), row.getCell(3).getNumericCellValue()));
            }
            log.log(Level.INFO,"������ ��������� ��������� �� ����� � ������� � ���������� ������");
            return students;
        } catch (FileNotFoundException e) {
            log.log(Level.SEVERE, "���� " + path + " �����������");
            throw new RuntimeException();
        } catch (Exception e) {
            log.log(Level.SEVERE, "������" + e.getMessage());
            throw new RuntimeException();
        } finally {
            try {
                log.log(Level.INFO,"�������� ���� " + path);
                fis.close();
            } catch (IOException e) {
                log.log(Level.WARNING, "������ ������� ����, �������� �� ����� ���� �� ������");
            }
        }
    }

    /**
     * ��������� ����� getUniver
     * ��������� ����� �����-����������� � ���������� path � ���������� ��������� universities
     */
    public static List<University> getUniver(String path) {
        try{
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);

            sheet = workbook.getSheet("������������");
            rowIterator = sheet.iterator();
            List<University> universities = new ArrayList<>();

            rowIterator.next();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                universities.add(new University(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(), (int) row.getCell(3).getNumericCellValue(), StudyProfile.valueOf(row.getCell(4).getStringCellValue())));
            }
            log.log(Level.INFO,"������ ������������� ��������� �� ����� � ������� � ���������� �����");
            return universities;
        } catch (FileNotFoundException e) {
            log.log(Level.SEVERE, "���� " + path + " �����������");
            throw new RuntimeException();
        } catch (Exception e) {
            log.log(Level.SEVERE, "������" + e.getMessage());
            throw new RuntimeException();
        } finally {
            try {
                log.log(Level.INFO,"�������� ���� " + path);
                fis.close();
            } catch (IOException e) {
                log.log(Level.WARNING, "������ ������� ����, �������� �� ����� ���� �� ������");
            }
        }
    }
}

