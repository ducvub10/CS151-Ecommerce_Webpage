package edu.sjsu.cs;

import edu.sjsu.cs.User.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CusInfoController extends AdminMainPageController implements Initializable {
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
    private Customer customer;

    public void setData(Customer customer) {
        this.customer = customer;
        user_name.setText(customer.getUsername());
        password.setText(customer.getPassword());
        email.setText(customer.getEmail());
        address.setText(customer.getAddress());
        phone.setText(customer.getPhone());
    }

    public void deleteCustomer(ActionEvent event) throws IOException {
        String username = customer.getUsername();
        Optional<ButtonType> result = showAlert("Confirmation", "Are you sure you want to delete this customer?");

        if (result.isPresent() && result.get() == ButtonType.OK) {
            customers.removeIf(customer -> customer.getUsername().equals(username));
            switchToAdminMainPage(event);
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
    }
}
