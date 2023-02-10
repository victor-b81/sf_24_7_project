/** Класс XmlWriter
 * Служит для принятия объекта FullInfo и сохранения его в файлы xml
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
     * writeXmlFile - Основной метод записи информации в фаилы xml
     * Получает объект FullInfo и сохраняет информацию в файл xml
     */
    public static void writeXmlFile(FullInfo fullInfo, String path) {
        /* Обьявление переменной содержащей имя файла с датой создания и пути его сохранения.
         * */
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy-HH_mm_ss");
        String outXmlFilePath = path + "FullInfo-" + dateFormat.format(calendar.getTime()) + ".xml";

        /* Основное тело программы
         * */
        try {
            logger.log(Level.INFO, "Получаем инстанс и создаем маршаллер для класса FullInfo");
            JAXBContext jaxbContext = JAXBContext.newInstance(FullInfo.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            logger.log(Level.INFO, "Устанавливаем формат вывода XML");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            /* Создание директории xmlReqs
             * */
            try {
                logger.log(Level.INFO, "Пробую создать директорию xmlReqs");
                Files.createDirectory(Paths.get(path));
                logger.log(Level.INFO, "Директория xmlReqs создана успешно");
            } catch (IOException e) {
                logger.log(Level.FINE, "Директория xmlReqs уже существует", e);
            }

            /* Записываем информацию в файл
             * */
            File outXmlFile = new File(outXmlFilePath);
            marshaller.marshal(fullInfo, outXmlFile);
        } catch (JAXBException e) {
            logger.log(Level.SEVERE, "Ошибка создания маршаллера!", e);
            e.printStackTrace();
            return;
        }

        logger.log(Level.INFO, "Процесс записи файла XML окончен");
    }
}
