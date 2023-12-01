package edu.sjsu.cs;

import edu.sjsu.cs.User.Admin;
import edu.sjsu.cs.User.Customer;
import edu.sjsu.cs.User.Seller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static edu.sjsu.cs.AdminLoginController.usernamee;
import static edu.sjsu.cs.WelcomePageController.admins;

public class AdminMainPageController extends SignUpController implements Initializable {
    @FXML
    private GridPane customerInfo;

    @FXML
    private GridPane sellerInfo;

    @FXML
    private GridPane adminInfo;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label label;


    public void initialize(URL location, ResourceBundle resources) {
        int column = 0;
        int row = 1;
        int column1 = sellerInfo.getColumnCount();
        int row1 = sellerInfo.getRowCount();
        try {
            for (Customer customer: customers){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("CusInfo.fxml"));
                VBox infoBox = fxmlLoader.load();
                CusInfoController cusInfoController = fxmlLoader.getController();
                cusInfoController.setData(customer);

                if (column == 3) {
                    column = 0;
                    ++row;

                }
                customerInfo.add(infoBox, column++, row);
                GridPane.setMargin(infoBox, new Insets(0,10,15,10));
            }

            for (Seller seller: sellers){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("SellerInfo.fxml"));
                VBox in4Box = fxmlLoader.load();
                SellerInfoController sellerInfoController = fxmlLoader.getController();
                sellerInfoController.setData(seller);

                if (column1 == 2) {
                    column1 = 0;
                    row1++;
                }

                sellerInfo.add(in4Box, column1++, row1);
                GridPane.setMargin(in4Box, new Insets(-10,40,20,40));
            }

            for (Admin admin: admins){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("AdminInfo.fxml"));
                VBox inforBox = fxmlLoader.load();
                AdminInfoController adminInfoController = fxmlLoader.getController();
                adminInfoController.setData(admin);

                adminInfo.add(inforBox, column++, 1);
                GridPane.setMargin(inforBox, new Insets(-10,10,0,10));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        label.setText(usernamee);
    }

    public void switchToAdminMainPage(ActionEvent event) throws IOException {
        this.root = (Parent) FXMLLoader.load(this.getClass().getResource("AdminMainPage.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToWelcomePage(ActionEvent event) throws IOException {
        this.root = (Parent) FXMLLoader.load(this.getClass().getResource("WelcomePage.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public Optional<ButtonType> showAlert(String title, String contentText) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        return alert.showAndWait();
    }
}
