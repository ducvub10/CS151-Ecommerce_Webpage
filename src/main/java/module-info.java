module edu.sjsu.cs.assignment3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens edu.sjsu.cs to javafx.fxml;
    exports edu.sjsu.cs;
}