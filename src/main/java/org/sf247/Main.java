/**
 * SkillFactory: JAVA-2.0.
 * Backend-разработка на Java.
 * Решение задачи идущей на протяжении всего курса.
 */

package org.sf247;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sf247.modelclass.Statistics;
import org.sf247.modelclass.Student;
import org.sf247.modelclass.University;
import org.sf247.utilites.GetDataFile;
import org.sf247.utilites.GetStatistics;
import org.sf247.utilites.XlsWriter;

import java.util.List;

public class Main{
    private static final Logger log = LogManager.getLogger(GetDataFile.class);
    public static void main(String[] args){
        String inputFilePath = "src\\main\\resources\\universityInfo.xlsx";
        String outputFilePath = "src\\main\\resources\\statistics.xlsx";
        /*
          Получение, сортировка и вывод коллекций из файла-справочника
         */
        List<Student> students = GetDataFile.getStudent(inputFilePath);
        List<University> universities = GetDataFile.getUniver(inputFilePath);

        /*
         Получение статистики из колекций, и сохранение в фаил
         */
        List<Statistics> statisticsCollection = GetStatistics.collectStatistics(students, universities);
        XlsWriter.writeToFile(statisticsCollection, outputFilePath);

    }
}