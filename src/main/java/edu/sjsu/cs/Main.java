package edu.sjsu.cs;


import edu.sjsu.cs.Behaviors.Session;
import edu.sjsu.cs.Store_Properties.Store;
import edu.sjsu.cs.User.Customer;
import edu.sjsu.cs.User.Order;
import edu.sjsu.cs.User.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
    static Store store = Store.getInstance("eMart");

    // Declare and initialize the singleton Session
    static Session session = Session.getInstance();
    


    public static Session getSession(){
        return session;
    }

    public static Store getStore() {
        return store;
    }

    @Override
    public void start(Stage stage) {
            //Make a customer
            session.setCurrentCustomer(new Customer ("customer", "password", "email", "address", "phoneNumber"));
            session.setCurrentOrder(null);
            //Add items to cart
            store.getProducts().put("1", new Product("1", "apple", 10.0, "fruit"));
            store.getProducts().put("2", new Product("2", "banana", 15.0, "fruit"));
            store.getProducts().put("3", new Product("3", "dragon fruit", 20.0, "fruit"));
            store.getProducts().put("4", new Product("4", "orange", 25.0, "fruit"));
            store.getProducts().put("5", new Product("5", "pineapple", 30.0, "fruit"));
            store.getProducts().put("6", new Product("6", "strawberry", 35.0, "fruit"));
            store.getProducts().put("7", new Product("7", "watermelon", 40.0, "fruit"));
            store.getProducts().put("8", new Product("8", "mango", 45.0, "fruit"));
            store.getProducts().put("9", new Product("9", "grape", 50.0, "fruit"));
            store.getProducts().put("10", new Product("10", "kiwi", 55.0, "fruit"));

        

        try {
            //Parent root = FXMLLoader.load(getClass().getResource("SellerMainPage.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("TestCustomerMainPage1.fxml"));
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


