import java.util.Scanner;

public class mane {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            try {
                System.out.println("\nChoose an action:");
                System.out.println("1. Add student to the beginning of the list");
                System.out.println("2. Add student to the end of the list");
                System.out.println("3. Remove the first student");
                System.out.println("4. Remove the last student");
                System.out.println("5. Display the student list");
                System.out.println("6. Search for a student by ID");
                System.out.println("7. Edit a student's name and marks");
                System.out.println("8. Sort students by marks (ascending)");
                System.out.println("9. Sort students by marks (descending)");
                System.out.println("10. Sort students by name (A-Z)");
                System.out.println("11. Display comparison table");
                System.out.println("12. Exit");
                System.out.print("Your choice: ");

                choice = getValidIntegerInput(scanner);

                switch (choice) {
                    case 1:
                        addStudentToBeginning(scanner, studentList);
                        break;
                    case 2:
                        addStudentToEnd(scanner, studentList);
                        break;
                    case 3:
                        removeFirstStudent(studentList);
                        break;
                    case 4:
                        removeLastStudent(studentList);
                        break;
                    case 5:
                        displayStudentList(studentList);
                        break;
                    case 6:
                        searchStudentById(scanner, studentList);
                        break;
                    case 7:
                        editStudent(scanner, studentList);
                        break;
                    case 8:
                        studentList.sortStudentsByMarks();
                        System.out.println("Students sorted by marks in ascending order.");
                        break;
                    case 9:
                        studentList.sortStudentsByMarksDescending();
                        System.out.println("Students sorted by marks in descending order.");
                        break;
                    case 10:
                        studentList.sortStudentsByName();
                        System.out.println("Students sorted by name in alphabetical order.");
                        break;
                    case 11:
                        System.out.println("Comparison Table:");
                        studentList.displayComparisonTable();
                        break;
                    case 12:
                        System.out.println("Program terminated.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); // Clear invalid input
            }
        } while (choice != 12);

        scanner.close();
    }

    // Validates and returns an integer input
    public static int getValidIntegerInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline after int input
        return input;
    }

    // Validates and returns a double input
    public static double getValidDoubleInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        double input = scanner.nextDouble();
        scanner.nextLine(); // Consume newline after double input
        return input;
    }

    // Adds a student to the beginning of the list
    public static void addStudentToBeginning(Scanner scanner, StudentLinkedList studentList) {
        try {
            System.out.print("Enter student ID: ");
            int id = getValidIntegerInput(scanner);
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student marks: ");
            double marks = getValidDoubleInput(scanner);
            studentList.addFirst(new Student(id, name, marks));
        } catch (Exception e) {
            System.out.println("Error in adding student to the beginning: " + e.getMessage());
        }
    }

    // Adds a student to the end of the list
    public static void addStudentToEnd(Scanner scanner, StudentLinkedList studentList) {
        try {
            System.out.print("Enter student ID: ");
            int id = getValidIntegerInput(scanner);
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student marks: ");
            double marks = getValidDoubleInput(scanner);
            studentList.addLast(new Student(id, name, marks));
        } catch (Exception e) {
            System.out.println("Error in adding student to the end: " + e.getMessage());
        }
    }

    // Removes the first student from the list
    public static void removeFirstStudent(StudentLinkedList studentList) {
        try {
            studentList.deleteFirst();
            System.out.println("The first student has been removed.");
        } catch (Exception e) {
            System.out.println("Error in removing the first student: " + e.getMessage());
        }
    }

    // Removes the last student from the list
    public static void removeLastStudent(StudentLinkedList studentList) {
        try {
            studentList.deleteLast();
            System.out.println("The last student has been removed.");
        } catch (Exception e) {
            System.out.println("Error in removing the last student: " + e.getMessage());
        }
    }

    // Displays the list of students
    public static void displayStudentList(StudentLinkedList studentList) {
        try {
            System.out.println("Student list:");
            studentList.displayList();
        } catch (Exception e) {
            System.out.println("Error in displaying student list: " + e.getMessage());
        }
    }

    // Searches for a student by ID
    public static void searchStudentById(Scanner scanner, StudentLinkedList studentList) {
        try {
            System.out.print("Enter student ID to search for: ");
            int searchId = getValidIntegerInput(scanner);
            Student foundById = studentList.searchById(searchId);
            if (foundById != null) {
                foundById.displayStudent();
            } else {
                System.out.println("Student not found.");
            }
        } catch (Exception e) {
            System.out.println("Error in searching student by ID: " + e.getMessage());
        }
    }

    // Edits the student's name and marks
    public static void editStudent(Scanner scanner, StudentLinkedList studentList) {
        try {
            System.out.print("Enter student ID to edit: ");
            int editId = getValidIntegerInput(scanner);
            System.out.print("Enter new student name: ");
            String editName = scanner.nextLine();
            System.out.print("Enter new student marks: ");
            double editMarks = getValidDoubleInput(scanner);
            boolean edited = studentList.editStudentById(editId, editName, editMarks);
            if (edited) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (Exception e) {
            System.out.println("Error in editing student: " + e.getMessage());
        }
    }
}
