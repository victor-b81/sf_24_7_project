/**
 * Интерфейс CompareStudents наследник от класса Comparator
 * Служит для имплементации класса Comparator в другие классы
 */

package org.sf247.compare;

import org.sf247.modelclass.Student;

import java.util.Comparator;

public interface CompareStudents extends Comparator<Student> {
}
