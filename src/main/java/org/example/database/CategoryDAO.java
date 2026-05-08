package org.example.database;

import org.example.models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.database.DatabaseManager.connect;

public class CategoryDAO{

    public List getAllCategories() throws SQLException {
        List<Category> list = new ArrayList<>();
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Catagory")){

            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String iconPath = rs.getString("iconPath");
                int sortOrder = rs.getInt("sortOrder");
                Category category = new Category(id, name, iconPath, sortOrder);
                list.add(category);
            }
        } catch (SQLException err){
            err.printStackTrace();
        }
        return list;
    }

    public void addCategory(Category category) throws SQLException {
        try(Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Catagory " +
                    "(name , iconPath , sortOrder) " +
                    "VALUES (?,?,?)")){

            stmt.setString(1, category.getName());
            stmt.setString(2, category.getIconPath());
            stmt.setInt(3, category.getSortOrder());

            boolean rs = stmt.execute();

            if (!rs) {
                System.out.println("Category add failed");
            }

            System.out.println("category added");

        } catch (SQLException err){
            err.printStackTrace();
        }
    }

    public void deleteCategory(int id) throws SQLException {
        try ( Connection conn = connect();
              PreparedStatement stmt = conn.prepareStatement("DELETE FROM Catagory WHERE id = ?")){

            stmt.setInt(1, id);

            Boolean rs = stmt.execute();

            if (!rs) {
                System.out.println("Category delete failed");
            }

            System.out.println("category deleted");

        } catch (SQLException err){
            err.printStackTrace();
        }
    }


}
