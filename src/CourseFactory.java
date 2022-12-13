public class CourseFactory {
    public Course createCourse(String courseName) {
        if (courseName.equalsIgnoreCase("HISTORY")) {
            return new History();
        }
        else if (courseName.equalsIgnoreCase("MATHEMATICS")) {
            return new Mathematics();
        }
        else if (courseName.equalsIgnoreCase("ENGLISH")) {
            return new English();
        }
        else {
            System.err.println("Couldn't create course: '" + courseName + "'.");
            return null;
        }
    }
}
