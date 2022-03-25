package com.example.DemoServlet2.model;

import com.example.DemoServlet2.entity.Product;
import com.example.DemoServlet2.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    public boolean save(Product obj){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try
        {
            Connection connection = connectionHelper.getConnection();
            Statement statement = connection.createStatement();

            String sqlStatement =
                    String.format("insert into products ( name, thumbnail, price ) values ( '%s', '%s', %d)",
                            obj.getName(),
                            obj.getThumbnail(),
                            obj.getPrice());
//            String sqlStatement = "insert into products ( name, thumbnail, price) values ('"
//                    + obj.getName() + "','"
//                    + obj.getThumbnail() + "',"
//                    + obj.getPrice() + ")";
            statement.execute(sqlStatement);
            return true;
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }

    public List<Product> findAll(){
        List<Product> listObj = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();

        try {
            Connection connection = connectionHelper.getConnection();
            Statement statement = connection.createStatement();

            String sqlSelect = String.format("select * from products");
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String thumbnail = resultSet.getString("thumbnail");
                int price = resultSet.getInt("price");
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
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            Connection connection = connectionHelper.getConnection();
            String sqlSelect = String.format("select * from products where id = %d", id);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            if (resultSet.next()){
                String name = resultSet.getString("name");
                String thumbnail = resultSet.getString("thumbnail");
                int price = resultSet.getInt("price");
                int status = resultSet.getInt("status");
                obj = new Product(id, name, thumbnail, price, status);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return obj;
    }

    public boolean update(int id, Product updateProduct) {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            Connection connection = connectionHelper.getConnection();
            Statement statement = connection.createStatement();

            String sqlStatement =
                    String.format("update products set name = '%s', thumbnail = '%s', price = %d, status = %d where id = %d",
                            updateProduct.getName(),
                            updateProduct.getThumbnail(),
                            updateProduct.getPrice(),
                            updateProduct.getStatus(),
                            id);
            System.out.println(sqlStatement);
            statement.execute(sqlStatement);
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(int id) {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            Connection connection = connectionHelper.getConnection();
            Statement statement = connection.createStatement();

            String sqlStatement =
                    String.format("delete from products where id = %d",
                            id);
            statement.execute(sqlStatement);
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
