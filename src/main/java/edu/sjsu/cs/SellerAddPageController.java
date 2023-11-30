package edu.sjsu.cs;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.sjsu.cs.User.Customer;
import edu.sjsu.cs.User.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import edu.sjsu.cs.Store_Properties.Store;
import edu.sjsu.cs.User.Seller;
import edu.sjsu.cs.User.Product;
import javafx.stage.Stage;


public class SellerAddPageController implements Initializable {

    @FXML
    private Label addText;

    @FXML
    private Button addButton;

    @FXML
    private TextArea description;

    @FXML
    private TextField itemName, itemID;

    @FXML
    private TextField itemPrice;

    @FXML
    private Button returnButton;
    @FXML
    private String url;
    private Product product;
    private Store store;
    private Seller seller;
    @FXML
    private Stage stage;
    private Scene scene;
    @FXML
    private Parent root;

    public void clickAdd(){
        String id = itemID.getText();
        String name = itemName.getText();
        String priceText = itemPrice.getText();
        double price = Double.parseDouble(priceText);
        Product item = new Product(id, name, price);
        Main.getStore().addProduct(item);
        addText.setText("Item has been added");
    }

    public void clickReturn()throws IOException{
        root = FXMLLoader.load(getClass().getResource("SellerMainPage.fxml"));

        stage = (Stage) returnButton.getScene().getWindow();
        stage.setScene(new Scene(root));
    }



    public void initialize(URL location, ResourceBundle resources) {
        this.store = Main.getStore();
        this.seller = Main.getSeller();
    }

}
