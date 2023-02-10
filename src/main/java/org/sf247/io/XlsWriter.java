/** Класс XlsWriter
 * Служит для принятия коллекции Statistics и сохранения ее в фаил
 */

package org.sf247.io;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import org.sf247.modelclass.Statistics;

import java.awt.*;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;

public class XlsWriter {

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(XlsWriter.class.getName()); // подключение логирования

    /** Метод writeToFile
     * Сохранение в фаил
     * Получает обьекты statisticsCollection и path
     * и сохраняет в фаил path
     */
    public static void writeToXLSfile(List<Statistics> statisticsCollection, String path){
        /* Блок переменных
         * */
        int rowCount = 1;
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        XSSFRow headRow, dataRow;
        XSSFCell headCellMainProfile,
                headCellAvgExamScore,
                headCellMainProfileStudentCount,
                headCellMainProfileUniverCount,
                headCellFullUniverName,
                dataCellMainProfile;
        XSSFCellStyle headStyle;
        XSSFFont headFont;
        FileOutputStream fos;

        /* Тело программы
         * */
        log.log(Level.INFO,"Коллекция statisticsCollection получена успешно");
        log.log(Level.INFO,"Фомирую шапку таблици");

        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Статистика");
        sheet.setTabColor(new XSSFColor(Color.ORANGE, new DefaultIndexedColorMap()));

        headStyle = workbook.createCellStyle();
        headStyle.setBorderLeft(BorderStyle.MEDIUM);
        headStyle.setBorderBottom(BorderStyle.MEDIUM);
        headStyle.setBorderRight(BorderStyle.MEDIUM);
        headStyle.setBorderTop(BorderStyle.MEDIUM);
        headStyle.setFillForegroundColor(IndexedColors.GOLD.getIndex());
        headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        headFont = workbook.createFont();
        headFont.setFontHeightInPoints((short) 12);
        headFont.setFontName("Arial");
        headFont.setBold(true);
        headStyle.setFont(headFont);

        headRow = sheet.createRow(0);

        headCellMainProfile = headRow.createCell(0);
        headCellMainProfile.setCellValue("Профиль обучения");
        headCellMainProfile.setCellStyle(headStyle);

        headCellAvgExamScore = headRow.createCell(1);
        headCellAvgExamScore.setCellValue("Средний бал");
        headCellAvgExamScore.setCellStyle(headStyle);

        headCellMainProfileStudentCount = headRow.createCell(2);
        headCellMainProfileStudentCount.setCellValue("Кол-во студентов по профилю");
        headCellMainProfileStudentCount.setCellStyle(headStyle);

        headCellMainProfileUniverCount = headRow.createCell(3);
        headCellMainProfileUniverCount.setCellValue("Кол-во университетов по профилю");
        headCellMainProfileUniverCount.setCellStyle(headStyle);

        headCellFullUniverName = headRow.createCell(4);
        headCellFullUniverName.setCellValue("Полное название университетов");
        headCellFullUniverName.setCellStyle(headStyle);

        log.log(Level.INFO,"Фомирую вывод статистики");
        for (Statistics str : statisticsCollection){
            dataRow = sheet.createRow(rowCount);
            dataCellMainProfile = dataRow.createCell(0);
            dataCellMainProfile.setCellValue(str.getMainProfile());
            dataCellMainProfile = dataRow.createCell(1);
            dataCellMainProfile.setCellValue(str.getAvgExamScore());
            dataCellMainProfile = dataRow.createCell(2);
            dataCellMainProfile.setCellValue(str.getMainProfileStudentCount());
            dataCellMainProfile = dataRow.createCell(3);
            dataCellMainProfile.setCellValue(str.getMainProfileUniverCount());
            dataCellMainProfile = dataRow.createCell(4);
            dataCellMainProfile.setCellValue(str.getFullUniverName());
            rowCount++;
        }

        for (int i=0; i<5; i++) {sheet.autoSizeColumn(i);}
        log.log(Level.INFO,"Вывод в фаил подготовлен");

        try {
            fos = new FileOutputStream(path);
            workbook.write(fos);
            fos.close();
            log.log(Level.INFO,"Данные сохранены в фаил успешно");
        } catch (Exception e) {
            log.log(Level.SEVERE,"Ошибка сохранения в фаил");
            throw new RuntimeException("failure", e);
        }
    }
}
