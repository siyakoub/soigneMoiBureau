module com.mourad.soignemoibureau {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;

    // Ouvre les packages contenant les modèles à Gson
    opens com.mourad.soignemoibureau.model to com.google.gson, javafx.base;

    // Ouvre les packages contenant les contrôleurs FXML à javafx.fxml
    opens com.mourad.soignemoibureau to javafx.fxml;
    opens com.mourad.soignemoibureau.controller to javafx.fxml;

    // Exporte votre package principal
    exports com.mourad.soignemoibureau;
}
