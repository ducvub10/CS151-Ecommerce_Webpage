package edu.sjsu.cs;


import edu.sjsu.cs.Store_Properties.Store;
import edu.sjsu.cs.User.Customer;
import edu.sjsu.cs.User.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
private static Store store = new Store("eMart");
private static Customer customer = new Customer ("customer", "password", "email", "address", "phoneNumber");

public static Customer getCustomer(){
    return customer;
}

public static Store getStore() {
    return store;
}

@Override
public void start(Stage stage) {
        //Make a customer
        //Add items to cart
        store.getProducts().put("1", new Product("1", "apple", 10.0));
        store.getProducts().put("2", new Product("2", "banana", 15.0));
        store.getProducts().put("3", new Product("3", "dragon fruit", 20.0));
        store.getProducts().put("4", new Product("4", "orange", 25.0));

    try {
        Parent root = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        
   
    } catch(Exception e) {
        e.printStackTrace();
    }
 } 

 public static void main(String[] args) {
  launch(args);
 }
}

// import javafx.scene.layout.BackgroundFill;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.CornerRadii;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.Label;
// import javafx.scene.image.ImageView;
// import javafx.scene.layout.AnchorPane;
// import javafx.scene.layout.Background;
// import javafx.scene.layout.FlowPane;
// import javafx.scene.layout.Pane;
// import javafx.scene.paint.Color;
// import javafx.stage.Stage;

// import java.util.ArrayList;
// import java.util.List;

// public class Main extends Application {

//     @Override
//     public void start(Stage stage) {
//         List<AnchorPane> items = new ArrayList<>();
//         items.add(new CustomAnchorPane());
//         FlowPane flowPane = new FlowPane();
//         flowPane.setPrefWidth(200);
//         flowPane.setMaxWidth(200);

//         for (AnchorPane item : items) {
//             flowPane.getChildren().add(item);
//         }

//         Scene scene = new Scene(flowPane, 400, 400);
//         stage.setScene(scene);
//         stage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }


