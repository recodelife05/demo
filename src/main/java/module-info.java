module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.models;
    opens com.example.demo.models to javafx.fxml;
    exports com.example.demo.contracts;
    opens com.example.demo.contracts to javafx.fxml;
    exports com.example.demo.infrastructure;
    opens com.example.demo.infrastructure to javafx.fxml;
    exports com.example.demo.application;
    opens com.example.demo.application to javafx.fxml;
    exports com.example.demo.archive;
    opens com.example.demo.archive to javafx.fxml;
    exports com.example.demo.infrastructure.contracts;
    opens com.example.demo.infrastructure.contracts to javafx.fxml;
}