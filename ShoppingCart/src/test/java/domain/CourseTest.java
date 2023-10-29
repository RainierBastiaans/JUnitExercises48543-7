package domain;

import static org.junit.jupiter.api.Assertions.*;
import org.example.Course;
import org.example.Grade;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CourseTest {

    private static Course course;
    private static Grade grade1, grade2, grade3;

    @BeforeEach
    public void setUp() {
        course = new Course("Software Testing");
        grade1 = new Grade(1, 8.0);
        grade2 = new Grade(200, 17.0);
        grade3 = new Grade(3, 9.5);
    }

    @Test
    public void test_addGrade_Then_GradeAdded() {
        assertEquals(0, course.getNumberOfStudents());

        course.insertGrade(grade1);

        assertEquals(1, course.getNumberOfStudents());
    }

    @Test
    public void test_removeGrade_Then_GradeRemoved(){
        assertEquals(0, course.getNumberOfStudents());
        course.insertGrade(grade1);
        course.insertGrade(grade2);
        assertEquals(2, course.getNumberOfStudents());

        course.removeGrade(grade1);
        assertEquals(1, course.getNumberOfStudents());
        assertEquals(grade2, course.getGrades().get(0));
    }

    @Test
    public void test_updateGrade_Then_GradeUpdated(){
        assertEquals(0, course.getNumberOfStudents());
        course.insertGrade(grade1);
        course.insertGrade(grade2);
        assertEquals(2, course.getNumberOfStudents());

        //grade2Updated
        Grade grade2Updated = new Grade(200, 7.0);
        course.updateGrade(grade2Updated);
        assertEquals(2, course.getNumberOfStudents());
        assertEquals(grade2Updated.getGrade(), course.searchGradeOfStudent(200));
    }

    @ParameterizedTest
    @CsvSource({"1, 8.0", "2, 17.0", "3, 9.5"})
    public void test_searchGradeOfStudent_Then_GradeReturned(int studentNumber, double mark){
        assertNotNull(course);

        Grade grade = new Grade(studentNumber, mark);
        course.insertGrade(grade);

        assertNotEquals(-1, course.searchGradeOfStudent(studentNumber));
    }

    @Test
    public void test_getAverageGrade_Then_AverageGradeReturned(){
        assertEquals(0, course.getNumberOfStudents());
        course.insertGrade(grade1);
        course.insertGrade(grade2);
        course.insertGrade(grade3);
        double avg = (grade1.getGrade() + grade2.getGrade() + grade3.getGrade()) / course.getNumberOfStudents();

        assertEquals(3, course.getNumberOfStudents());

        assertEquals(avg, course.getAverageGrade());
    }

}
