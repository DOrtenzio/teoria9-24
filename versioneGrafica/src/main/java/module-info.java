module com.example.ex4_1fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ex4_1fx to javafx.fxml;
    exports com.example.ex4_1fx;
}