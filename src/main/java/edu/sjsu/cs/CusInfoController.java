package edu.sjsu.cs;

import edu.sjsu.cs.User.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CusInfoController {
    @FXML
    private Label user_name;

    @FXML
    private Label password;

    @FXML
    private Label email;

    @FXML
    private Label address;

    @FXML
    private Label phone;

    public void setData(Customer customer) {
        user_name.setText(customer.getUsername());
        password.setText(customer.getPassword());
        email.setText(customer.getEmail());
        address.setText(customer.getAddress());
        phone.setText(customer.getPhone());
    }
}
