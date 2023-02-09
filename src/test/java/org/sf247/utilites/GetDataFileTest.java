package org.sf247.utilites;

class GetDataFileTest {
    String filePath = "src\\main\\resources\\universityInfo.xlsx";

    @org.junit.jupiter.api.Test
    void getStudent() {
        GetDataFile.getStudent(filePath);
    }

    @org.junit.jupiter.api.Test
    void getUniver() {
        GetDataFile.getUniver(filePath);
    }
}