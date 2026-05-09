package org.example;

import atlantafx.base.theme.PrimerDark;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.database.DataSeeder;
import org.example.database.DatabaseManager;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        DatabaseManager.initializeDatabase();
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainPOS.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("OneSipPos");
        stage.setMinWidth(1280);
        stage.setMinHeight(800);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        new DataSeeder().seed();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
