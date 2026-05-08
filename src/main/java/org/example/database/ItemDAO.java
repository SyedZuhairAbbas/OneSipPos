package org.example.database;

import org.example.models.Category;
import org.example.models.Item;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.database.DatabaseManager.connect;

public class ItemDAO {

    public List getItemsByCategory(int categoryId){
        List<Item> list = new ArrayList<>();
        try(Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement("Select * from Item Where categoryId = ?")){
            stmt.setInt(1 , categoryId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int categoryID = rs.getInt("categoryId");
                String name = rs.getString("name");
                String imagePath = rs.getString("imagePath");
                boolean hasSizes = rs.getBoolean("hasSizes");
                int priceSmall = rs.getInt("priceSmall");
                int priceLarge = rs.getInt("pricelarge");
                int priceSingle = rs.getInt("priceSingle");

                Item item = new Item(id , priceSingle , priceLarge , priceSmall ,
                        hasSizes , imagePath , categoryID , name);

                list.add(item);
            }

        }catch (SQLException err){
            err.printStackTrace();
        }
        return list;
    }


    public void addItem(Item item){
        try(Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement("Insert into Item " +
                    "Values (?,?,?,?,?,?,?,?)")){

            stmt.setInt(1 , item.getId());
            stmt.setInt(2 , item.getCategoryId());
            stmt.setString(3 , item.getName());
            stmt.setString(4 , item.getImagePath());
            stmt.setBoolean(5 , item.isHasSizes());
            stmt.setInt(6 , item.getPriceSmall());
            stmt.setInt(7 , item.getPriceLarge());
            stmt.setInt(8 , item.getPriceSingle());

            Boolean rs = stmt.execute();

            if(!rs){
                System.out.println("insertion Failed");
            }

            System.out.println("Item inserted");

        } catch (SQLException err){
            err.printStackTrace();
        }
    }

    public void deleteItem (int id){
        try(Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement("Delete from Item " +
                    "Where id = ?")){
            stmt.setInt(1 , id);
            Boolean rs = stmt.execute();

            if(!rs){
                System.out.println("deletion Failed");
            }

            System.out.println("Item deleted");

        }  catch (SQLException err){
            err.printStackTrace();
        }
    }
}
