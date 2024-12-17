public class Student extends Person{
    private String grade; 

    public Student(String name, int id, String grade) {
        super(name, id); 
        this.grade = grade;
    }

    // Getter 和 Setter
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
