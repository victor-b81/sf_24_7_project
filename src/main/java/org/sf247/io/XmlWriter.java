/** ����� XmlWriter
 * ������ ��� �������� ������� FullInfo � ���������� ��� � ����� xml
 */

package org.sf247.io;

import org.sf247.modelclass.FullInfo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriter {

    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());

    private XmlWriter() {}

    /**
     * writeXmlFile - �������� ����� ������ ���������� � ����� xml
     * �������� ������ FullInfo � ��������� ���������� � ���� xml
     */
    public static void writeXmlFile(FullInfo fullInfo, String path) {
        /* ���������� ���������� ���������� ��� ����� � ����� �������� � ���� ��� ����������.
         * */
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy-HH_mm_ss");
        String outXmlFilePath = path + "FullInfo-" + dateFormat.format(calendar.getTime()) + ".xml";

        /* �������� ���� ���������
         * */
        try {
            logger.log(Level.INFO, "�������� ������� � ������� ��������� ��� ������ FullInfo");
            JAXBContext jaxbContext = JAXBContext.newInstance(FullInfo.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            logger.log(Level.INFO, "������������� ������ ������ XML");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            /* �������� ���������� xmlReqs
             * */
            try {
                logger.log(Level.INFO, "������ ������� ���������� xmlReqs");
                Files.createDirectory(Paths.get(path));
                logger.log(Level.INFO, "���������� xmlReqs ������� �������");
            } catch (IOException e) {
                logger.log(Level.FINE, "���������� xmlReqs ��� ����������", e);
            }

            /* ���������� ���������� � ����
             * */
            File outXmlFile = new File(outXmlFilePath);
            marshaller.marshal(fullInfo, outXmlFile);
        } catch (JAXBException e) {
            logger.log(Level.SEVERE, "������ �������� ����������!", e);
            e.printStackTrace();
            return;
        }

        logger.log(Level.INFO, "������� ������ ����� XML �������");
    }
}
