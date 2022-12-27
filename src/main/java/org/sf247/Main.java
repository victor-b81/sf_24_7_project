/**
 * SkillFactory: JAVA-2.0.
 * Backend-разработка на Java.
 * Решение задачи идущей на протяжении всего курса.
 */

package org.sf247;

import org.sf247.modelclass.Statistics;
import org.sf247.modelclass.Student;
import org.sf247.modelclass.University;
import org.sf247.utilites.GetDataFile;
import org.sf247.utilites.GetStatistics;
import org.sf247.utilites.XlsWriter;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main{
    private static final Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args){

        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e);
        }

        String inputFilePath = "src\\main\\resources\\universityInfo.xlsx";
        String outputFilePath = "src\\main\\resources\\statistics.xlsx";
        /*
          Получение, сортировка и вывод коллекций из файла-справочника
         */
        log.log(Level.INFO,"Получаем коллекции students и universities из файла " + inputFilePath);
        List<Student> students = GetDataFile.getStudent(inputFilePath);
        List<University> universities = GetDataFile.getUniver(inputFilePath);
        log.log(Level.INFO,"Коллекции students и universities успешно получены из файла " + inputFilePath);
        /*
         Получение статистики из колекций и сохранение в фаил
         */
        log.log(Level.INFO,"Получаем коллекцию общую statisticsCollection из коллекций students и universities");
        List<Statistics> statisticsCollection = GetStatistics.collectStatistics(students, universities);
        log.log(Level.INFO,"Коллекция statisticsCollection успешно получена из коллекций students и universities");
        log.log(Level.INFO,"Коллекция statisticsCollection передана в класс XlsWriter для записи в файл" + outputFilePath);
        XlsWriter.writeToFile(statisticsCollection, outputFilePath);

    }
}