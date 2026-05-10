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
import org.example.database.ItemDAO;
import org.example.models.Category;
import org.example.models.Item;

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
        System.out.println(allCategories.size());

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

            btn.setOnAction(e ->
                    {
                        try {
                            loadItems(c.getId());
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
            );

            categorySidebar.getChildren().add(btn);
        }
    }

    public void loadItems(int categoryId) throws  SQLException {
      itemGrid.getChildren().clear();
      ItemDAO Idao = new ItemDAO();
      List<Item> allItemsByCategory = Idao.getItemsByCategory(categoryId);

      for(Item i: allItemsByCategory){

          ImageView Image = null;
          if(i.getImagePath() != null && !i.getImagePath().isEmpty()) {
              Image img = new Image(getClass().getResourceAsStream("/"+ i.getImagePath()));
              Image = new ImageView(img);
              Image.setFitHeight(80);
              Image.setFitWidth(80);
              Image.setPreserveRatio(true);
          }
          Button btn = new Button();
          btn.setText(i.getName());
          btn.setGraphic(Image);
          btn.setContentDisplay(ContentDisplay.TOP);
          itemGrid.getChildren().add(btn);
      }
    }

}
