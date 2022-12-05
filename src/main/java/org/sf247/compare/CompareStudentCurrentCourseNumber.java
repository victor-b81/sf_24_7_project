/**
 * Класс CompareStudentCurrentCourseNumber зависящий от интерфейса CompareStudents
 * с переопределенным методом compare.
 * Служит для сортировки по текущему номеру курса
 */

package org.sf247.compare;

import org.sf247.modelclass.Student;

public class CompareStudentCurrentCourseNumber implements CompareStudents{
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
    }
}
