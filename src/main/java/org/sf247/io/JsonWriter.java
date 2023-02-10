/** Класс JsonWriter
 * Служит для принятия объекта FullInfo и сохранения его в файлы json
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
     * writeJsonFile - Основной метод записи сереализированной информации в фаилы JSON
     * Получает объект FullInfo и сохраняет информацию в файлы
     */
    public static void writeJsonFile(FullInfo fullInfo, String path) {
        /* Обьявление переменных содержащих имена файлов с датой создания и пути их сохранения.
         * */
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy-HH_mm_ss");
        String studentsPath = path + "students-" + dateFormat.format(calendar.getTime()) + ".json";
        String universitiesPath = path + "universities-" + dateFormat.format(calendar.getTime()) + ".json";
        String statisticsPath = path + "statistics-" + dateFormat.format(calendar.getTime()) + ".json";

       /* Создание директории jsonReqs
        * */
        try {
            logger.log(Level.INFO, "Пробую создать директорию jsonReqs");
            Files.createDirectory(Paths.get(path));
            logger.log(Level.INFO, "Директория jsonReqs создана успешно");
        } catch (IOException e) {
            logger.log(Level.FINE, "Директория jsonReqs уже существует", e);
        }

        /* Записываем информацию в файлы
         * */
        writeStudentsToJsonFile(fullInfo, studentsPath);
        writeUniversitiesToJsonFile(fullInfo, universitiesPath);
        writeStatisticsToJsonFile(fullInfo, statisticsPath);

        logger.log(Level.INFO, "Процесс записи файлов JSON окончен");
    }

    /**
     * writeStudentsToJsonFile - Метод записи сереализированной информации students в фаил
     */
    private static void writeStudentsToJsonFile(FullInfo fullInfo, String path) {
        String studentsJson = JsonUtil.serializeListToJson(fullInfo.getStudentList());
        try {
            logger.log(Level.INFO, "Записываю JSON файл students");
            FileOutputStream outputStream = new FileOutputStream(path);
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка записи JSON файла students", e);
        }
    }

    /**
     * writeUniversitiesToJsonFile - Метод записи сереализированной информации universities в фаил
     */
    private static void writeUniversitiesToJsonFile(FullInfo fullInfo, String path) {
        String universitiesJson = JsonUtil.serializeListToJson(fullInfo.getUniversityList());
        try {
            logger.log(Level.INFO, "Записываю JSON файл universities");
            FileOutputStream outputStream = new FileOutputStream(path);
            outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка записи JSON файла universities", e);
        }
    }

    /**
     * writeStatisticsToJsonFile - Метод записи сереализированной информации statistics в фаил
     */
    private static void writeStatisticsToJsonFile(FullInfo fullInfo, String path) {
        String studentsJson = JsonUtil.serializeListToJson(fullInfo.getStatisticsList());
        try {
            logger.log(Level.INFO, "Записываю JSON файл statistics");
            FileOutputStream outputStream = new FileOutputStream(path);
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка записи JSON файла statistics", e);
        }
    }
}