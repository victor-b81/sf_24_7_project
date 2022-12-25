/**
 * Модельный класс University
 */

package org.sf247.modelclass;

import com.google.gson.annotations.SerializedName;
import org.sf247.enumenators.StudyProfile;

public class University {
    @SerializedName(value = "ИД Университета", alternate = "Идентификатор Университета")
    private String universityID;
    @SerializedName(value = "Полное название", alternate = "Название университета")
    private String fullName;
    @SerializedName(value = "Сокращенное название", alternate = "Сокращенное название Университета / Абревиатура")
    private String shortName;
    @SerializedName(value = "Год основания", alternate = "Год основания Университета")
    private int yearOfFoundation;
    @SerializedName(value = "Профиль", alternate = "Профиль Университета")
    private StudyProfile mainProfile;

    public University(String universityID, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.universityID = universityID;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + universityID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }

    public String getUniversityID() {
        return universityID;
    }

    public void setUniversityID(String universityID) {
        this.universityID = universityID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }
}
