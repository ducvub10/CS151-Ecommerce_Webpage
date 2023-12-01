package edu.sjsu.cs;

import edu.sjsu.cs.Store_Properties.Store;
import edu.sjsu.cs.User.Seller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SellerMainPageController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private FlowPane itemDisplayArea;
    private Store store;
    private Seller seller;

    private String[] profileSelection = {"Add", "Remove", "Sign Out"};

    @FXML
    private ChoiceBox<String> sellerChoiceBox;



    public void clickAdd(ActionEvent event)throws IOException{
        root = FXMLLoader.load(getClass().getResource("SellerAddPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void clickRemove(ActionEvent event)throws IOException{
        root = FXMLLoader.load(getClass().getResource("SellerRemovePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void clickLogOut(ActionEvent event)throws IOException{
        root = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(URL location, ResourceBundle resources) {

        this.store = Main.getStore();
        sellerChoiceBox.getItems().addAll(profileSelection);

        sellerChoiceBox.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String selected = sellerChoiceBox.getValue();
                if(selected.equals("Add")){
                    try{
                        clickAdd(event);
                    }
                    catch(IOException e){
                        System.out.println("Error switching to seller add page");
                    }
                }

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
                        System.out.println("Error switching to log in page");
                    }
                }
            }

        });
    }



}

