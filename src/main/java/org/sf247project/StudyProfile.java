package org.sf247project;

public enum StudyProfile {
    MEDICINE ("��������"),
    IT ("��"),
    MECHANICS ("��������"),
    MANAGEMENT ("����������");

    String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;     // ������� ��������� �������� �������
    }

    @Override
    public String toString() {
        return profileName;
    }
}