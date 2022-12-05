/**
 * SkillFactory: JAVA-2.0.
 * Backend-���������� �� Java.
 * ������� ������ ������ �� ���������� ����� �����.
 */

package org.sf247;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sf247.compare.CompareStudents;
import org.sf247.compare.CompareUniversity;
import org.sf247.enumenators.EnumStudent;
import org.sf247.enumenators.EnumUniversity;
import org.sf247.modelclass.Student;
import org.sf247.modelclass.University;
import org.sf247.utilites.GetComparator;
import org.sf247.utilites.GetDataFile;
import org.sf247.utilites.JsonUtil;

import java.util.List;

public class Main{
    private static final Logger log = LogManager.getLogger(GetDataFile.class);
    public static void main(String[] args){
        String filePath = "src\\main\\resources\\universityInfo.xlsx";

        /*
          ���������, ���������� � ����� ��������� �� �����-�����������
         */
        List<Student> students = GetDataFile.getStudent(filePath);
        CompareStudents compareStudents = GetComparator.getCompareStudents(EnumStudent.FULL_NAME);
        students.stream().sorted(compareStudents).forEach(System.out::println);
        log.info("������ ��������� ������������, ������� � ������� � ������� � �������� students");

        List<University> universities = GetDataFile.getUniver(filePath);
        CompareUniversity compareUniversity = GetComparator.getCompareUniversity(EnumUniversity.FULL_NAME);
        universities.stream().sorted(compareUniversity).forEach(System.out::println);
        log.info("������ ������������� ������������, ������� � ������� � ������� � �������� universities");

        /*
          ��������������/������������ ��������� � Json, �� ��������� ������� ������������ ������ JsonUtil.
          � ����� � �������
         */
        String getStudentCollectionJson = JsonUtil.serializeStudentCollectionJson(students);
        String getUniversityCollectionJson = JsonUtil.serializeUniversityCollectionJson(universities);

        System.out.println(getStudentCollectionJson);
        System.out.println(getUniversityCollectionJson);
        log.info("������ ������������� � ��������� ������������ � Json � ������� � �������");

        /*
          ��������������/�������������� Json � ���������, �� ��������� ������� ������������ ������ JsonUtil.
          � ��������� ���������� ��������� � �������� � ����� ����������
         */
        List<Student> newStudents = JsonUtil.deserializeStudentCollectionJson(getStudentCollectionJson);
        List<University> newUniversities = JsonUtil.deserializeUniversityCollectionJson(getUniversityCollectionJson);
        log.info("Json ������� ������������� � ��������� ������������� � ��������� � ���������� � ����� ���������");

        if ((students.size() == newStudents.size())) {
            System.out.println("�������� � ����� ��������� Students ����� ���������� ���������� �������");
            log.info("�������� � ����� ��������� Students ����� ���������� ���������� �������");
        } else {
            System.out.println("�������� � ����� ��������� Students ����� ������ ���������� �������");
            log.error("�������� � ����� ��������� Students ����� ������ ���������� �������");
        }

        if ((universities.size() == newUniversities.size())) {
            System.out.println("�������� � ����� ��������� Universities ����� ���������� ���������� �������");
            log.info("�������� � ����� ��������� Universities ����� ���������� ���������� �������");
        } else {
            System.out.println("�������� � ����� ��������� Universities ����� ������ ���������� �������");
            log.error("�������� � ����� ��������� Universities ����� ������ ���������� �������");
        }

        /*
          ��������������/������������ � �������������� �������� � Json � ������� � �������,
          �� ��������� ������� ������������ ������ JsonUtil.
          � ����� � �������
         */
        students.forEach(student -> {
            String getStudentJson = JsonUtil.serializeStudentJson(student);
            System.out.println(getStudentJson);
            Student newStudent = JsonUtil.deserializeStudentJson(getStudentJson);
            System.out.println(newStudent);
        });
        log.info("��������������/������������ � �������������� �������� students � Json � ������� � ������� ������ ���������");

        universities.forEach(university -> {
            String getUniversityJson = JsonUtil.serializeUniversityJson(university);
            System.out.println(getUniversityJson);
            University newUniversity = JsonUtil.deserializeUniversityJson(getUniversityJson);
            System.out.println(newUniversity);
        });
        log.info("��������������/������������ � �������������� �������� universities � Json � ������� � ������� ������ ���������");
    }
}