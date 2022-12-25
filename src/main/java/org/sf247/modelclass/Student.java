/**
 * ��������� ����� Student
 */

package org.sf247.modelclass;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName(value = "���", alternate = "������� ��� ��������")
    private String fullName;
    @SerializedName(value = "�� ������������", alternate = "������������� ������������")
    private String universityId;
    @SerializedName(value = "������� ����", alternate = "����� �������� �����")
    private int currentCourseNumber;
    @SerializedName(value = "������� ���", alternate = "������� ��� �� ���������")
    private Double avgExamScore;

    public Student(String fullName, String universityId, int currentCourseNumber, Double avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public Double getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(Double avgExamScore) {
        this.avgExamScore = avgExamScore;
    }
}
