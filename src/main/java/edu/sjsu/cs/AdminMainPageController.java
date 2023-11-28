package edu.sjsu.cs;

import edu.sjsu.cs.User.Customer;
import edu.sjsu.cs.User.Seller;
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

    @FXML
    private GridPane sellerInfo;

    public void initialize(URL location, ResourceBundle resources) {
        int column = 0;
        int row = 1;
        int column1 = sellerInfo.getColumnCount();
        int row1 = sellerInfo.getRowCount();
        try {
            for (Customer customer: customers){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("CusInfo.fxml"));
                VBox infoBox = fxmlLoader.load();
                CusInfoController cusInfoController = fxmlLoader.getController();
                cusInfoController.setData(customer);

                if (column == 3) {
                    column = 0;
                    ++row;

                }
                customerInfo.add(infoBox, column++, row);
                GridPane.setMargin(infoBox, new Insets(10));
            }

            for (Seller seller: sellers){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("SellerInfo.fxml"));
                VBox in4Box = fxmlLoader.load();
                SellerInfoController sellerInfoController = fxmlLoader.getController();
                sellerInfoController.setData(seller);

                if (column1 == 2) {
                    column1 = 0;
                    row1++;

                }

                sellerInfo.add(in4Box, column1++, row1);
                GridPane.setMargin(in4Box, new Insets(40));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
