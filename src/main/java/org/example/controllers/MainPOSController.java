package org.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import org.example.database.CategoryDAO;
import org.example.models.Category;

import java.sql.SQLException;
import java.util.List;


public class MainPOSController {

    @FXML FlowPane itemGrid;
    @FXML ListView orderList;
    @FXML Label totalLabel;
    @FXML Button checkoutBtn;
    @FXML VBox categorySidebar;

    public void initialize() throws SQLException {
        System.out.println("POS LOADED");
        CategoryDAO Cdao = new CategoryDAO();
        List<Category> allCategories = Cdao.getAllCategories();

        for(Category c: allCategories){
            Image img = new Image(getClass().getResourceAsStream("/"+ c.getIconPath()));
            ImageView image = new ImageView(img);
            image.setFitWidth(60);
            image.setFitHeight(60);
            Button btn  = new Button();
            btn.setText(c.getName());
            btn.setGraphic(image);
            btn.setContentDisplay(ContentDisplay.TOP);
            btn.setStyle("-fx-text-fill: white;" +
                    "-fx-font-size: 12px;" +
                    "-fx-max-width: infinity;");
            categorySidebar.getChildren().add(btn);
        }
    }

}
