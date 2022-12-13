import java.util.ArrayList;

public class SchoolManagementSystem {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private ArrayList<Teacher> teachers;
    private ArrayList<Enrollment> enrollments;
    private PersonFactory personFactory;
    private CourseFactory courseFactory;

    public SchoolManagementSystem() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        teachers = new ArrayList<>();
        enrollments = new ArrayList<>();

        personFactory = new PersonFactory();
        courseFactory = new CourseFactory();
    }
    public void addStudent(String name) {
        if (getStudent(name) == null) {
            students.add((Student) personFactory.createPerson("Student", name));
            System.out.println(name + " added as a student.");
        } else {
            System.err.println("Student with name '" + name + "' already exists.");
        }
    }
    public Student getStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }
    public void addCourse(String name) {
        courses.add(courseFactory.createCourse(name));
    }
    public void enrollStudent(Student student, Course course) {
        enrollments.add(new Enrollment(student, course));
    }
    public ArrayList<Enrollment> getEnrollments(String student) {
        ArrayList<Enrollment> enrollmentList = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentName().equalsIgnoreCase(student)) {
                enrollmentList.add(enrollment);
            }
        }
        return enrollmentList;
    }
    public ArrayList<Course> getStudentCourses(String student) {
        ArrayList<Course> courses = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentName().equalsIgnoreCase(student)) {
                courses.add(enrollment.getCourse());
            }
        }
        return courses;
    }

    public Course getCourse(String courseName) {
        for (Course course : courses) {
            if (course.getCourseName().equalsIgnoreCase(courseName)) {
                return  course;
            }
        }
        System.err.println("Couldn't find course '" + courseName + "'.");
        return null;
    }
    public ArrayList<Student> getStudents(String courseName) {
        ArrayList<Student> studentList = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourseName().equalsIgnoreCase(courseName)) {
                studentList.add(enrollment.getStudent());
            }
        }
        return studentList;
    }
    public void removeEnrollment(String name) {
        enrollments.removeIf(enrollment -> enrollment.getStudentName().equalsIgnoreCase(name));
    }

    public void removeStudent(String name) {
        students.removeIf(student -> student.getName().equalsIgnoreCase(name));
        removeEnrollment(name);
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public ArrayList<Course> getAllCourses() {
        return courses;
    }

    public ArrayList<Teacher> getAllTeachers() {
        return teachers;
    }

    public ArrayList<Enrollment> getAllEnrollments() {
        return enrollments;
    }
}
