package models;

public class User {
    private int id;
    private String name;
    private String surname;

    public User() {}

    public User(int id, String name, String surname) {
        setId(id);
        setName(name);
        setSurname(surname);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname;
    }
}
