/**
 * Класс CompareUniversityFullName зависящий от интерфейса CompareUniversity
 * с переопределенным методом compare.
 * Служит для сортировки по имени университета
 */

package org.sf247.compare;

import org.apache.commons.lang3.StringUtils;
import org.sf247.modelclass.University;

public class CompareUniversityFullName implements CompareUniversity{
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getFullName(), o2.getFullName());
    }
}
