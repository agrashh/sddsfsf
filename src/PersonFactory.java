public class PersonFactory {
    public Person createPerson(String type, String name) {
        if (type.equalsIgnoreCase("STUDENT")) {
            return new Student(name);
        }
        if (type.equalsIgnoreCase("TEACHER")) {
            return new Teacher(name);
        }
        else {
            System.err.println("Couldn't create person of type '" + type + "'.");
            return null;
        }
    }
}
