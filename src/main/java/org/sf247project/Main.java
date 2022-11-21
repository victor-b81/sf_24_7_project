package org.sf247project;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<University> universities = new LinkedList<University>();
        LinkedList<Student> students = new LinkedList<Student>();

        universities.add(new University("1", "SkillFactory", "SF", 2020, StudyProfile.IT));
        universities.add(new University("2", "Medic2018", "MED", 2018, StudyProfile.MEDICINE));
        universities.add(new University("3", "Mech2010", "MECH", 2010, StudyProfile.MECHANICS));
        universities.add(new University("4", "Manag2015", "MNG", 2015, StudyProfile.MANAGEMENT));

        students.add(new Student("Borisenko Victor", "1", 2, 92));
        students.add(new Student("Eliseeva Anna", "2", 4, 95));
        students.add(new Student("Selihin Andrey", "3", 3, 76));
        students.add(new Student("Ivanova Elena", "4", 1, 82));

        for (Object unvs : universities){
            System.out.println("====================\n" + unvs);
        }


    }
}