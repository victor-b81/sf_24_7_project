/**
 * SkillFactory: JAVA-2.0.
 * Backend-разработка на Java.
 * Решение задачи идущей на протяжении всего курса.
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
          Получение, сортировка и вывод коллекций из файла-справочника
         */
        List<Student> students = GetDataFile.getStudent(filePath);
        CompareStudents compareStudents = GetComparator.getCompareStudents(EnumStudent.FULL_NAME);
        students.stream().sorted(compareStudents).forEach(System.out::println);
        log.info("Список студентов отсортирован, выведен в консоль и передан в колекцию students");

        List<University> universities = GetDataFile.getUniver(filePath);
        CompareUniversity compareUniversity = GetComparator.getCompareUniversity(EnumUniversity.FULL_NAME);
        universities.stream().sorted(compareUniversity).forEach(System.out::println);
        log.info("Список университетов отсортирован, выведен в консоль и передан в колекцию universities");

        /*
          Преобразование/сереализация коллекций в Json, по средствам методов утилитарного класса JsonUtil.
          И вывод в консоль
         */
        String getStudentCollectionJson = JsonUtil.serializeStudentCollectionJson(students);
        String getUniversityCollectionJson = JsonUtil.serializeUniversityCollectionJson(universities);

        System.out.println(getStudentCollectionJson);
        System.out.println(getUniversityCollectionJson);
        log.info("Список университетов и студентов преобразован в Json и выведен в консоль");

        /*
          Преобразование/десереализация Json в коллекции, по средствам методов утилитарного класса JsonUtil.
          И сравнение количества элементов в исходных и новых коллекциях
         */
        List<Student> newStudents = JsonUtil.deserializeStudentCollectionJson(getStudentCollectionJson);
        List<University> newUniversities = JsonUtil.deserializeUniversityCollectionJson(getUniversityCollectionJson);
        log.info("Json объекты университетов и студентов преобразованы в коллекции и выгруженны в новые коллекции");

        if ((students.size() == newStudents.size())) {
            System.out.println("Исходная и новая коллекции Students имеют одинаковое количество элентов");
            log.info("Исходная и новая коллекции Students имеют одинаковое количество элентов");
        } else {
            System.out.println("Исходная и новая коллекции Students имеют разное количество элентов");
            log.error("Исходная и новая коллекции Students имеют разное количество элентов");
        }

        if ((universities.size() == newUniversities.size())) {
            System.out.println("Исходная и новая коллекции Universities имеют одинаковое количество элентов");
            log.info("Исходная и новая коллекции Universities имеют одинаковое количество элентов");
        } else {
            System.out.println("Исходная и новая коллекции Universities имеют разное количество элентов");
            log.error("Исходная и новая коллекции Universities имеют разное количество элентов");
        }

        /*
          Преобразование/сереализация и десереализация объектов в Json и обратно в объекты,
          по средствам методов утилитарного класса JsonUtil.
          И вывод в консоль
         */
        students.forEach(student -> {
            String getStudentJson = JsonUtil.serializeStudentJson(student);
            System.out.println(getStudentJson);
            Student newStudent = JsonUtil.deserializeStudentJson(getStudentJson);
            System.out.println(newStudent);
        });
        log.info("Преобразование/сереализация и десереализация объектов students в Json и обратно в объекты прошло корректно");

        universities.forEach(university -> {
            String getUniversityJson = JsonUtil.serializeUniversityJson(university);
            System.out.println(getUniversityJson);
            University newUniversity = JsonUtil.deserializeUniversityJson(getUniversityJson);
            System.out.println(newUniversity);
        });
        log.info("Преобразование/сереализация и десереализация объектов universities в Json и обратно в объекты прошло корректно");
    }
}