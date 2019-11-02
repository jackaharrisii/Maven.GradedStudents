package io.zipcoder;

import java.io.Serializable;
import java.util.*;

public class Classroom {
    public Integer maxNumberOfStudents;
    public ArrayList<Student> students;

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

        Collections.sort(students);
        return students;
    }

//    public class HashMap<Student, String> extends AbstractMap<Student, String> implements Map<Student, String>, Cloneable, Serializable{
//
//    }

    public Student getGradeBook(){
        return null;
    }

}
