import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        SchoolManagementSystem schoolManagementSystem = new SchoolManagementSystem();
        for (Courses course : Courses.values()) {
            schoolManagementSystem.addCourse(course.name());
        }

        System.out.println(schoolManagementSystem.getAllCourses());

        for (Students student : Students.values()) {
            schoolManagementSystem.addStudent(student.name());
        }

        System.out.println(schoolManagementSystem.getAllStudents());

        schoolManagementSystem.enrollStudent(schoolManagementSystem.getStudent("Adam"), schoolManagementSystem.getCourse("History"));
        schoolManagementSystem.enrollStudent(schoolManagementSystem.getStudent("Adam"), schoolManagementSystem.getCourse("Mathematics"));
        schoolManagementSystem.enrollStudent(schoolManagementSystem.getStudent("Adam"), schoolManagementSystem.getCourse("English"));

        System.out.println(schoolManagementSystem.getStudentCourses("Adam"));

        System.out.println(schoolManagementSystem.getStudents("History"));

        schoolManagementSystem.enrollStudent(schoolManagementSystem.getStudent("BERT"), schoolManagementSystem.getCourse("History"));

        System.out.println(schoolManagementSystem.getStudents("History"));

    }
}
