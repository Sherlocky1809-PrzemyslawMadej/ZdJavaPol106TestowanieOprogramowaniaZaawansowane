package pl.sdacademy.unit.test.advance.exercises.task4;

public class User {

    private String name;
    private String surname;
    private String email;

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public boolean valid() {
        if (!this.validName()) {
            throw new IllegalArgumentException("Bad name");
        }
        if (!this.validSurname()) {
            throw new IllegalArgumentException("Bad surname");
        }
        if (!this.validEmail()) {
            throw new IllegalArgumentException("Bad e-mail");
        }
        return true;
    }

    private boolean validEmail() {
        return this.email.toLowerCase().matches("[a-z0-9+_.-]+@(.+)");
    }

    private boolean validSurname() {
        return this.surname.toLowerCase().matches("\\d+-\\d+");
    }

    private boolean validName() {
        return this.name.toLowerCase().matches("\\d+");
    }




}
