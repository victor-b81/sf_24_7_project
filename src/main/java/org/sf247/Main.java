/**
 * SkillFactory: JAVA-2.0.
 * Backend-���������� �� Java.
 * ������� ������ ������ �� ���������� ����� �����.
 */

package org.sf247;

import org.sf247.io.JsonWriter;
import org.sf247.io.XlsReader;
import org.sf247.io.XlsWriter;
import org.sf247.io.XmlWriter;
import org.sf247.modelclass.FullInfo;
import org.sf247.modelclass.Statistics;
import org.sf247.modelclass.Student;
import org.sf247.modelclass.University;
import org.sf247.utilites.GetStatistics;

import java.io.IOException;
import java.util.Date;
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
          ���������, ���������� � ����� ��������� �� �����-�����������
         */
        log.log(Level.INFO,"�������� ��������� students � universities �� ����� " + inputFilePath);
        List<Student> students = XlsReader.getStudent(inputFilePath);
        List<University> universities = XlsReader.getUniver(inputFilePath);
        log.log(Level.INFO,"��������� students � universities ������� �������� �� ����� " + inputFilePath);
        /*
         ��������� ���������� �� �������� � ���������� � ����
         */
        log.log(Level.INFO,"�������� ��������� ����� statisticsCollection �� ��������� students � universities");
        List<Statistics> statisticsCollection = GetStatistics.collectStatistics(students, universities);
        log.log(Level.INFO,"��������� statisticsCollection ������� �������� �� ��������� students � universities");
        log.log(Level.INFO,"��������� statisticsCollection �������� � ����� XlsWriter ��� ������ � ����" + outputFilePath);
        XlsWriter.writeToXLSfile(statisticsCollection, outputFilePath);
        /*
         ������� �������� ������� ������
         */
        FullInfo fullInfo = new FullInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsCollection)
                .setProcessDate(new Date());
        /*
         ���������� ���������� � ����� .json � .xml
         */
        XmlWriter.writeXmlFile(fullInfo, "src\\main\\xmlReqs\\");
        JsonWriter.writeJsonFile(fullInfo, "src\\main\\jsonReqs\\");

    }
}