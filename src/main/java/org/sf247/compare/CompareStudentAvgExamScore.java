/**
 * Класс CompareStudentAvgExamScore зависящий от интерфейса CompareStudents
 * с переопределенным методом compare.
 * Служит для сортировки по среднему баллу экзаменов
 */
package org.sf247.compare;

import org.sf247.modelclass.Student;

public class CompareStudentAvgExamScore implements CompareStudents{
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o2.getAvgExamScore(), o1.getAvgExamScore());
    }
}
