package org.example;

import java.util.ArrayList;

public class Course {
    private String name;
    private ArrayList<Grade> grades;
    private int numberOfStudents;

    public Course(String name) {
        this.name = name;
        this.grades = new ArrayList<Grade>(); // empty array
        this.numberOfStudents = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Grade> getGrades() {
        if(grades != null && grades.size() > 0) {
            return grades;
        }
        throw new IllegalStateException("No grades available. Grades are null.");
    }

    public ArrayList<Double> getGradeMarks() {
        ArrayList<Double> result = new ArrayList<Double>();
        for (Grade grade : grades) {
            result.add(grade.getGrade());
        }
        return result;
    }

    public int getNumberOfStudents() {
        return this.numberOfStudents;
    }

    public void insertGrade(Grade grade){
        if(grade == null) {
            throw new IllegalArgumentException("Grade is null");
        } else if (grades.size() == 0) {
            this.grades.add(grade);
            this.numberOfStudents++;
        }
        else {
            for(int i = 0; i < this.grades.size(); i++) {
                if(this.grades.get(i).getStudentNumber() == grade.getStudentNumber()) {
                    throw new IllegalArgumentException("Student number already exists");
                } else {
                    this.grades.add(grade);
                    this.numberOfStudents++;
                    break;
                }
            }
        }
    }

    public void updateGrade(Grade grade) {
        if(grade == null) {
            throw new IllegalArgumentException("Grade is null");
        } else if (grades.size() == 0) {
            throw new IllegalArgumentException("No grades available");
        }
        for(int i = 0; i < this.grades.size(); i++) {
            if(this.grades.get(i).getStudentNumber() == grade.getStudentNumber()) {
                this.grades.set(i, grade);
                break;
            }
        }
        if(!grades.contains(grade)) {
            throw new IllegalArgumentException("Student number does not exist");
        }
    }

    public double getAverageGrade() {
        if (grades.size() == 0 || numberOfStudents == 0) {
            throw new RuntimeException("No grades available");
        }
        double sum = 0.0;
        for (Grade grade : grades) {
            sum += grade.getGrade();
        }
        return sum / this.numberOfStudents;
    }

    public void removeGrade(Grade grade) {
        for(int i = 0; i < grades.size(); i++) {
            if(grades.get(i).getStudentNumber() == grade.getStudentNumber()) {
                grades.remove(i);
                this.numberOfStudents--;
            }
        }
    }

    public boolean isPassed(int studentNumber) {
        for(int i = 0; i < grades.size(); i++) {
            if(grades.get(i).getStudentNumber() == studentNumber) {
                if(grades.get(i).getGrade() >= 9.5) {
                    return true;
                }
            }
        }
        return false;
    }

    public double searchGradeOfStudent(int studentNumber) {
        for(Grade grade : grades) {
            if(grade.getStudentNumber() == studentNumber) {
                return grade.getGrade();
            }
        }
        return -1;
    }

}
