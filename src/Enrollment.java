public class Enrollment {
    private Student student;
    private Course course;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public String getStudentName() {
        return student.getName();
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "student=" + student +
                ", course=" + course +
                '}';
    }

    public String getCourseName() {
        return course.getCourseName();
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }
}
