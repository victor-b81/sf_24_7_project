/**
 * ����� CompareStudentAvgExamScore ��������� �� ���������� CompareStudents
 * � ���������������� ������� compare.
 * ������ ��� ���������� �� �������� ����� ���������
 */
package org.sf247.compare;

import org.sf247.modelclass.Student;

public class CompareStudentAvgExamScore implements CompareStudents{
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o2.getAvgExamScore(), o1.getAvgExamScore());
    }
}
