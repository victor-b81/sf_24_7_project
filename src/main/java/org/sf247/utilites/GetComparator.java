/**
 * Класс GetComparator для сортировки обьектов в коллекциях.
 * Методы класса:
 * Публичный getCompareStudents                 осуществляет вызов классов Students для сортировки согласно переданным аргументам
 * Публичный getCompareUniversity               осуществляет вызов классов University для сортировки согласно переданным аргументам
 */

package org.sf247.utilites;

import org.sf247.compare.*;
import enumenators.EnumStudent;
import enumenators.EnumUniversity;

public class GetComparator {
    private GetComparator() { }            // согласно заданию блокиную создание экземпляров.

    public static CompareStudents getCompareStudents(EnumStudent enumStudent){
        switch (enumStudent){
            case AVG_SCORE -> {
                return new CompareStudentAvgExamScore();
            }
            case UNIVERSITY_ID -> {
                return new CompareStudentUniversityId();
            }
            case CURRENT_COURSE_NUMBER -> {
                return new CompareStudentCurrentCourseNumber();
            }
            default -> {
                return new CompareStudentFullName();
            }
        }
    }

    public static CompareUniversity getCompareUniversity(EnumUniversity enumUniversity){
        switch (enumUniversity){
            case ID -> {
                return new CompareUniversityID();
            }
            case SHORT_NAME -> {
                return new CompareUniversityShortName();
            }
            case YEAR_FOUNDATION -> {
                return new CompareUniversityYearOfFoundation();
            }
            default -> {
                return new CompareUniversityFullName();
            }
        }
    }
}
