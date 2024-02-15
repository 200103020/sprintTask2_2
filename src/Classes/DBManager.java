package Classes;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static final Connection connection;

    static  {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bitlabshop",
                    "postgres","postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static ArrayList<Item> getItemList(){
        ArrayList<Item> itemList = new ArrayList<>();

        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM items");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                Item item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                itemList.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return itemList;
    }

    public static User checkUser(String email ){
        User user = null;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * from users where email = ?");
            stmt.setString(1,email);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()){
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setFullName(resultSet.getString("full_name"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

}
