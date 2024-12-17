import java.util.ArrayList;
import java.util.Scanner;

class Person {
    private String name;
    private int id;
    private boolean isPresent;

    public Person(String name, int id2) {
            this.name = name;
            this.id = id2;
        this.isPresent = false; 
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Is Present: " + (isPresent ? "Yes" : "No");
    }
}

class Student extends Person {
    private int gradeLevel;

    public Student(String name, int id, int gradeLevel) {
            super(name, id);
        this.gradeLevel = gradeLevel;
    }

    @Override
    public String toString() {
        return super.toString() + ", Grade Level: " + gradeLevel;
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int id, String subject) {
        super(name, id);
        this.subject = subject;
    }
    public void takeAttendance(ArrayList<Person> people) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Taking attendance for students:");

            for (Person person : people) {
                if (person instanceof Student) { 
                    System.out.print("Is " + person.getName() + " present? (1 for Yes, 0 for No): ");
                    int response = scanner.nextInt();
                    person.setIsPresent(response == 1); 
                }
            }
        }
        System.out.println("Attendance updated by Teacher: " + getName());
    }

    @Override
    public String toString() {
        return super.toString() + ", Subject: " + subject;
    }
    
       
    }
    
    class Staff extends Person {
        private String role;
    
        public Staff(String name, int id, String role) {
            super(name, id);
            this.role = role;
        }
    
        @Override
        public String toString() {
            return super.toString() + ", Role: " + role;
        }
    }
    
    class MaintenanceWorker extends Person {
        private String workArea; 
    
        public MaintenanceWorker(String name, int id, String workArea) {
            super(name, id); 
            this.workArea = workArea;
        }
    
        public String getWorkArea() {
            return workArea;
        }
    
        public void setWorkArea(String workArea) {
            this.workArea = workArea;
        }
    
        @Override
        public String toString() {
            return super.toString() + " - Work Area: " + workArea;
        }
    }
    
    public class AttendanceSystem {
        private static ArrayList<Person> records = new ArrayList<>();
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;
    
            while (running) {
                System.out.println("\n--- Attendance System ---");
                System.out.println("1. Add Person");
                System.out.println("2. Remove Person");
                System.out.println("3. Update Attendance");
                System.out.println("4. View Attendance");
                System.out.println("5. Teacher Take Attendance");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
    
                int choice = scanner.nextInt();
                scanner.nextLine(); 
    
                switch (choice) {
                    case 1 -> addPerson(scanner);
                    case 2 -> removePerson(scanner);
                    case 3 -> updateAttendance(scanner);
                    case 4 -> viewAttendance(records);
                    case 5 -> teacherTakeAttendance(scanner);
                    case 6 -> running = false;
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
            scanner.close();
        }
    
        private static void addPerson(Scanner scanner) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            System.out.println("Choose type: 1. Student 2. Teacher 3. Staff 4. MaintenanceWorker");
            int type = scanner.nextInt();
            scanner.nextLine(); 
    
            switch (type) {
                case 1 -> {
                    System.out.print("Enter grade level: ");
                    int gradeLevel = scanner.nextInt();
                    records.add(new Student(name, id, gradeLevel));
                }
                case 2 -> {
                    System.out.print("Enter subject: ");
                    String subject = scanner.nextLine();
                    records.add(new Teacher(name, id, subject));
                }
                case 3 -> {
                    System.out.print("Enter role: ");
                    String role = scanner.nextLine();
                    records.add(new Staff(name, id, role));
                }
                case 4 -> {
                    System.out.print("Enter workArea: ");
                    String workArea = scanner.nextLine();
                    records.add(new MaintenanceWorker(name, id, workArea));
                }
                default -> System.out.println("Invalid type.");
            }
        }
    
        private static void removePerson(Scanner scanner) {
            System.out.print("Enter ID to remove: ");
            int id = scanner.nextInt();
            records.removeIf(person -> person.getId() == id);
        }
    
        private static void updateAttendance(Scanner scanner) {
            System.out.print("Enter ID to update: ");
            int id = scanner.nextInt();
            System.out.print("Is the person present? (true/false): ");
            boolean isPresent = scanner.nextBoolean();
    
            for (Person person : records) {
                if (person.getId() == id) {
                    person.setIsPresent(isPresent);
                    break;
                }
            }
        }
        public static void viewAttendance(ArrayList<Person> people) {
            if (people.isEmpty()) {
                System.out.println("No records found. The list is empty.");
            } else {
                System.out.println("Attendance Records:");
                for (Person person : people) {
                    System.out.println(person);
                }
            }
        }
        private static void teacherTakeAttendance(Scanner scanner) {
            System.out.print("Enter Teacher ID to take attendance: ");
            int teacherId = scanner.nextInt();
            scanner.nextLine(); 
        
            boolean teacherFound = false;
        
            for (Person person : records) {
                if (person instanceof Teacher && person.getId() == teacherId) {
                    teacherFound = true;
                    Teacher teacher = (Teacher) person; 
                    System.out.println("Taking attendance for students:");
        
                    for (Person p : records) {
                        if (p instanceof Student) { 
                            System.out.print("Is " + p.getName() + " present? (1 for Yes, 0 for No): ");
                            int attendance = scanner.nextInt();
                            scanner.nextLine(); 
        
                            ((Student) p).setIsPresent(attendance == 1);
                        }
                    }
        
                    System.out.println("Attendance updated by Teacher: " + teacher.getName());
                    break; 
                }
            }
        
    
        if (!teacherFound) {
            System.out.println("No teacher found with ID: " + teacherId);
        }
    }
}