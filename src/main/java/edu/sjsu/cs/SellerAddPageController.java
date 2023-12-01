package edu.sjsu.cs;

import edu.sjsu.cs.Store_Properties.Store;
import edu.sjsu.cs.User.Product;
import edu.sjsu.cs.User.Seller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SellerAddPageController implements Initializable {


    @FXML
    private ImageView itemImage;
    @FXML
    private Label addText;

    @FXML
    private Button addButton;

    @FXML
    private Button chooseImageButton;


    @FXML
    private TextField itemName, itemID, itemDescription;

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
        String description = itemDescription.getText();
        double price = Double.parseDouble(priceText);
        Image productImage = itemImage.getImage();
        Product item = new Product(id, name, price, description);
        item.setImage(productImage);
        Main.getStore().addProduct(item);
        addText.setText(name + " has been added");
        System.out.println(name + " has been added to the Store!");
    }

    public void clickReturn()throws IOException{
        root = FXMLLoader.load(getClass().getResource("SellerMainPage.fxml"));

        stage = (Stage) returnButton.getScene().getWindow();
        stage.setScene(new Scene(root));
    }



    public void initialize(URL location, ResourceBundle resources) {
        this.store = Main.getStore();
        chooseImageButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files (*.png, *.jpg, *.jpeg)", "*.png", "*.jpg", "*.jpeg");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(null);

            if (file != null) {
                Image image = new Image(file.toURI().toString());
                // Do something with the image
            }

            itemImage.setImage(new Image(file.toURI().toString()));
        }
    });
    }

}