/**
 * Класс CompareUniversityID зависящий от интерфейса CompareUniversity
 * с переопределенным методом compare.
 * Служит для сортировки по id университета
 */

package org.sf247.compare;

import org.apache.commons.lang3.StringUtils;
import org.sf247.modelclass.University;

public class CompareUniversityID implements CompareUniversity{
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getUniversityID(), o2.getUniversityID());
    }
}
