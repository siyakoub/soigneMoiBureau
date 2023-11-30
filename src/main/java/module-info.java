module com.mourad.soignemoibureau {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mourad.soignemoibureau to javafx.fxml;
    exports com.mourad.soignemoibureau;
}