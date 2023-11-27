package edu.sjsu.cs;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import edu.sjsu.cs.Store_Properties.Store;
import edu.sjsu.cs.User.Customer;
import edu.sjsu.cs.User.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustomerCartPageController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Store store;
    private Customer customer;
    private double totalPrice = 0;


    @FXML
    private FlowPane itemDisplayArea;

    @FXML
    private HBox totalPriceBox;

    @FXML
    private Label priceLabel;
    // TODO: Implement your code here

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        this.customer = Main.getCustomer();
        displayItem(customer);
    }

    public void displayTotalPrice(){
        tallyTotalPrice();
        priceLabel.setText(totalPrice + " $");
    }

    public void tallyTotalPrice(){
        totalPrice = 0;
        for (Node node: itemDisplayArea.getChildren()){
            if (node instanceof AnchorPane) {
                totalPrice += ((cartProductCard)node).getPrice();
            }
        }
        
    }

    public void displayItem(Customer customer){
        List<AnchorPane> items = new ArrayList<>();
        for(Product product: customer.getCart()){
            items.add(new cartProductCard(product.getName(), product.getPrice(), new ImageView(), product.getProductId(), product.getQuantity()));
        }
        FlowPane flowPane = itemDisplayArea;

        flowPane.getChildren().clear();
        totalPrice = 0;

        for (AnchorPane item : items) {
            flowPane.getChildren().add(item); 
        }


        displayTotalPrice();
    }

    public void switchToCheckout(){
        try{
            root = FXMLLoader.load(getClass().getResource("CustomerCheckoutPage.fxml"));
            stage = (Stage)totalPriceBox.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
            System.out.println("Error switching to customer checkout page");
        }
    }

    class cartProductCard extends AnchorPane {
        private double productPrice;
        // private int quantity = 1;

        public void setPrice(double price) {
            this.productPrice = price;
        }

        public double getPrice() {
            return productPrice;
        }

        // public void setQuantity(int quantity) {
        //     this.quantity = quantity;
        // }

        // public int getQuantity() {
        //     return quantity;
        // }


        public cartProductCard(String name, double price, ImageView image, String id, int quantity) {
            
            this.setPrefSize(200, 200);
            this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            Label productName = new Label();
            productName.setText(name + " - " + Double.toString(price) + " $");
            
            // Label productPrice = new Label();
            // productPrice.setText(Double.toString(price));
            Button deleteFromCart = new Button("Delete");
            deleteFromCart.setOnAction(new EventHandler<ActionEvent>() {
                
                @Override
                public void handle(ActionEvent event){
                    Main.getCustomer().cart.remove(Main.getStore().getProducts().get(id));
                    displayItem(Main.getCustomer());
                    System.out.println("Product " + name + " deleted from cart");
                }
            });

            TextField quantityField = new TextField();
            quantityField.setPromptText("Enter quantity");
            quantityField.setPrefWidth(100);
            quantityField.setText(Integer.toString(quantity));

            // Add a ChangeListener to the TextField
            quantityField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // This code will be executed whenever the text of the TextField changes
                System.out.println("Quantity changed from " + oldValue + " to " + newValue);
                if(!newValue.isEmpty()){
                    productPrice = price * Integer.parseInt(newValue);
                    displayTotalPrice();
                }
            }
            });


            HBox bottomHBox = new HBox();
            bottomHBox.getChildren().add(deleteFromCart);
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
            // productBorder.setBottom(productPrice);

            this.productPrice = quantityField.getText().isEmpty() ? price : price * Integer.parseInt(quantityField.getText());
            this.getChildren().add(productBorder);
        
        }
}
}


