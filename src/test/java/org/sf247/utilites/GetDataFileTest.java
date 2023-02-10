package org.sf247.utilites;

import org.sf247.io.XlsReader;

class GetDataFileTest {
    String filePath = "src\\main\\resources\\universityInfo.xlsx";

    @org.junit.jupiter.api.Test
    void getStudent() {
        XlsReader.getStudent(filePath);
    }

    @org.junit.jupiter.api.Test
    void getUniver() {
        XlsReader.getUniver(filePath);
    }
}