package User;

import Behaviors.AddProduct;
import Behaviors.RemoveProduct;

public class Seller extends User{
    private String companyName;
    private String companyAddress;

    public Seller(String firstName, String lastName, String username, String password, String email, String phone, String companyName, String companyAddress) {
        super(firstName, lastName, username, password, email, phone);
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String getAddress() {
        return companyAddress;
    }
    @Override
    public void setAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    
    

    @Override
    public void viewProfile() {
        System.out.println("Username: " + getUsername());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Company: " + getCompanyName());
        System.out.println("Address: " + getAddress());
    }
    
}
    

