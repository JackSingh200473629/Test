module com.example.javaassignment13629 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javaassignment13629 to javafx.fxml;
    exports com.example.javaassignment13629;
}