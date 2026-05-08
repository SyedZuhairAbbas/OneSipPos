package org.example;

import atlantafx.base.theme.PrimerDark;
import javafx.application.Application;
import javafx.stage.Stage;
import org.example.database.DatabaseManager;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        DatabaseManager.initializeDatabase();
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());
        stage.setTitle("OneSipPos");
        stage.setMinWidth(1280);
        stage.setMinHeight(800);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
