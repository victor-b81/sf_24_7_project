/**
 * Утилитарный класс
 * Реализует сериализацию и десериализацию отдельных обьектов и колекций в Json и обратно
 * Реализация по средствам Google Gson
 */
package org.sf247.utilites;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.sf247.modelclass.Student;
import org.sf247.modelclass.University;

import java.util.List;

public class JsonUtil {

    private JsonUtil(){}            // согласно заданию блокиную создание экземпляров.

    /**
     * Методы сериализации обьектов и колекций в Json
     *
     * serializeStudentJson                 сериализация обьекта student в Json
     * serializeUniversityJson              сериализация обьекта University в Json
     * serializeStudentCollectionJson       сериализация колекции students в Json
     * serializeUniversityCollectionJson    сериализация колекции universities в Json
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
     * Методы Десериализации Json в обьекты и колекции
     *
     * deserializeStudentJson                 сериализация обьекта student в Json
     * deserializeUniversityJson              сериализация обьекта University в Json
     * deserializeStudentCollectionJson       сериализация колекции students в Json
     * deserializeUniversityCollectionJson    сериализация колекции universities в Json
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
