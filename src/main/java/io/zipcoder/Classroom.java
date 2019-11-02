package io.zipcoder;

import java.io.Serializable;
import java.util.*;

public class Classroom {
    public Integer maxNumberOfStudents;
    public ArrayList<Student> students;
    public LinkedHashMap<String, String> gradeBookMap;

    public Classroom(ArrayList<Student> students) {
        this.students = students;
        this.maxNumberOfStudents = students.size();
    }

    public Classroom(int maxNumberOfStudents){
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Classroom(){
        this.maxNumberOfStudents = 30;
        students = new ArrayList<Student>(maxNumberOfStudents);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Double getAllAverageExamScores(){
        Double sumOfAverageExamScores = 0.0;
        for(int i = 0; i < students.size(); i++){
            sumOfAverageExamScores += students.get(i).getAverageExamScore();
        }
        return sumOfAverageExamScores / students.size();
    }

    public void addStudent(Student newStudent){
        if(students.size() < maxNumberOfStudents){
            students.add(newStudent);}
        else{
            System.out.println("tough shit - the classroom is full");
        }
    }

    public void removeStudent(Student studentToRemove){
        if(students.contains(studentToRemove)){
            for (int i = 0; i < students.size(); i++){
                if (students.get(i) == studentToRemove){students.remove(i);}
            }
        }
    }

    public List getStudentsByScore(){
        //revised the sorter to do all of this
        //also, this version could not distinguish between double scores that equal each other if integers, i.e., it would sort a 98.3 and a 98.6 alphabetically instead of by score
//        ArrayList<Student> alphabeticalStudentList = new ArrayList<>(students);
//        Collections.sort(alphabeticalStudentList);
//        ArrayList<Student> studentListSortedByScore = new ArrayList<>(0);
//        Double sortScore = 100.0;
//        while (studentListSortedByScore.size() < alphabeticalStudentList.size()){
//            for (int i = 0; i < alphabeticalStudentList.size(); i++) {
//                if (alphabeticalStudentList.get(i).getAverageExamScore() <= sortScore && alphabeticalStudentList.get(i).getAverageExamScore() > sortScore - 1) {
//                    studentListSortedByScore.add(alphabeticalStudentList.get(i));
//                }
//            }
//            sortScore--;
//        }
//        return studentListSortedByScore;

        //created a custom object sorter in the Student class
        Collections.sort(students);
        return students;
    }

    public HashMap<String, String> getGradeBook(){
        gradeBookMap = new LinkedHashMap<String, String>();
        getStudentsByScore();          // sorts students by grade > lastName > firstName order before inserting into LinkedHashMap
        String letterGrade = "I";
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getAverageExamScore() <= 100 && students.get(i).getAverageExamScore() >= 90) {letterGrade = "A";}      //possible bug - will not return a letter grade for scores above 100
            else if (students.get(i).getAverageExamScore() < 90 && students.get(i).getAverageExamScore() >=71 ) {letterGrade = "B";}
            else if (students.get(i).getAverageExamScore() < 71 && students.get(i).getAverageExamScore() >=50 ) {letterGrade = "C";}
            else if (students.get(i).getAverageExamScore() < 50 && students.get(i).getAverageExamScore() >=11 ) {letterGrade = "D";}
            else if (students.get(i).getAverageExamScore() < 11 && students.get(i).getAverageExamScore() >=0 ) {letterGrade = "F";}
            else {letterGrade = "I";}       //sets grade to "I" for "incomplete" if they don't have a grade or if there is an error in their grading
            gradeBookMap.put((students.get(i).getFirstName() + " " + students.get(i).getLastName()), letterGrade);
        }
        return gradeBookMap;
    }

}
