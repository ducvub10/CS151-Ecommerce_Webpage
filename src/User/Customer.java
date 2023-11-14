package User;

import Behaviors.AddProduct;

/**
 * Customer
 */
public class Customer extends User {
    private String address;
    private AddProduct addProduct;
    private RemoveProduct removeProduct;
    private EditProduct editProduct;

    public Customer(String username, String password, String email, String address, String phone) {
        super(username, password, email, phone);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setAddProduct(AddProduct addProduct) {
        this.addProduct = addProduct;
    }

    public void addProduct(String productId) {
        addProduct.add(productId);
    }

}