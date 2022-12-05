/**
 * ����������� �����
 * ��������� ������������ � �������������� ��������� �������� � �������� � Json � �������
 * ���������� �� ��������� Google Gson
 */
package org.sf247.utilites;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.sf247.modelclass.Student;
import org.sf247.modelclass.University;

import java.util.List;

public class JsonUtil {

    private JsonUtil(){}            // �������� ������� �������� �������� �����������.

    /**
     * ������ ������������ �������� � �������� � Json
     *
     * serializeStudentJson                 ������������ ������� student � Json
     * serializeUniversityJson              ������������ ������� University � Json
     * serializeStudentCollectionJson       ������������ �������� students � Json
     * serializeUniversityCollectionJson    ������������ �������� universities � Json
     */

    public static String serializeStudentJson (Student student){
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    public static String serializeUniversityJson (University university){
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static String serializeStudentCollectionJson (List<Student> students){
        return new GsonBuilder().setPrettyPrinting().create().toJson(students);
    }

    public static String serializeUniversityCollectionJson (List<University> universities){
        return new GsonBuilder().setPrettyPrinting().create().toJson(universities);
    }

    /**
     * ������ �������������� Json � ������� � ��������
     *
     * deserializeStudentJson                 ������������ ������� student � Json
     * deserializeUniversityJson              ������������ ������� University � Json
     * deserializeStudentCollectionJson       ������������ �������� students � Json
     * deserializeUniversityCollectionJson    ������������ �������� universities � Json
     */

    public static Student deserializeStudentJson (String jsonStudent){
        return new GsonBuilder().create().fromJson(jsonStudent, Student.class);
    }

    public static University deserializeUniversityJson (String jsonUniversity){
        return new GsonBuilder().create().fromJson(jsonUniversity, University.class);
    }

    public static List<Student> deserializeStudentCollectionJson (String jsonStudents){
        return new Gson().fromJson(jsonStudents, new TypeToken<List<Student>>(){}.getType());
    }

    public static List<University> deserializeUniversityCollectionJson (String jsonUniversities){
        return new Gson().fromJson(jsonUniversities, new TypeToken<List<University>>(){}.getType());
    }

}
