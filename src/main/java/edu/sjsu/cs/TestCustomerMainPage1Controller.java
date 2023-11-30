package edu.sjsu.cs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.sjsu.cs.User.Product;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TestCustomerMainPage1Controller implements Initializable {
    @FXML
    ScrollPane baseScrollPane;

    

    @FXML
    AnchorPane baseAnchorPane;

    @FXML
    ChoiceBox<String> searchChoiceBox;

    @FXML
    TextField searchField;

    @FXML
    HBox signInHBox;

    @FXML
    HBox myCartHBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    //ToCart
    HBox hbox = myCartHBox;
    hbox.setOnMouseClicked(event -> {
    try {
        PageSwitcher.switchToCustomerCartPage(event);
    } catch (IOException e) {
        
        e.printStackTrace();
    }
    });
    
    //ToSignIn
    HBox hbox1 = signInHBox;
    hbox1.setOnMouseClicked(event -> {
        try {
            PageSwitcher.switchToWelcomePage(event);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        });

    // Search Box
    searchChoiceBox.setValue("All Categories");
    
    // Create a new GridPane
    GridPane gridPane = new GridPane();

    // Set properties on the GridPane
    gridPane.setHgap(20); // Horizontal gap
    gridPane.setVgap(20); // Vertical gap

    // Set the preferred width and height
    gridPane.setPrefWidth(1090); // Replace with your desired width
    GridPane.setVgrow(gridPane, Priority.ALWAYS);

    // Add the GridPane to the AnchorPane
    baseAnchorPane.getChildren().add(gridPane);
    AnchorPane.setTopAnchor(gridPane, 130.0);
    AnchorPane.setRightAnchor(gridPane, 30.0);
    AnchorPane.setLeftAnchor(gridPane, 30.0);
    // AnchorPane.setBottomAnchor(gridPane, 30.0);
    // Get the height property of the GridPane
    ReadOnlyDoubleProperty gridPaneHeight = gridPane.heightProperty();

    // Create a binding that adds 130 to the height property of the AnchorPane
    NumberBinding newGridPaneHeight = Bindings.add(gridPaneHeight, 160);
// Bind the height property of the AnchorPane to the height property of the GridPane
    baseAnchorPane.prefHeightProperty().bind(newGridPaneHeight);

    int columnIndex = 0;
    int rowIndex = 0;

    for(Product prod: Main.getStore().getProducts().values()) {
        if (columnIndex == 3) {
            columnIndex = 0;
            rowIndex++;
        }
        try {
        // Create a new FXMLLoader and set the location of the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductCard.fxml"));

        // Load the VBox from the FXML file
        VBox productCard = loader.load();

        // Get the ProductCardController instance
        ProductCardController controller = loader.getController();

        // Set the FXML variables
        // controller.setProductImg(prod.getImage());
        controller.setProduct(prod);

        // Add the VBox to the GridPane
        gridPane.add(productCard, columnIndex, rowIndex); // Replace columnIndex and rowIndex with the desired position
        columnIndex++;    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}


