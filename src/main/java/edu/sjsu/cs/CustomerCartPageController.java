package edu.sjsu.cs;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import edu.sjsu.cs.Store_Properties.Store;
import edu.sjsu.cs.User.Customer;
import edu.sjsu.cs.User.Product;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class CustomerCartPageController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Store store;
    private Customer customer;

    @FXML
    private FlowPane itemDisplayArea;
    // TODO: Implement your code here

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        this.customer = Main.getCustomer();
        displayItem(customer);
    }

    private void displayItem(Customer customer){
        List<AnchorPane> items = new ArrayList<>();
        for(Product product: customer.getCart()){
            items.add(new productCard(product.getName(), product.getPrice(), new ImageView(), product.getProductId()));
        }
        FlowPane flowPane = itemDisplayArea;

        for (AnchorPane item : items) {
            flowPane.getChildren().add(item);
        }
    }


}
