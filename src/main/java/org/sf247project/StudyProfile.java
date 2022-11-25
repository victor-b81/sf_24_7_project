package org.sf247project;

public enum StudyProfile {
    MEDICINE ("Медицина"),
    IT ("ИТ"),
    MECHANICS ("Механика"),
    MANAGEMENT ("Управление"),
    LINGUISTICS ("Лингвистика"),
    MATHEMATICS ("Математика"),
    PHYSICS ("Физика");

    String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;     // Передаю строковое значение профиля
    }

    @Override
    public String toString() {
        return profileName;
    }
}
