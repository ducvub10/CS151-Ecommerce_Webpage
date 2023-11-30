package edu.sjsu.cs.User;

public class Admin extends User{
    private String position;

    public Admin(String username, String password, String email, String phone, String position) {
        super(username, password, email, phone);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
