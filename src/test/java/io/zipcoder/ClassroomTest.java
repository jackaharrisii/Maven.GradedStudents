package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassroomTest {

    private Student john;
    private Student emily;
    private Student fritz;
    private Student hugh;
    private Classroom testClassroom;
    private ArrayList<Student> expectedStudents;

    @Before
    public void setUp() throws Exception {
        john = new Student("John", "Smith", new ArrayList<Double>(Arrays.asList(90D, 80D, 70D)));
        emily = new Student("Emily", "Smith", new ArrayList<Double>(Arrays.asList(85D, 80D, 75D)));
        fritz = new Student("Fritz", "Smith", new ArrayList<Double>(Arrays.asList(50D, 40D, 60D)));
        hugh = new Student("Hugh", "Mann", new ArrayList<Double>(Arrays.asList(100D, 95D, 98D)));
        expectedStudents = new ArrayList<Student>(Arrays.asList(john, emily, fritz));
        testClassroom = new Classroom(expectedStudents);
    }

    @Test
    // tests constructing a classroom with a student list
    public void classroomTest() {
        Assert.assertEquals(Arrays.asList(john, emily, fritz), testClassroom.getStudents());
    }

    @Test
    // tests constructing a classroom with a max classroom size
    public void classroomTest2() {
        Classroom smallClassroom = new Classroom(10);
        Assert.assertEquals(Integer.valueOf(10), smallClassroom.maxNumberOfStudents);
    }

    @Test
    // nullary contructor test
    public void classroomTest3() {
        Classroom nullaryClassroom = new Classroom();
        Assert.assertEquals(Integer.valueOf(30), nullaryClassroom.maxNumberOfStudents);
    }

    @Test
    public void getStudents() {
        Assert.assertEquals(Arrays.asList(john, emily, fritz), testClassroom.getStudents());
    }

    @Test
    public void getAllAverageExamScoresTest() {
        Double expectedAverage = 70.0;
        Assert.assertEquals(expectedAverage, testClassroom.getAllAverageExamScores());

    }

    @Test
    //successfully adds a student
    public void addStudentTest(){
        testClassroom.maxNumberOfStudents = 20;
        testClassroom.addStudent(hugh);
        Assert.assertEquals(Arrays.asList(john, emily, fritz, hugh), testClassroom.getStudents());
    }

    @Test
    //tries to add a student, but fails because the classroom is full
    public void addStudentTest2(){
        Classroom fullClassroom = new Classroom(expectedStudents);
        fullClassroom.maxNumberOfStudents = 3;
        fullClassroom.addStudent(hugh);
        Assert.assertEquals(Arrays.asList(john, emily, fritz), testClassroom.getStudents());
    }

    @Test
    //removes the middle student in the array, then checks to make sure the remaining students are all at the front of the array
    public void removeStudentTest(){
        testClassroom.removeStudent(emily);
        Assert.assertEquals(Arrays.asList(john, fritz), testClassroom.getStudents());
    }

    @Test
    //rank students by average test scores - tiebreaker is lexicographical order
    public void getStudentsByScoreTest(){
        Assert.assertEquals(Arrays.asList(emily, john, fritz), testClassroom.getStudentsByScore());
    }

}
