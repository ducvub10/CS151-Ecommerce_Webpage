package edu.sjsu.cs;

import edu.sjsu.cs.User.Seller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class SellerInfoController extends AdminMainPageController implements Initializable {
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

    private Seller seller;

    public void setData(Seller seller) {
        this.seller = seller;
        user_name.setText(seller.getUsername());
        password.setText(seller.getPassword());
        email.setText(seller.getEmail());
        companyName.setText(seller.getCompanyName());
        companyAddress.setText(seller.getCompanyAddress());
        phone.setText(seller.getPhone());
    }

    public void deleteSeller(ActionEvent event) throws IOException {
        String username = seller.getUsername();
        Optional<ButtonType> result = showAlert("Confirmation", "Are you sure you want to delete this seller?");

        if (result.isPresent() && result.get() == ButtonType.OK) {
            sellers.removeIf(seller -> seller.getUsername().equals(username));
            switchToAdminMainPage(event);
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
    }
}
