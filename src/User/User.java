package User;

public abstract class User implements UserInterface{
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String phone;

    public User(String firstName, String lastName, String username, String password, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
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

    public String getPhoneNumber() {
        return phone;
    }

    public String getAddress() {
        return null;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public void setPhoneNumber(String phone) {
        this.phone = phone;
    }


    public void setAddress(String address) {

    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    
    public void logout() {
        System.out.println("User logged out.");
    }

    
    public void viewProfile() {
        System.out.println("Username: " + getUsername());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhoneNumber());
    }

    
    public void editProfile(String firstName, String lastName, String username, String password, String email, String phone) {
        setFirstName(firstName);
        setLastName(lastName);
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setPhoneNumber(phone);
    }
}
    

