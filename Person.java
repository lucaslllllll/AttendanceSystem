public class Person {
    private String name;
    private String id;
    private boolean isPresent;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
        this.isPresent = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }


    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Present: " + isPresent;
    }
}
