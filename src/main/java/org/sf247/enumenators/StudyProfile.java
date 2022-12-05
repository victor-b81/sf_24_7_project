/**
 * Энуменатор StudyProfile
 * Перечисление полей профиля
 */

package org.sf247.enumenators;

public enum StudyProfile {
    MEDICINE ("Медицина"),
    IT ("ИТ"),
    MECHANICS ("Механика"),
    MANAGEMENT ("Управление"),
    LINGUISTICS ("Лингвистика"),
    MATHEMATICS ("Математика"),
    PHYSICS ("Физика");

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;     // Передаю строковое значение профиля
    }

    @Override
    public String toString() {
        return profileName;
    }
}
