package edu.sjsu.cs;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import edu.sjsu.cs.Store_Properties.Store;
import edu.sjsu.cs.User.Customer;
import edu.sjsu.cs.User.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class CustomerMainPageController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Store store;
    private Customer customer;
    
    @FXML
    private FlowPane itemDisplayArea;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.store = Main.getStore();
        this.customer = Main.getCustomer();
        displayItem(this.store);

    }

    private void displayItem(Store customer){
        List<AnchorPane> items = new ArrayList<>();
        for(Product product: store.getProducts().values()){
            items.add(new productCard(product.getName(), product.getPrice(), new ImageView(), product.getProductId()));
        }
        FlowPane flowPane = itemDisplayArea;

        for (AnchorPane item : items) {
            flowPane.getChildren().add(item);
        }
    }
}

class productCard extends AnchorPane {
    public productCard(String name, double price, ImageView image, String id) {
        
        this.setPrefSize(200, 200);
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        Label productName = new Label();
        productName.setText(name + " - " + Double.toString(price) + " $");
        
        // Label productPrice = new Label();
        // productPrice.setText(Double.toString(price));
        Button addToCart = new Button("Add to cart");
        addToCart.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event){
                Main.getCustomer().cart.add(Main.getStore().getProducts().get(id));
            }
        });


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
        productBorder.setBottom(addToCart);
        // productBorder.setBottom(productPrice);

 
        this.getChildren().add(productBorder);
    
    }
}

