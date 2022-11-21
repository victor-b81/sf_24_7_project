package org.sf247project;

public enum StudyProfile {
    MEDICINE ("Медицина"),
    IT ("ИТ"),
    MECHANICS ("Механика"),
    MANAGEMENT ("Управление");

    String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;     // Передаю строковое значение профиля
    }

    @Override
    public String toString() {
        return profileName;
    }
}
