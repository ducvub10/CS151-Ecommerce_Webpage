package edu.sjsu.cs;

import edu.sjsu.cs.User.Admin;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AdminInfoController {
    @FXML
    private Label user_name;

    @FXML
    private Label password;

    @FXML
    private Label email;

    @FXML
    private Label position;

    @FXML
    private Label phone;

    public void setData(Admin admin) {
        user_name.setText(admin.getUsername());
        password.setText(admin.getPassword());
        email.setText(admin.getEmail());
        position.setText(admin.getPosition());
        phone.setText(admin.getPhone());
    }
}
