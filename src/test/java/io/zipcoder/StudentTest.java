package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {

    @Test
    public void getFirstNameTest() {
        ArrayList<Double> expectedScores = new ArrayList<Double>(Arrays.asList(55D, 83D));
        Student jeff = new Student("Jeff", "Smith", expectedScores);
        Assert.assertEquals(jeff.getFirstName(),"Jeff");
    }

    @Test
    public void setFirstNameTest() {
        ArrayList<Double> expectedScores = new ArrayList<Double>(Arrays.asList(55D, 83D));
        Student jeff = new Student("Jeff", "Smith", expectedScores);
        jeff.setFirstName("Jeffrey");
        Assert.assertEquals(jeff.getFirstName(),"Jeffrey");
    }

    @Test
    public void getLastNameTest() {
        ArrayList<Double> expectedScores = new ArrayList<Double>(Arrays.asList(55D, 83D));
        Student jeff = new Student("Jeff", "Smith", expectedScores);
        Assert.assertEquals(jeff.getLastName(),"Smith");
    }

    @Test
    public void setLastNameTest() {
        ArrayList<Double> expectedScores = new ArrayList<Double>(Arrays.asList(55D, 83D));
        Student jeff = new Student("Jeff", "Smith", expectedScores);
        jeff.setLastName("Smith II");
        Assert.assertEquals(jeff.getLastName(),"Smith II");
    }

    @Test
    public void getExamScoresTest() {
        ArrayList<Double> expectedScores = new ArrayList<Double>(Arrays.asList(55D, 83D));
        Student jeff = new Student("Jeff", "Smith", expectedScores);
        Assert.assertEquals(jeff.getExamScores(),expectedScores);
    }

    @Test
    public void getNumberOfExamsTakenTest() {
        ArrayList<Double> expectedScores = new ArrayList<Double>(Arrays.asList(55D, 83D));
        Student jeff = new Student("Jeff", "Smith", expectedScores);
        Assert.assertEquals(jeff.getNumberOfExamsTaken(),Integer.valueOf(2));
    }

    @Test
    public void printExamScoresAsStringTest() {
        ArrayList<Double> expectedScores = new ArrayList<Double>(Arrays.asList(55D, 83D));
        Student jeff = new Student("Jeff", "Smith", expectedScores);
        String actualPrintOut = jeff.printExamScoresAsString(expectedScores);
        String expectedPrintOut = "Exam Scores:\n\tExam 1 -> 55\n\tExam 2 -> 83";
        Assert.assertEquals(expectedPrintOut, actualPrintOut);
    }

    @Test
    public void printExamScoresAsStringTest2() {
        ArrayList<Double> expectedScores = new ArrayList<Double>(Arrays.asList(55D, 83D, 78D, 85D));
        Student jeff = new Student("Jeff", "Smith", expectedScores);
        String actualPrintOut = jeff.printExamScoresAsString(expectedScores);
        String expectedPrintOut = "Exam Scores:\n\tExam 1 -> 55\n\tExam 2 -> 83\n\tExam 3 -> 78\n\tExam 4 -> 85";
        Assert.assertEquals(expectedPrintOut, actualPrintOut);
    }

    @Test
    public void toStringTest(){
        ArrayList<Double> expectedScores = new ArrayList<Double>(Arrays.asList(50D, 60D, 70D, 80D));
        Student jeff = new Student("Jeff", "Smith", expectedScores);
        String actualPrintOut = jeff.toString();
        String expectedPrintOut = "Student Name: Jeff Smith\n> Average Score: 65\n> Exam Scores:\n\tExam 1 -> 50\n\tExam 2 -> 60\n\tExam 3 -> 70\n\tExam 4 -> 80";
        Assert.assertEquals(expectedPrintOut, actualPrintOut);
    }

    @Test
    public void addExamScoreTest() {
        ArrayList<Double> expectedScores = new ArrayList<Double>(Arrays.asList(55D, 83D, 78D, 85D));
        Student jeff = new Student("Jeff", "Smith", expectedScores);
        jeff.addExamScore(95D);
        expectedScores.add(95D);
        Assert.assertEquals(expectedScores, jeff.getExamScores());
    }

    @Test
    public void setExamScoreTest() {
        ArrayList<Double> expectedScores = new ArrayList<Double>(Arrays.asList(55D, 83D, 78D, 85D));
        Student jeff = new Student("Jeff", "Smith", expectedScores);
        jeff.setExamScore(3, 95D);
        expectedScores.set(3, 95D);
        Assert.assertEquals(expectedScores, jeff.getExamScores());
    }

    @Test
    public void getAverageExamScore() {
        ArrayList<Double> expectedScores = new ArrayList<Double>(Arrays.asList(50D, 60D, 70D, 80D));
        Student jeff = new Student("Jeff", "Smith", expectedScores);
        Assert.assertEquals(Double.valueOf(65.0), jeff.getAverageExamScore());
    }

}