package studentdb2;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author localuser
 */
public class Student implements Serializable {

    private String StudentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    // private String course;
    private int yearLevel;
    private Course course;
    private String crushName;
    private Course faveSubject;

    public Student(String studentNumber, String firstName, char middleInitial, String lastName, Course course, String crushName, int yearLevel) {
        StudentNumber = studentNumber;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.course = course;
        this.crushName = crushName;
        this.yearLevel = yearLevel;
    }

    public String getStudentNumber() {
        return StudentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        StudentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getcrushName() {
        return crushName;
    }

    public void setcrushName(String crushName) {
        this.crushName = crushName;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s\n%c\n%s\n%s\n%d\n", StudentNumber, firstName, middleInitial, lastName, course, yearLevel);
    }

}
