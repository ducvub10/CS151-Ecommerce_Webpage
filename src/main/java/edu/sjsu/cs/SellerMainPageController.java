package edu.sjsu.cs;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import edu.sjsu.cs.Store_Properties.Store;
import edu.sjsu.cs.User.Product;
import edu.sjsu.cs.User.Seller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class SellerMainPageController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private FlowPane itemDisplayArea;
    private Store store;
    private Seller seller;

    private String[] profileSelection = {"Remove", "Sign Out"};

    @FXML
    private ChoiceBox<String> sellerChoiceBox;


    public void clickRemove(ActionEvent event)throws IOException{
        root = FXMLLoader.load(getClass().getResource("SellerRemovePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void clickLogOut(ActionEvent event)throws IOException{
        root = FXMLLoader.load(getClass().getResource("SellerLoginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(URL location, ResourceBundle resources) {

        this.store = Main.getStore();
        this.seller = Main.getSeller();
        sellerChoiceBox.getItems().addAll(profileSelection);
        sellerChoiceBox.setValue(seller.getUsername());

        sellerChoiceBox.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String selected = sellerChoiceBox.getValue();
                if(selected.equals("Remove")){
                    try{
                        clickRemove(event);
                    }
                    catch(IOException e){
                        System.out.println("Error switching to seller remove page");
                    }
                }

                if(selected.equals("Sign Out")){
                    try{
                        clickLogOut(event);
                    }
                    catch(IOException e){
                        System.out.println("Error switching to customer profile page");
                    }
                }
            }

        });
        displayItem(this.store);
    }

    private void displayItem(Store seller){
        List<AnchorPane> sellerItem = new ArrayList<>();
        for(Product product: store.getProducts().values()){
            sellerItem.add(new sellerProductCard(product.getName(), product.getPrice(), new ImageView(), product.getProductId()));
        }
        FlowPane flowPane = itemDisplayArea;

        for (AnchorPane item : sellerItem) {
            flowPane.getChildren().add(item);
        }
    }


}



class sellerProductCard extends AnchorPane {
    public sellerProductCard(String name, double price, ImageView image, String id) {

        this.setPrefSize(200, 200);
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        Label productName = new Label();
        productName.setText(name + " - " + Double.toString(price) + " $");

        Button addMyStore = new Button("Add to My Store");
        addMyStore.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event){
                if (Main.getSeller().sellerItems.contains(Main.getStore().getProducts().get(id))){
                    Main.getSeller().sellerItems.get(Main.getSeller().sellerItems.indexOf(Main.getStore().getProducts().get(id))).setQuantity(Main.getSeller().sellerItems.get(Main.getSeller().sellerItems.indexOf(Main.getStore().getProducts().get(id))).getQuantity() + 1);
                    System.out.println("Product " + name + " increased quantity in Store");
                }
                else{
                    Main.getSeller().sellerItems.add(Main.getStore().getProducts().get(id));
                    Main.getSeller().sellerItems.get(Main.getSeller().sellerItems.indexOf(Main.getStore().getProducts().get(id))).setQuantity(1);
                    System.out.println("Product " + name + " added to Store");
                }
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
        productBorder.setBottom(addMyStore);

        this.getChildren().add(productBorder);

    }
}
