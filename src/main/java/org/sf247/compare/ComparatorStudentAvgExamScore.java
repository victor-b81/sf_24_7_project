package org.sf247.compare;

import org.sf247.modelclass.Student;

public class ComparatorStudentAvgExamScore implements CompareStudents{
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o2.getAvgExamScore(), o1.getAvgExamScore());
    }
}
