/** ����� JsonWriter
 * ������ ��� �������� ������� FullInfo � ���������� ��� � ����� json
 */

package org.sf247.io;

import org.sf247.modelclass.FullInfo;
import org.sf247.utilites.JsonUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {

    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    private JsonWriter() { }

    /**
     * writeJsonFile - �������� ����� ������ ����������������� ���������� � ����� JSON
     * �������� ������ FullInfo � ��������� ���������� � �����
     */
    public static void writeJsonFile(FullInfo fullInfo, String path) {
        /* ���������� ���������� ���������� ����� ������ � ����� �������� � ���� �� ����������.
         * */
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy-HH_mm_ss");
        String studentsPath = path + "students-" + dateFormat.format(calendar.getTime()) + ".json";
        String universitiesPath = path + "universities-" + dateFormat.format(calendar.getTime()) + ".json";
        String statisticsPath = path + "statistics-" + dateFormat.format(calendar.getTime()) + ".json";

       /* �������� ���������� jsonReqs
        * */
        try {
            logger.log(Level.INFO, "������ ������� ���������� jsonReqs");
            Files.createDirectory(Paths.get(path));
            logger.log(Level.INFO, "���������� jsonReqs ������� �������");
        } catch (IOException e) {
            logger.log(Level.FINE, "���������� jsonReqs ��� ����������", e);
        }

        /* ���������� ���������� � �����
         * */
        writeStudentsToJsonFile(fullInfo, studentsPath);
        writeUniversitiesToJsonFile(fullInfo, universitiesPath);
        writeStatisticsToJsonFile(fullInfo, statisticsPath);

        logger.log(Level.INFO, "������� ������ ������ JSON �������");
    }

    /**
     * writeStudentsToJsonFile - ����� ������ ����������������� ���������� students � ����
     */
    private static void writeStudentsToJsonFile(FullInfo fullInfo, String path) {
        String studentsJson = JsonUtil.serializeListToJson(fullInfo.getStudentList());
        try {
            logger.log(Level.INFO, "��������� JSON ���� students");
            FileOutputStream outputStream = new FileOutputStream(path);
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "������ ������ JSON ����� students", e);
        }
    }

    /**
     * writeUniversitiesToJsonFile - ����� ������ ����������������� ���������� universities � ����
     */
    private static void writeUniversitiesToJsonFile(FullInfo fullInfo, String path) {
        String universitiesJson = JsonUtil.serializeListToJson(fullInfo.getUniversityList());
        try {
            logger.log(Level.INFO, "��������� JSON ���� universities");
            FileOutputStream outputStream = new FileOutputStream(path);
            outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "������ ������ JSON ����� universities", e);
        }
    }

    /**
     * writeStatisticsToJsonFile - ����� ������ ����������������� ���������� statistics � ����
     */
    private static void writeStatisticsToJsonFile(FullInfo fullInfo, String path) {
        String studentsJson = JsonUtil.serializeListToJson(fullInfo.getStatisticsList());
        try {
            logger.log(Level.INFO, "��������� JSON ���� statistics");
            FileOutputStream outputStream = new FileOutputStream(path);
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "������ ������ JSON ����� statistics", e);
        }
    }
}