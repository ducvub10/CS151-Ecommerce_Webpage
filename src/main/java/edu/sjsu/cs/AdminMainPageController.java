package edu.sjsu.cs;

import edu.sjsu.cs.User.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminMainPageController extends SignUpController implements Initializable {
    @FXML
    private GridPane customerInfo;

    public void initialize(URL location, ResourceBundle resources) {
        int column = 0;
        int row = 1;
        try {
            for (Customer value: customers){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("CusInfo.fxml"));
                VBox infoBox = fxmlLoader.load();
                CusInfoController cusInfoController = fxmlLoader.getController();
                cusInfoController.setData(value);

                if (column == 3) {
                    column = 0;
                    ++row;

                }
                customerInfo.add(infoBox, column++, row);
                GridPane.setMargin(infoBox, new Insets(10));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
