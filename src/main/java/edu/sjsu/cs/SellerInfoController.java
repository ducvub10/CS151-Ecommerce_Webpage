package edu.sjsu.cs;

import edu.sjsu.cs.User.Seller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SellerInfoController {
    @FXML
    private Label user_name;

    @FXML
    private Label password;

    @FXML
    private Label email;

    @FXML
    private Label companyName;

    @FXML
    private Label companyAddress;

    @FXML
    private Label phone;

    public void setData(Seller seller) {
        user_name.setText(seller.getUsername());
        password.setText(seller.getPassword());
        email.setText(seller.getEmail());
        companyName.setText(seller.getCompanyName());
        companyAddress.setText(seller.getCompanyAddress());
        phone.setText(seller.getPhone());
    }
}
