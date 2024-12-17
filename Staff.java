public class Staff extends Person{
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
