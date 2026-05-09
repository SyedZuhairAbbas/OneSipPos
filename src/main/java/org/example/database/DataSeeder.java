package org.example.database;

import org.example.models.Category;
import org.example.models.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.database.DatabaseManager.connect;

public class DataSeeder {

    public void seed () throws SQLException{

        int count = 0;
        try(Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement("Select COUNT(*) FROM Catagory")){

            ResultSet rs = stmt.executeQuery();
            rs.next();
            count = rs.getInt(1);
            } catch (SQLException err){
                err.printStackTrace();
            }

            if(count > 0) return;

            Category category1 = new Category(0 ,"Golden Bites" ,
                    "images/Golden Bites.png" , 1);
            Category category2 = new Category(0 ,"Coffee Lovers" ,
                    "images/Coffee Lovers.png" , 2);
            Category category3 = new Category(0 ,"Slush Labs" ,
                    "images/Slush Lab.png" , 3);
            Category category4 = new Category(0 ,"Classic Flavours" ,
                    "images/Classic Flavours.png" , 4);
            CategoryDAO Cdao = new CategoryDAO();
            Cdao.addCategory(category1);
            Cdao.addCategory(category2);
            Cdao.addCategory(category3);
            Cdao.addCategory(category4);

            // GOLDEN BITES SEEDING
            Item Fries1 = new Item(0, 100, 150, 100, true,
                        "", 1, "Plain Fries");
            Item Fries2 = new Item(0, 100, 150, 100, true,
                        "", 1, "Masala Fries");
            Item Fries3 = new Item(0, 200, 250, 200, true,
                        "", 1, "Mayo Garlic Fries");
            Item Fries4 = new Item(0, 200, 250, 200, true,
                        "", 1, "Chipotle Fries");
            Item Fries5 = new Item(0, 200, 250, 200, true,
                        "", 1, "Jalapeno Fries");
            Item Fries6 = new Item(0, 200, 250, 200, true,
                        "", 1, "Dynamite Fries");


            //COFFEE LOVERS SEEDING
            Item Coffee1 = new Item(0, 350, 0, 0, false,
                    "", 2, "Iced Latte");
            Item Coffee2 = new Item(0, 400, 0, 0, false,
                    "", 2, "Iced Mocha");
            Item Coffee3 = new Item(0, 250, 0, 0, false,
                    "", 2, "Oreo Frappucino");
            Item Coffee4 = new Item(0, 250, 0, 0, false,
                    "", 2, "Strawberry Frappucino");
            Item Coffee5 = new Item(0, 250, 0, 0, false,
                    "", 2, "Caramel Frappucino");


            // SLUSH LAB SEEDING
            Item Slush1 = new Item(0, 150, 0, 0, false,
                    "", 3, "Blueberry Slush");
            Item Slush2 = new Item(0, 150, 0, 0, false,
                    "", 3, "Strawberry Slush");
            Item Slush3 = new Item(0, 150, 0, 0, false,
                    "", 3, "Mango Slush");
            Item Slush4 = new Item(0, 150, 0, 0, false,
                    "", 3, "Orange Slush");
            Item Slush5 = new Item(0, 150, 0, 0, false,
                    "", 3, "Green Apple Slush");


            // CLASSIC FLAVOURRS SEEDING
            Item Flavour1 = new Item(0, 0, 110, 90, true,
                    "", 4, "Orange");
            Item Flavour2 = new Item(0, 0, 110, 90, true,
                    "", 4, "Lemon");
            Item Flavour3 = new Item(0, 0, 110, 90, true,
                    "", 4, "Blueberry");
            Item Flavour4 = new Item(0, 0, 110, 90, true,
                    "", 4, "Green Apple");
            Item Flavour5 = new Item(0, 0, 110, 90, true,
                    "", 4, "Peach");
            Item Flavour6 = new Item(0, 0, 110, 90, true,
                    "", 4, "Lychee");
            Item Flavour7 = new Item(0, 0, 110, 90, true,
                    "", 4, "Blackberry");
            Item Flavour8 = new Item(0, 0, 110, 90, true,
                    "", 4, "Redbull");
            Item Flavour9 = new Item(0, 0, 110, 90, true,
                    "", 4, "Pineapple");
            Item Flavour10 = new Item(0, 0, 110, 90, true,
                    "", 4, "Falsa");
            Item Flavour11 = new Item(0, 0, 110, 90, true,
                    "", 4, "Strawberry");
            Item Flavour12 = new Item(0, 0, 110, 90, true,
                    "", 4, "Mango");
            Item Flavour13 = new Item(0, 0, 110, 90, true,
                    "", 4, "Bubble Gum");
            Item Flavour14 = new Item(0, 0, 110, 90, true,
                    "", 4, "Pomegranate");
            Item Flavour15 = new Item(0, 0, 110, 90, true,
                    "", 4, "Golden Apple");

            ItemDAO Idao = new ItemDAO();

            Idao.addItem(Fries1);
            Idao.addItem(Fries2);
            Idao.addItem(Fries3);
            Idao.addItem(Fries4);
            Idao.addItem(Fries5);
            Idao.addItem(Fries6);
            Idao.addItem(Coffee1);
            Idao.addItem(Coffee2);
            Idao.addItem(Coffee3);
            Idao.addItem(Coffee4);
            Idao.addItem(Coffee5);
            Idao.addItem(Slush1);
            Idao.addItem(Slush2);
            Idao.addItem(Slush3);
            Idao.addItem(Slush4);
            Idao.addItem(Slush5);
            Idao.addItem(Flavour1);
            Idao.addItem(Flavour2);
            Idao.addItem(Flavour3);
            Idao.addItem(Flavour4);
            Idao.addItem(Flavour5);
            Idao.addItem(Flavour6);
            Idao.addItem(Flavour7);
            Idao.addItem(Flavour8);
            Idao.addItem(Flavour9);
            Idao.addItem(Flavour10);
            Idao.addItem(Flavour11);
            Idao.addItem(Flavour12);
            Idao.addItem(Flavour13);
            Idao.addItem(Flavour14);
            Idao.addItem(Flavour15);
        }
    }
