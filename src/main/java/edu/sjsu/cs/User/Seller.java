package edu.sjsu.cs.User;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User {
    private String companyName;
    private String companyAddress;
    public List<Product> sellerItems;

    public Seller(String username, String password, String email, String phone, String companyName, String companyAddress) {
        super(username, password, email, phone);
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        sellerItems = new ArrayList<>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public List<Product> getSellerItems(){return sellerItems;}

    public void setSellerItems(List<Product> sellerItems){this.sellerItems = sellerItems; };

    
    

    @Override
    public void viewProfile() {
        //TODO
    
    }
    
}
    

