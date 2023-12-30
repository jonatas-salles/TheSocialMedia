package dev.salles.model.entities;

public class User {
    private String username;
    private String fullname;
    private String birthdate;
    private String gender;

    public User() {
    }

    public User(String username, String fullname, String birthdate, String gender) {
        this.username = username;
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
