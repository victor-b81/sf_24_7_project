package org.sf247.project;

import org.sf247.compare.CompareStudents;
import org.sf247.compare.CompareUniversity;
import org.sf247.enumenators.EnumStudent;
import org.sf247.enumenators.EnumUniversity;
import org.sf247.modelclass.Student;
import org.sf247.modelclass.University;
import org.sf247.utilites.GetComparator;
import org.sf247.utilites.GetDataFile;

import java.util.List;

public class Main{
    public static void main(String[] args){
        String filePath = "src\\main\\resources\\universityInfo.xlsx";

        List<Student> students = GetDataFile.getStudent(filePath);
        CompareStudents compareStudents = GetComparator.getCompareStudents(EnumStudent.FULL_NAME);
        students.stream().sorted(compareStudents).forEach(System.out::println);

        List<University> universities = GetDataFile.getUniver(filePath);
        CompareUniversity compareUniversity = GetComparator.getCompareUniversity(EnumUniversity.FULL_NAME);
        universities.stream().sorted(compareUniversity).forEach(System.out::println);
    }
}