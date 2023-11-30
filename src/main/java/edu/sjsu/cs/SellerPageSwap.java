package edu.sjsu.cs;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SellerPageSwap {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public static void switchToSellerAddPage(Event event) throws IOException {
        switchPage(event, "SellerAddPage.fxml");
    }

    public static void switchToSellerRemovePage(Event event) throws IOException {
        switchPage(event, "SellerRemovePage.fxml");
    }

    public static void switchToSellerMainPage(Event event) throws IOException {
        switchPage(event, "SellerMainPage.fxml");
    }

    public static void switchToWelcomePage(Event event) throws IOException {
        switchPage(event, "WelcomePage.fxml");
    }

    private static void switchPage(Event event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(PageSwitcher.class.getResource(fxmlFile));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
