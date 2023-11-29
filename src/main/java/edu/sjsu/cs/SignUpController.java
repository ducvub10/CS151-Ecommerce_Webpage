package edu.sjsu.cs;

import edu.sjsu.cs.User.Admin;
import edu.sjsu.cs.User.Customer;
import edu.sjsu.cs.User.Seller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SignUpController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<String> userIdentity;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField companyAddressField;
    @FXML
    private TextField companyNameField;
    protected static List<Customer> customers = new ArrayList();
    protected static List<Seller> sellers = new ArrayList();

    public void initialize(URL url, ResourceBundle rb) {
        this.loadData();
    }

    private void loadData() {
        this.list.removeAll(this.list);
        this.list.addAll(new Object[]{"Customer", "Seller"});
        this.userIdentity.getItems().addAll(this.list);
    }

    @FXML
    private void choiceAction(ActionEvent event) {
        String userIden = (String)this.userIdentity.getValue();
        if (userIden.equals("Customer")) {
            this.addressField.setVisible(true);
            this.companyAddressField.setVisible(false);
            this.companyNameField.setVisible(false);
        } else if (userIden.equals("Seller")) {
            this.addressField.setVisible(false);
            this.companyAddressField.setVisible(true);
            this.companyNameField.setVisible(true);
        }

    }

    public void createAccount() {
        String username = this.usernameField.getText();
        String phone = this.phoneField.getText();
        String email = this.emailField.getText();
        String password = this.passwordField.getText();
        String address = this.addressField.getText();
        String companyName = this.companyNameField.getText();
        String companyAddress = this.companyAddressField.getText();

        try {
            this.validatePassword(password);
            String userIden = (String)this.userIdentity.getValue();
            Boolean isCusExist = false;
            Boolean isSellerExist = false;
            if (userIden.equals("Customer")) {
                for (Customer customer: customers) {
                    if (username.equals(customer.getUsername())) {
                        showError("The username is already existed");
                        isCusExist = true;
                        break;
                    }
                }
                if (!isCusExist) {
                    Customer customer1 = new Customer(username, password, email, address, phone);
                    customers.add(customer1);
                    this.showSuccess();
                }
            } else if (userIden.equals("Seller")) {
                for (Seller seller: sellers) {
                    if (username.equals(seller.getUsername())) {
                        showError("The username is already existed");
                        isSellerExist = true;
                        break;
                    }
                }
                if (!isSellerExist) {
                    Seller seller1 = new Seller(username, password, email, phone, companyName, companyAddress);
                    sellers.add(seller1);
                    this.showSuccess();
                }
            }
        } catch (PasswordException e) {
            this.showError(e.getMessage());
        }

    }

    public void validatePassword(String password) throws PasswordException {
        boolean containUpperCase = false;
        boolean containLowerCase = false;
        boolean containDigit = false;
        boolean containSpecialCharacter = false;
        if (password.length() < 8) {
            throw new Minimum8CharactersRequired("Password is less than 8 characters");
        } else {
            for(int i = 0; i < password.length(); ++i) {
                if (Character.isUpperCase(password.charAt(i))) {
                    containUpperCase = true;
                }

                if (Character.isLowerCase(password.charAt(i))) {
                    containLowerCase = true;
                }

                if (Character.isDigit(password.charAt(i))) {
                    containDigit = true;
                }

                if (!Character.isDigit(password.charAt(i)) && !Character.isLetter(password.charAt(i)) && !Character.isWhitespace(password.charAt(i))) {
                    containSpecialCharacter = true;
                }
            }

            if (!containUpperCase) {
                throw new UpperCaseCharacterMissing("Password must contain at least one uppercase character");
            } else if (!containLowerCase) {
                throw new LowerCaseCharacterMissing("Password must contain at least one lowercase character");
            } else if (!containDigit) {
                throw new NumberCharacterMissing("Password must contain at least one number character");
            } else if (!containSpecialCharacter) {
                throw new SpecialCharacterMissing("Password must contain at least one special character");
            }
        }
    }

    protected void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Something error!!!");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccess() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Create account successful");
        alert.setContentText("Account is created");
        alert.showAndWait();
    }

    public void switchWelcomePage(ActionEvent event) throws IOException {
        this.root = (Parent)FXMLLoader.load(this.getClass().getResource("WelcomePage.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }


}
