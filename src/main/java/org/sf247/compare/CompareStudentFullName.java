/**
 * Класс CompareStudentFullName зависящий от интерфейса CompareStudents
 * с переопределенным методом compare.
 * Служит для сортировки по имени студента
 */

package org.sf247.compare;

import org.apache.commons.lang3.StringUtils;
import org.sf247.modelclass.Student;

public class CompareStudentFullName implements CompareStudents {
    @Override
    public int compare(Student o1, Student o2){
        return StringUtils.compare(o1.getFullName(), o2.getFullName());
    }
}
