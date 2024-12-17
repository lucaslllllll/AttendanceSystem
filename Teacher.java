import java.util.ArrayList;
import java.util.Scanner;

public class Teacher extends Person {
    private String subject;

    public Teacher(String name, int id, String subject) {
        super(name, id);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + ", Subject: " + subject;
    }

    public void takeAttendance(ArrayList<Person> records, Scanner scanner) {
        for (Person person : records) {
            if (person instanceof Student) { 
                System.out.print("Is " + person.getName() + " present? (1 for Yes, 0 for No): ");
                int attendance = scanner.nextInt();
                scanner.nextLine();  

                ((Student) person).setIsPresent(attendance == 1);
            }
        }
        System.out.println("Attendance taken by Teacher: " + this.getName());
    }
}