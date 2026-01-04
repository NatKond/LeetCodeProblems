import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

record Student(String firstName, String lastName, List<String> courses) {

    public Student{
        courses = List.copyOf(courses);
    }

    public List<String> courses (){
        return List.copyOf(courses);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "\nCourses: " + courses;
    }
}

public class ImmutableClass {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Mathematics", "Engineering Physics", "Electric Circuits"));
        Student student = new Student("John", "Smith", list);
        System.out.println(student);
        list.add("Computer Science");
        System.out.println(student);

        List<String> courses = student.courses();
        courses.forEach(s -> s += " I");
        System.out.println(student);
    }
}
