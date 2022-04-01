package com.example.DemoServlet2.model;

import com.example.DemoServlet2.entity.Product;
import com.example.DemoServlet2.util.ConnectionHelper;
import com.example.DemoServlet2.util.SQLConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    public boolean save(Product obj){
        try
        {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.DATEBASE_PRODUCT_INSERT);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getThumbnail());
            preparedStatement.setDouble(3, obj.getPrice());
            preparedStatement.execute();
            return true;
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }

//    public boolean save2(Product obj){
//        try
//        {
//            Connection connection = ConnectionHelper.getConnection();
//            Statement statement = connection.createStatement();
//
//            String sqlStatement =
//                    String.format("insert into products ( name, thumbnail, price ) values ( '%s', '%s', %d)",
//                            obj.getName(),
//                            obj.getThumbnail(),
//                            obj.getPrice());
////            String sqlStatement = "insert into products ( name, thumbnail, price) values ('"
////                    + obj.getName() + "','"
////                    + obj.getThumbnail() + "',"
////                    + obj.getPrice() + ")";
//            statement.execute(sqlStatement);
//            return true;
//        }catch(SQLException | ClassNotFoundException e){
//            e.printStackTrace();
//        }
//        return false;
//    }

    public List<Product> findAll(){
        List<Product> listObj = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlSelect = SQLConfig.DATABASE_PRODUCT_SELECT;
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String thumbnail = resultSet.getString("thumbnail");
                double price = resultSet.getDouble("price");
                int status = resultSet.getInt("status");
                Product obj = new Product(id, name, thumbnail, price, status);
                listObj.add(obj);
            }
        }catch (Exception e){

        }
        return listObj;
    }

    public Product findById(int id){
        Product obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.DATABASE_PRODUCT_SELECT2);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                String name = resultSet.getString("name");
                String thumbnail = resultSet.getString("thumbnail");
                double price = resultSet.getDouble("price");
                int status = resultSet.getInt("status");
                obj = new Product(id, name, thumbnail, price, status);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return obj;
    }

    public boolean update(int id, Product updateProduct) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.DATABASE_PRODUCT_UPDATE);
            statement.setString(1, updateProduct.getName());
            statement.setString(2, updateProduct.getThumbnail());
            statement.setDouble(3, updateProduct.getPrice());
            statement.setInt(4, updateProduct.getStatus());
            statement.setInt(5, id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.DATABASE_PRODUCT_DELETE);
            statement.setInt(1,id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
