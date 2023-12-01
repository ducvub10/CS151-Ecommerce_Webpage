package edu.sjsu.cs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import edu.sjsu.cs.Store_Properties.Store;
import edu.sjsu.cs.User.Customer;
import edu.sjsu.cs.User.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;




public class CustomerOrderHistoryCotroller implements Initializable {
    private Store store;
    private Customer customer;
    @FXML 
    private Pane orderPane;

    @FXML
    private ChoiceBox<String> myChoiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*Insert table into orderPane */
        customer = Main.getSession().getCurrentCustomer();
        TableView<Order> table = new TableView<>();

        // Create columns
        TableColumn<Order, String> orderIdColumn = new TableColumn<>("Order ID");
        TableColumn<Order, String> productsColumn = new TableColumn<>("Products");
        TableColumn<Order, Double> totalColumn = new TableColumn<>("Total Price");

        // Bind columns to properties of Order
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        productsColumn.setCellFactory(column -> new TableCell<Order, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    Order order = getTableView().getItems().get(getIndex());
                    String products = order.getProducts().stream()
                        .map(product -> product.getName() + " (" + product.getQuantity() + ")")
                        .collect(Collectors.joining(", "));
                    setText(products);
                }
            }
        });
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        // Add columns to table
        table.getColumns().add(orderIdColumn);
        table.getColumns().add(productsColumn);
        table.getColumns().add(totalColumn);

        // Add data to table
        ObservableList<Order> data = FXCollections.observableArrayList(/* your data here */);
        for (Order order : customer.getOrderHistory()) {
            data.add(order);
        }
        table.setItems(data);

        orderPane.getChildren().add(table);
        /* */

        /*Set up choice box */
        String[] profileSelection = {"Profile", "Cart", "Order History", "Sign Out"};
        myChoiceBox.getItems().addAll(profileSelection);
        myChoiceBox.setValue(customer.getUsername());
        myChoiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String selected = myChoiceBox.getValue();
                if(selected.equals("Cart")){
                    try{
                        PageSwitcher.switchToCustomerCartPage(event);
                    }
                    catch(IOException e){
                        System.out.println("Error switching to customer cart page");
                    }
                }

                if(selected.equals("Profile")){
                    try{
                        PageSwitcher.switchToCustomerProfilePage(event);
                    }
                    catch(IOException e){
                        System.out.println("Error switching to customer profile page");
                    }
                }

                if(selected.equals("Order History")){
                    try{
                        PageSwitcher.switchToOrderHistoryPage(event);
                    }
                    catch(IOException e){
                        System.out.println("Error switching to customer order history page");
                    }
                }

                
            }
        });
        /* */
    }
}



