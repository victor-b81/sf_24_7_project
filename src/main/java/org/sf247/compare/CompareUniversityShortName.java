/**
 * ����� CompareUniversityShortName ��������� �� ���������� CompareUniversity
 * � ���������������� ������� compare.
 * ������ ��� ���������� �� ������������ �����
 */

package org.sf247.compare;

import org.apache.commons.lang3.StringUtils;
import org.sf247.modelclass.University;

public class CompareUniversityShortName implements CompareUniversity{
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getShortName(), o2.getShortName());
    }
}
