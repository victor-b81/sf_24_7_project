package org.sf247.compare;

import org.sf247.modelclass.University;

public class CompareUniversityYearOfFoundation implements CompareUniversity{
    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
