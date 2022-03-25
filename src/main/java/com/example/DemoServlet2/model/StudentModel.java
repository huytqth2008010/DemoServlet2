package com.example.DemoServlet2.model;

import com.example.DemoServlet2.entity.Student;
import com.example.DemoServlet2.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {
    public boolean save(Student student){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try
        {
            Connection connection = connectionHelper.getConnection();
            Statement statement = connection.createStatement();
            String sqlStatement = "insert into students (id, rollNumber, email, name) values ("
                    + student.getId() + ",'"
                    + student.getRollNumber() + "','"
                    + student.getEmail() + "','"
                    + student.getName() + "')";
            statement.execute(sqlStatement);
             /* String sql = "insert into student (id, rollNumber, email, name) values (1, 'A002', 'hung@gmail.com', 'Hung')";
            String sqlStatement =
                    String.format("insert into student (id, rollNumber, email, name) values (%d, '%s', '%s', '%s')",
                            student.getId(),
                            student.getRollNumber(),
                            student.getEmail(),
                            student.getName());
            statement.execute(sqlStatement);*/
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Student> findAll(){
        List<Student> listStudent = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            Connection connection = connectionHelper.getConnection();
            String sqlSelect = "select * from students";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String rollNumber = resultSet.getString("rollNumber");
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                Student student = new Student(id, rollNumber, email, name);
                listStudent.add(student);
            }
        }catch (Exception e){

        }
        return listStudent;
    }
}
