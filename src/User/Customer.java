package User;

import Behaviors.AddProduct;
import Behaviors.RemoveProduct;

/**
 * Customer
 */
public class Customer extends User {
    private String address;
    private AddProduct addProduct;
    private RemoveProduct removeProduct;
    private EditProduct editProduct;

    public Customer(String firstName, String lastName, String username, String password, String email, String address, String phone) {
        super(firstName, lastName, username, password, email, phone);
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setAddProduct(AddProduct addProduct) {
        this.addProduct = addProduct;
    }

    public void addProduct(String productId) {
        addProduct.add(productId);
    }

    public void setRemoveProduct(RemoveProduct removeProduct){
        this.removeProduct = removeProduct;
    }
    public void removeProduct(String productId) {
        removeProduct.remove(productId);
    }


    @Override
    public void viewProfile() {
        System.out.println("Username: " + getUsername());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Address: " + getAddress());
        System.out.println("Products: " );

    }

}