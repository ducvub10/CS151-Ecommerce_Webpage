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
import javafx.scene.image.Image;

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


