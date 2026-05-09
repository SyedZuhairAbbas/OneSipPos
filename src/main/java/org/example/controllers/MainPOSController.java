package org.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;


public class MainPOSController {

    @FXML FlowPane itemGrid;
    @FXML ListView orderList;
    @FXML Label totalLabel;
    @FXML Button checkoutBtn;

    public void initialize(){
        System.out.println("POS LOADED");
    }

}
