module lab2.lab2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lab2.main to javafx.fxml;
    exports com.lab2.main;
    exports com.lab2.main.sortingAlgorithms;
    opens com.lab2.main.sortingAlgorithms to javafx.fxml;
    exports com.lab2.main.Product;
    opens com.lab2.main.Product to javafx.fxml;
}