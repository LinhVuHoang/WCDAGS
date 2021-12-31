package manager.food.food_manager.model;

import manager.food.food_manager.entity.Food;
import manager.food.food_manager.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Foodmodel {
    public static void main(String[] args) {
        Foodmodel foodmodel = new Foodmodel();
      ArrayList<Food> listfood =foodmodel.findAll();
     System.out.println(listfood.size());
       LocalDate localDate = LocalDate.now();
   String local = localDate.toString();
 // foodmodel.save( new Food(1,"gà Rán","gà quay thơm ngon","anh2.png",80000,local,local,1,1));
//     foodmodel.delete(8);
//        Food f = foodmodel.findById(10);
//        f.setName("gà quay kfc");
//        foodmodel.update(10,f);
//       f= foodmodel.findById(10);
        //System.out.println(f.toString());
    //    foodmodel.deletethin(11);
      //  foodmodel.delete(11);

    }

    public  boolean save(Food food){
        Connection connection = ConnectionHelper.getConnection();
        if(connection !=null) {
            try {

                PreparedStatement preparedStatement =
                        connection.prepareStatement("insert into foods (name,description,thumbnail,price,daysell,datefix,category_id,status) values(?,?,?,?,?,?,?,?)");
                        preparedStatement.setString(1,food.getName());
                        preparedStatement.setString(2,food.getDescription());
                        preparedStatement.setString(3,food.getThumbnail());
                        preparedStatement.setDouble(4,food.getPrice());
                        preparedStatement.setString(5,  food.getDaysell());
                        preparedStatement.setString(6, food.getDaysell());
                        preparedStatement.setInt(7,food.getCategory_id());
                        preparedStatement.setInt(8,food.getStatus());
                preparedStatement.execute();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public ArrayList<Food> findAll(){
        Connection connection = ConnectionHelper.getConnection();
        ArrayList<Food> result = new ArrayList<>();
        if(connection !=null){
            try {

                PreparedStatement preparedStatement = connection.prepareStatement("select * from  foods");
              ResultSet resultSet= preparedStatement.executeQuery();
              while(resultSet.next()){
                 int id = resultSet.getInt("id");
                 String name =   resultSet.getString("name");
                 String description = resultSet.getString("description");
                 String thumbnail = resultSet.getString("thumbnail");
                 double price = resultSet.getDouble("price");
                  String daysell = resultSet.getString("daysell");
                  String datefix = resultSet.getString("datefix");
                  int category_id = resultSet.getInt("category_id");
                  int status = resultSet.getInt("status");
                  Food food = new Food(id,name,description,thumbnail,price,daysell,datefix,category_id,status);
                  result.add(food);
              }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public Food findById(int id){
        Connection connection = ConnectionHelper.getConnection();
        if(connection !=null){
            try {

                PreparedStatement preparedStatement = connection.prepareStatement("select * from  foods where id =?");
                preparedStatement.setInt(1,id);
                ResultSet resultSet= preparedStatement.executeQuery();
                if(resultSet.next()){
                    int foodid =    resultSet.getInt("id");
                    String name =   resultSet.getString("name");
                    String description = resultSet.getString("description");
                    String thumbnail = resultSet.getString("thumbnail");
                    double price = resultSet.getDouble("price");
                    String daysell = resultSet.getString("daysell");
                    String datefix = resultSet.getString("datefix");
                    int category_id = resultSet.getInt("category_id");
                    int status = resultSet.getInt("status");
                    Food food = new Food(foodid,name,description,thumbnail,price,daysell,datefix,category_id,status);
                    return food;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public  boolean update(int id,Food food){

        Connection connection = ConnectionHelper.getConnection();
        if(connection !=null){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("update  foods set name=? , description =?,thumbnail=?,price=?,daysell=?,datefix=?,category_id=?,status=? where id=? ");
                preparedStatement.setInt(9,id);
                    preparedStatement.setString(1,food.getName());
                    preparedStatement.setString(2,food.getDescription());
                    preparedStatement.setString(3,food.getThumbnail());
                    preparedStatement.setDouble(4,food.getPrice());
                    preparedStatement.setString(5,  food.getDaysell());
                    preparedStatement.setString(6, food.getDaysell());
                    preparedStatement.setInt(7,food.getCategory_id());
                    preparedStatement.setInt(8,food.getStatus());
                    preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }
    public boolean delete(int id){

        Connection connection = ConnectionHelper.getConnection();
        if(connection !=null){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from foods where id=?");
                preparedStatement.setInt(1,id);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }
    public boolean deletethin(int id){
        Connection connection = ConnectionHelper.getConnection();
        if(connection !=null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("update  foods set status=-1  where id=? ");
                preparedStatement.setInt(1,id);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
