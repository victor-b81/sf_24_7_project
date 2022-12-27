/** ��������� ����� GetStatistics
 * ��� ��������� ��������� ���������, ������������� � ��������� ����������
 *
 */
package org.sf247.utilites;

import org.sf247.enumenators.StudyProfile;
import org.sf247.modelclass.Statistics;
import org.sf247.modelclass.Student;
import org.sf247.modelclass.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

public class GetStatistics {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(GetStatistics.class.getName()); // ����������� �����������
    private GetStatistics() {}

    /** �������� ����� collectStatistics
     * ��������� �������� collectStudent � collectUniversity
     * ������ ��� ������������ �������������� ������:
     * - ������ ������ �������� �������������
     * - ���������� �������������
     * - ID �������������
     * - ���������� ��������
     * - ������� ��� �� ���������
     * ��������� ���� ������������ � ��������� statisticsCollection
     * @return statisticsCollection
     */
    public static List<Statistics> collectStatistics(List<Student> collectStudent, List<University> collectUniversity){
        log.log(Level.INFO,"�������� ��������� students � universities");
        List<Statistics> statisticsCollection = new ArrayList<>();
        log.log(Level.INFO,"������� ���������� studentStat � univerStat �� ���������� ��������� students � universities");
        HashMap<String, HashMap<String, String>> univerStat = getUniverStatistic(collectUniversity);
        HashMap<String, HashMap<String, String>> studentStat = getStudentStatistic(collectStudent, univerStat.get("IDsUniver"));

        log.log(Level.INFO,"�������� ����� ���������� statisticsCollection �� studentStat � univerStat");
        HashMap<String, String> mainProfile = univerStat.get("IDsUniver");
        HashMap<String, String> fullUniverName = univerStat.get("ListUniver");
        HashMap<String, String> mainProfileUniverCount = univerStat.get("CountUniver");
        HashMap<String, String> mainProfileStudentCount = studentStat.get("CountStudets");
        HashMap<String, String> avgExamScore = studentStat.get("avgExamScore");

        mainProfile.forEach((kMainProfile, vMainProfile) -> statisticsCollection.add(new Statistics(kMainProfile,
                avgExamScore.get(kMainProfile),
                mainProfileStudentCount.get(kMainProfile),
                mainProfileUniverCount.get(kMainProfile),
                fullUniverName.get(kMainProfile))));
        log.log(Level.INFO,"��������� ���������� statisticsCollection ����������� �������");
        return statisticsCollection;
    }

    /** ��������� ����� getUniverStatistic
     * ���������� ������ �������� ������������� � �� ���������� �������� �������
     * ����������� ������:
     * universityNamesHashMap - ������ ������ �������� ������������� �������� �������
     * countUniversityNames - ���������� ������������� �������� �������
     * universityIDs - ID �������������
     * ��������� ���� ������������ � ��������� collectUniverStatistic
     * @return collectUniverStatistic
     */
    private static HashMap<String, HashMap<String, String>> getUniverStatistic(List<University> collectUniversity){

        List<String> universityNamesList = new ArrayList<>();
        List<String> universityIDsList = new ArrayList<>();
        HashMap<String, HashMap<String, String>> collectUniverStatistic = new HashMap<>();
        HashMap<String, String> universityNamesHashMap = new HashMap<>();
        HashMap<String, String> countUniversityNames = new HashMap<>();
        HashMap<String, String> universityIDs = new HashMap<>();
        int cUniversityNames = 0;
        String univerProfile="";

        for (University listUniver : collectUniversity){

            if (!univerProfile.equals(String.valueOf(listUniver.getMainProfile()))){
                universityNamesList.clear();
                universityIDsList.clear();
                cUniversityNames=0;
                univerProfile = String.valueOf(listUniver.getMainProfile());
            }

            for (StudyProfile sp : StudyProfile.values()){
                if (listUniver.getMainProfile().equals(sp)) {
                    universityNamesList.add(listUniver.getFullName());
                    universityIDsList.add(listUniver.getUniversityID());
                    cUniversityNames++;
                }
            }
            universityNamesHashMap.put(univerProfile, String.valueOf(universityNamesList).replace("]","").replace("[", ""));
            countUniversityNames.put(univerProfile, String.valueOf(cUniversityNames).replace("]","").replace("[", ""));
            universityIDs.put(univerProfile, String.valueOf(universityIDsList).replace("]","").replace("[", ""));
        }
        collectUniverStatistic.put("ListUniver", universityNamesHashMap);
        collectUniverStatistic.put("CountUniver", countUniversityNames);
        collectUniverStatistic.put("IDsUniver", universityIDs);
        log.log(Level.INFO,"��������� ���������� collectUniverStatistic � univerStat");
        return collectUniverStatistic;
    }

    /** ��������� ����� getStudentStatistic
     * ���������� ������� ��� �� ��������� � ���������� �������� �������� �������
     * ����������� ������:
     * countStudetsProfile - ���������� �������� �������� �������
     * avgExamScoreProfile - ������� ��� �� ��������� �������� �������
     * ��������� ���� ������������ � ��������� collectStudentStatistic
     * @return collectStudentStatistic
     */
    private static HashMap<String, HashMap<String, String>> getStudentStatistic(List<Student> collectStudent, HashMap<String, String> univerIDs){
        HashMap<String, HashMap<String, String>> collectStudentStatistic = new HashMap<>();
        HashMap<String, String> countStudetsProfile = new HashMap<>();
        HashMap<String, String> avgExamScoreProfile = new HashMap<>();

        univerIDs.forEach((kuniverIDs, vUniverIDs) -> {
            int cStudetsProfile = 0;
            Optional<Double> checkAvgExamScore;
            BigDecimal bdAvgExamScore = null;
            double getAvgExamScore= 0.0;
            String[] strUniverIDs = vUniverIDs.split(", ");
            for (String s : strUniverIDs){
                for (Student listCS : collectStudent){
                    if (s.equals(listCS.getUniversityId())) {
                        cStudetsProfile++;
                        checkAvgExamScore = Optional.ofNullable(listCS.getAvgExamScore());
                        if (checkAvgExamScore.isPresent()){
                            getAvgExamScore = (getAvgExamScore+checkAvgExamScore.get())/cStudetsProfile;
                        } else {
                            getAvgExamScore = getAvgExamScore/cStudetsProfile;
                        }
                    }
                }
                bdAvgExamScore = new BigDecimal(String.valueOf(getAvgExamScore));
                bdAvgExamScore = bdAvgExamScore.setScale(2, RoundingMode.UP);
            }
            if (cStudetsProfile!=0) {
                avgExamScoreProfile.put(kuniverIDs, String.valueOf(bdAvgExamScore));
                countStudetsProfile.put(kuniverIDs, String.valueOf(cStudetsProfile));
            } else {
                countStudetsProfile.put(kuniverIDs, "��� ���������");
                avgExamScoreProfile.put(kuniverIDs, "��� ���������");
            }
        });
        collectStudentStatistic.put("CountStudets", countStudetsProfile);
        collectStudentStatistic.put("avgExamScore", avgExamScoreProfile);
        log.log(Level.INFO,"��������� ���������� collectStudentStatistic � studentStat");
        return collectStudentStatistic;}
}