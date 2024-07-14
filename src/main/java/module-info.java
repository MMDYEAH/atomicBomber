module com.example.atomicbomber {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.media;
    exports view;
    opens view to javafx.fxml;
}