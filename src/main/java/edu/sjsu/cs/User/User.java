package edu.sjsu.cs.User;

public abstract class User  {
    private String username;
    private String password;
    private String email;
    private String phone;

    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    
    public void logout() {
        System.out.println("User logged out.");
    }

    
    public void viewProfile() {
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }

    
    public void editProfile(String username, String password, String email, String phone) {
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setPhone(phone);
    }
}
    

