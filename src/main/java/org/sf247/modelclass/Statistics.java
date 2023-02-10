/**
 * ��������� ����� Statistics
 */

package org.sf247.modelclass;

import com.google.gson.annotations.SerializedName;

public class Statistics {
    @SerializedName(value = "������� ��������", alternate = "������� �������� ������������")
    private String mainProfile;
    @SerializedName(value = "������� ���", alternate = "������� ��� �� ���������")
    private String avgExamScore;
    @SerializedName(value = "���-�� ��������� �� �������", alternate = "���-�� ��������� �� ������� ��������")
    private String mainProfileStudentCount;
    @SerializedName(value = "���-�� ������������� �� �������", alternate = "���-�� ������������� �� ������� ��������")
    private String mainProfileUniverCount;
    @SerializedName(value = "������ �������� �������������", alternate = "�������� ������������")
    private String fullUniverName;

    /**
     * ������ ����� Getter & Setter
     */

    public String getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(String avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public String getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(String mainProfile) {
        this.mainProfile = mainProfile;
    }

    public String getMainProfileStudentCount() {
        return mainProfileStudentCount;
    }

    public void setMainProfileStudentCount(String mainProfileStudentCount) {
        this.mainProfileStudentCount = mainProfileStudentCount;
    }

    public String getMainProfileUniverCount() {
        return mainProfileUniverCount;
    }

    public void setMainProfileUniverCount(String mainProfileUniverCount) {
        this.mainProfileUniverCount = mainProfileUniverCount;
    }

    public String getFullUniverName() {
        return fullUniverName;
    }

    public void setFullUniverName(String fullUniverName) {
        this.fullUniverName = fullUniverName;
    }

    /**
     * ����� ����� Getter & Setter
     */

    public Statistics(String mainProfile, String avgExamScore, String mainProfileStudentCount, String mainProfileUniverCount, String fullUniverName) {
        this.avgExamScore = avgExamScore;
        this.mainProfile = mainProfile;
        this.mainProfileStudentCount = mainProfileStudentCount;
        this.mainProfileUniverCount = mainProfileUniverCount;
        this.fullUniverName = fullUniverName;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "avgExamScore=" + avgExamScore +
                ", mainProfile=" + mainProfile +
                ", mainProfileStudentCount=" + mainProfileStudentCount +
                ", mainProfileUniverCount=" + mainProfileUniverCount +
                ", fullUniverName='" + fullUniverName + '\'' +
                '}';
    }
}
