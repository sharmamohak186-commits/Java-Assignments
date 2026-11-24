package ass4.q1;

import java.util.*;

class Course {
    final String code, name;
    final HashSet<String> enrolledStudentIds = new HashSet<>();
    final ArrayList<String> prerequisiteCodes = new ArrayList<>();
    final LinkedList<String> waitlist = new LinkedList<>();
    Course(String code, String name) { this.code = code; this.name = name; }
    public String toString() { return code + " - " + name; }
}

class RegistrationPortal {
    private final Map<String, Course> courses = new HashMap<>();
    private final Map<String, Set<String>> studentCourses = new HashMap<>();
    private final Map<String, List<String>> activity = new HashMap<>();

    void addCourse(Course course) { courses.put(course.code, course); }
    void register(String student, String code) {
        Course course = courses.get(code);
        if (course == null) { log(student, "Course not found: " + code); return; }
        Set<String> registered = studentCourses.computeIfAbsent(student, key -> new HashSet<>());
        if (!registered.add(code)) { log(student, "Already registered: " + code); return; }
        course.enrolledStudentIds.add(student);
        log(student, "Registered for " + code);
    }
    void unregister(String student, String code) {
        Set<String> registered = studentCourses.get(student);
        Course course = courses.get(code);
        if (registered != null && registered.remove(code)) { if (course != null) course.enrolledStudentIds.remove(student); log(student, "Unregistered from " + code); promoteNext(code); }
        else { log(student, "No registration found for " + code); }
    }
    void joinWaitlist(String student, String code) { Course course = courses.get(code); if (course != null && !course.waitlist.contains(student)) course.waitlist.offer(student); log(student, "Joined waitlist for " + code); }
    void promoteNext(String code) { Course course = courses.get(code); if (course != null && !course.waitlist.isEmpty()) register(course.waitlist.poll(), code); }
    void log(String student, String message) { activity.computeIfAbsent(student, key -> new ArrayList<>()).add(message); }
    void printSummary() { System.out.println("Courses: " + courses.values()); System.out.println("Registrations: " + studentCourses); System.out.println("Course collections: " + courses); System.out.println("Activity: " + activity); }
}

public class Main {
    public static void main(String[] args) {
        RegistrationPortal portal = new RegistrationPortal();
        portal.addCourse(new Course("CS101", "Data Structures"));
        portal.addCourse(new Course("CS102", "Java Programming"));
        portal.register("Asha", "CS101"); portal.register("Ravi", "CS102");
        portal.joinWaitlist("Meera", "CS101"); portal.unregister("Asha", "CS101");
        portal.printSummary();
    }
}
