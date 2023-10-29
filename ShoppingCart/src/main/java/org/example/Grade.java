package org.example;

public class Grade {
    private int studentNumber;
    private double grade;

    public Grade(int studentNumber, double grade) {
        this.studentNumber = studentNumber;
        this.grade = grade;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public double getGrade() {
        return grade;
    }

}
