package manager.food.food_manager.model;

import manager.food.food_manager.entity.Category;
import manager.food.food_manager.entity.Food;
import manager.food.food_manager.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Categorymodel {

    public ArrayList<Category> findAll(){
        Connection connection = ConnectionHelper.getConnection();
        ArrayList<Category> result = new ArrayList<>();
        if(connection !=null){
            try {

                PreparedStatement preparedStatement = connection.prepareStatement("select * from  categories");
                ResultSet resultSet= preparedStatement.executeQuery();
                while(resultSet.next()){
                    int id =    resultSet.getInt("id");
                    String name =   resultSet.getString("name");
                    Category category = new Category(id,name);
                    result.add(category);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
