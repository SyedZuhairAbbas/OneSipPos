package org.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import org.example.database.CategoryDAO;
import org.example.models.Category;

import java.sql.SQLException;
import java.util.List;


public class MainPOSController {

    @FXML FlowPane itemGrid;
    @FXML ListView orderList;
    @FXML Label totalLabel;
    @FXML Button checkoutBtn;

    public void initialize() throws SQLException {
        System.out.println("POS LOADED");
        CategoryDAO Cdao = new CategoryDAO();
        List<Category> allCategories = Cdao.getAllCategories();

        for(Category c: allCategories){
            System.out.println(c.getName());
        }
    }

}
