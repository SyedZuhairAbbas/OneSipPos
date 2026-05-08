package org.example.database;

import com.sun.net.httpserver.Authenticator;
import javafx.scene.control.Alert;
import org.example.models.Category;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:sqlite:C:/OneSipPos/data/OneSip.db";

    public static Connection connect () throws SQLException{
        try {
            return DriverManager.getConnection(DB_URL);

        }catch(SQLException e){
            System.err.println("Database Connection Error: " + e.getMessage());
            throw e;
        }
    }

    public static void initializeDatabase(){
        new File("C:/OneSipPos/data").mkdir();

        try(Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement()) {

                stmt.execute(
                    "CREATE TABLE IF NOT EXISTS Catagory (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                            "name TEXT ," +
                            "iconPath TEXT ," +
                            "sortOrder INTEGER " +
                            ");"
                );

                stmt.execute(
                    "CREATE TABLE IF NOT EXISTS Item (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                            "categoryId INTEGER ," +
                            "name TEXT ," +
                            "imagePath TEXT ," +
                            "hasSizes INTEGER ," +
                            "priceSmall INTEGER ," +
                            "priceLarge INTEGER ," +
                            "priceSingle INTEGER" +
                            ");"
                );

                stmt.execute(
                    "CREATE TABLE IF NOT EXISTS orders (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                            "timestamp DATE ," +
                            "total INTEGER" +
                            ");"
                );

                stmt.execute(
                    "CREATE TABLE IF NOT EXISTS OrderItem (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                            "orderId INTEGER ," +
                            "itemName TEXT ," +
                            "size TEXT ," +
                            "price INTEGER ," +
                            "quantity INTEGER" +
                            ");"
                );
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }