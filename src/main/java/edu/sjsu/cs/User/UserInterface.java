package edu.sjsu.cs.User;

public interface UserInterface {
    public String getUsername();
    public void setUsername(String username);
    public String getPassword();
    public void setPassword(String password);
    public String getEmail();
    public void setEmail(String email);
    public String getFirstName();
    public void setFirstName(String firstName);
    public String getLastName();
    public void setLastName(String lastName);
    public String getAddress();
    public void setAddress(String address);
    public String getPhoneNumber();
    public void setPhoneNumber(String phoneNumber);
    public boolean login(String username, String password);
    public void logout();
    public void viewProfile();
    public void editProfile();
}
