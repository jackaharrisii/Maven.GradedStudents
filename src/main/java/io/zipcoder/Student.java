package io.zipcoder;

import java.util.ArrayList;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;
    private Double finalScore;
    private String finalGrade;

    public Student(String firstName, String lastName, ArrayList<Double> examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }

    public String printExamScoresAsString(ArrayList<Double> examScores){
        StringBuilder examPrintout = new StringBuilder();
        examPrintout.append("Exam Scores:\n");
        for (int i = 0; i < examScores.size(); i++){
            examPrintout.append(String.format("\tExam %d -> %.0f", i+1, examScores.get(i)));
            if (i < examScores.size()-1) {examPrintout.append("\n");}
        }
//        examPrintout.append("Exam 1 -> " + examScores.get(0) + "\n");
//        examPrintout.append("Exam 2 -> " + examScores.get(1));
        return examPrintout.toString();
    }

    @Override
    public String toString(){
        StringBuilder studentSummaryToString = new StringBuilder();
        studentSummaryToString.append(String.format("Student Name: %s %s\n> Average Score: %.0f\n> ", this.getFirstName(), this.getLastName(), this.getAverageExamScore()));
        studentSummaryToString.append(printExamScoresAsString(this.examScores));
        return studentSummaryToString.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Double> getExamScores() {
        return examScores;
    }

    public Integer getNumberOfExamsTaken(){
        return examScores.size();
    }

    public void addExamScore(Double newExamScore){
        this.examScores.add(newExamScore);
    }

    public void setExamScore(int examNumber, Double newScore){
        // used for correcting an erroneous exam score
        this.examScores.set(examNumber, newScore);
    }

    public Double getAverageExamScore(){
        Double sum = 0.0;
        for(int i = 0; i < examScores.size(); i++ ){
            sum += examScores.get(i);
        }
        finalScore = sum / examScores.size();
        return finalScore;
    }

    @Override
    public int compareTo(Student other) {
        if(this.getAverageExamScore().compareTo(other.getAverageExamScore()) != 0) {return -1 * this.getAverageExamScore().compareTo(other.getAverageExamScore());}
        else if (lastName.compareTo(other.lastName) != 0) {return lastName.compareTo(other.lastName);}
        else {return firstName.compareTo(other.firstName);}
    }
}
