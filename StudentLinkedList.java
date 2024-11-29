class StudentLinkedList {
    private Node head;

    public void sortStudentsByName() {
        // Implement sorting by name logic here if needed
    }

    public void displayComparisonTable() {
        System.out.printf("%-10s %-20s %-10s %-15s%n", "ID", "Name", "Marks", "Rank");
        System.out.println("-------------------------------------------------------------");
        Node current = head;
        while (current != null) {
            Student student = current.student;
            System.out.printf("%-10d %-20s %-10.2f %-15s%n",
                    student.getId(),
                    student.getName(),
                    student.getMarks(),
                    student.getRank());
            current = current.next;
        }
    }

    private static class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    public void addFirst(Student student) {
        Node newNode = new Node(student);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void deleteFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void deleteLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
    }

    public void displayList() {
        Node current = head;
        while (current != null) {
            current.student.displayStudent();
            current = current.next;
        }
    }

    public Student searchById(int id) {
        Node current = head;
        while (current != null) {
            if (current.student.getId() == id) {
                return current.student;
            }
            current = current.next;
        }
        return null;
    }

    public boolean editStudentById(int id, String newName, double newMarks) {
        Node current = head;
        while (current != null) {
            if (current.student.getId() == id) {
                current.student.setName(newName);
                current.student.setMarks(newMarks);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Sort students by marks in ascending order
    public void sortStudentsByMarks() {
        if (head == null || head.next == null) return;

        for (Node i = head; i.next != null; i = i.next) {
            for (Node j = head; j.next != null; j = j.next) {
                if (j.student.getMarks() > j.next.student.getMarks()) {
                    Student temp = j.student;
                    j.student = j.next.student;
                    j.next.student = temp;
                }
            }
        }
    }

    // Sort students by marks in descending order
    public void sortStudentsByMarksDescending() {
        if (head == null || head.next == null) return;

        for (Node i = head; i.next != null; i = i.next) {
            for (Node j = head; j.next != null; j = j.next) {
                if (j.student.getMarks() < j.next.student.getMarks()) {
                    Student temp = j.student;
                    j.student = j.next.student;
                    j.next.student = temp;
                }
            }
        }
    }
}
