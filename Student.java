import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void displayStudent() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Rank: " + getRank());
        System.out.println("------------");
    }

    String getRank() {
        if (marks < 5.0) return "Fail";
        if (marks < 6.5) return "Medium";
        if (marks < 7.5) return "Good";
        if (marks < 9.0) return "Very Good";
        return "Excellent";
    }
}

class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    // Sắp xếp theo điểm giảm dần
    public void sortByMarksDescending() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getMarks(), s1.getMarks());
            }
        });
    }

    // Sắp xếp theo tên (A-Z)
    public void sortByName() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
    }

    // Hiển thị tất cả sinh viên
    public void displayAllStudents() {
        for (Student student : students) {
            student.displayStudent();
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        // Thêm sinh viên
        manager.addStudent(new Student(1, "Alice", 8.5));
        manager.addStudent(new Student(2, "Bob", 6.3));
        manager.addStudent(new Student(3, "Charlie", 7.2));
        manager.addStudent(new Student(4, "David", 5.8));
        manager.addStudent(new Student(5, "Eve", 9.1));

        // Sắp xếp theo điểm và hiển thị
        System.out.println("The list is sorted by ascending score:");
        manager.sortByMarksDescending();
        manager.displayAllStudents();

        // Sắp xếp theo tên và hiển thị
        System.out.println("List sorted by name:");
        manager.sortByName();
        manager.displayAllStudents();
    }
}

