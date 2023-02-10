/** ����� XlsWriter
 * ������ ��� �������� ��������� Statistics � ���������� �� � ����
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

    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(XlsWriter.class.getName()); // ����������� �����������

    /** ����� writeToFile
     * ���������� � ����
     * �������� ������� statisticsCollection � path
     * � ��������� � ���� path
     */
    public static void writeToXLSfile(List<Statistics> statisticsCollection, String path){
        /* ���� ����������
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

        /* ���� ���������
         * */
        log.log(Level.INFO,"��������� statisticsCollection �������� �������");
        log.log(Level.INFO,"������� ����� �������");

        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("����������");
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
        headCellMainProfile.setCellValue("������� ��������");
        headCellMainProfile.setCellStyle(headStyle);

        headCellAvgExamScore = headRow.createCell(1);
        headCellAvgExamScore.setCellValue("������� ���");
        headCellAvgExamScore.setCellStyle(headStyle);

        headCellMainProfileStudentCount = headRow.createCell(2);
        headCellMainProfileStudentCount.setCellValue("���-�� ��������� �� �������");
        headCellMainProfileStudentCount.setCellStyle(headStyle);

        headCellMainProfileUniverCount = headRow.createCell(3);
        headCellMainProfileUniverCount.setCellValue("���-�� ������������� �� �������");
        headCellMainProfileUniverCount.setCellStyle(headStyle);

        headCellFullUniverName = headRow.createCell(4);
        headCellFullUniverName.setCellValue("������ �������� �������������");
        headCellFullUniverName.setCellStyle(headStyle);

        log.log(Level.INFO,"������� ����� ����������");
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
        log.log(Level.INFO,"����� � ���� �����������");

        try {
            fos = new FileOutputStream(path);
            workbook.write(fos);
            fos.close();
            log.log(Level.INFO,"������ ��������� � ���� �������");
        } catch (Exception e) {
            log.log(Level.SEVERE,"������ ���������� � ����");
            throw new RuntimeException("failure", e);
        }
    }
}
