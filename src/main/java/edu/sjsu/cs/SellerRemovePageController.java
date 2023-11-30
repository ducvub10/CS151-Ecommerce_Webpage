package edu.sjsu.cs;

import java.io.IOException;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.*;

import edu.sjsu.cs.Store_Properties.Store;
import edu.sjsu.cs.User.Product;
import edu.sjsu.cs.User.Seller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SellerRemovePageController implements Initializable{


    private Store store;
    private Seller seller;
    private Stage stage;
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Button returnButton,removeButton ;
    //@FXML
   // private ListView<String> listOfProducts;
    @FXML
    Label removeText;
    @FXML
    private FlowPane itemDisplayArea;

    private void displayItem(Seller Seller){
        List<AnchorPane> sellerItems = new ArrayList<>();
        for(Product product: Seller.getSellerItems()){
            sellerItems.add(new SellerRemoveProductCard(product.getName(), product.getPrice(), new ImageView(), product.getProductId(), product.getQuantity()));
        }
        FlowPane display = itemDisplayArea;

        display.getChildren().clear();

        for (AnchorPane sellerItem : sellerItems) {
            display.getChildren().add(sellerItem);
        }
    }

    public void clickReturn()throws IOException{
        root = FXMLLoader.load(getClass().getResource("SellerMainPage.fxml"));

        stage = (Stage) returnButton.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void initialize(URL location, ResourceBundle resources) {

        //this.store = Main.getStore();
        this.seller = Main.getSeller();

        //choiceBox.getItems().addAll((Collection<? extends String>) products);
        //listOfProducts = (ListView<String>) Main.getStore().getProducts();
        displayItem(seller);

    }

    class SellerRemoveProductCard extends AnchorPane {
        private double productPrice;
        public void setPrice(double price) {
            this.productPrice = price;
        }

        public double getPrice() {
            return productPrice;
        }



        public SellerRemoveProductCard(String name, double price, ImageView image, String id, int quantity) {

            this.setPrefSize(200, 200);
            this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            Label productName = new Label();
            productName.setText(name + " - " + Double.toString(price) + " $");

            Button deleteFromSeller = new Button("Remove");
            deleteFromSeller.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event){
                    Main.getSeller().sellerItems.remove(Main.getStore().getProducts().get(id));
                    displayItem(Main.getSeller());
                    System.out.println("Product " + name + " deleted from store");
                }
            });

            TextField quantityField = new TextField();
            quantityField.setPromptText("Enter quantity");
            quantityField.setPrefWidth(100);
            quantityField.setText(Integer.toString(quantity));

            quantityField.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    // This code will be executed whenever the text of the TextField changes
                    System.out.println("Quantity changed from " + oldValue + " to " + newValue);
                }
            });



            HBox bottomHBox = new HBox();
            bottomHBox.getChildren().add(deleteFromSeller);
            bottomHBox.getChildren().add(quantityField);

            ImageView productImage = new ImageView();
            productImage.setFitHeight(150);
            productImage.setFitWidth(200);
            productImage.setPreserveRatio(true);
            productImage.setImage(new javafx.scene.image.Image(getClass().getResource("img/emart_logo.jpg").toExternalForm()));

            BorderPane productBorder = new BorderPane();
            productBorder.setPrefSize(200, 200);
            AnchorPane.setTopAnchor(productBorder, 0.0);
            AnchorPane.setLeftAnchor(productBorder, 0.0);
            productBorder.setCenter(productImage);
            productBorder.setTop(productName);
            productBorder.setBottom(bottomHBox);

            this.productPrice = quantityField.getText().isEmpty() ? price : price * Integer.parseInt(quantityField.getText());
            this.getChildren().add(productBorder);

        }
    }


}



