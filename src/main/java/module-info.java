module edu.sjsu.cs.assignment3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens edu.sjsu.cs to javafx.fxml;
    opens edu.sjsu.cs.User to javafx.base;
    exports edu.sjsu.cs;
}