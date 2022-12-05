/**
 * Класс CompareUniversityMainProfile зависящий от интерфейса CompareUniversity
 * с переопределенным методом compare.
 * Служит для сортировки по профилю университета
 */

package org.sf247.compare;

import org.apache.commons.lang3.StringUtils;
import org.sf247.modelclass.University;

public class CompareUniversityMainProfile implements CompareUniversity {

    @Override
    public int compare(University o1, University o2) {
        if (o1.getMainProfile() == null) return 1; else if (o2.getMainProfile() == null) return -1;
        return StringUtils.compare(o1.getMainProfile().name(), o2.getMainProfile().name());
    }
}
