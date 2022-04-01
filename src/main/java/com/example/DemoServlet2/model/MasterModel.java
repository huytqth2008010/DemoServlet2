package com.example.DemoServlet2.model;

import com.example.DemoServlet2.annocation.Column;
import com.example.DemoServlet2.annocation.Table;
import com.example.DemoServlet2.modelAmmotation.Entity;
import com.example.DemoServlet2.util.ConnectionHelper;
import com.example.DemoServlet2.util.SQLConfig;

import javax.lang.model.UnknownEntityException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MasterModel<T> {

    // insert into tenbang( truong1, truong2) values (gtritruong1, gtritruong2)
    public boolean save(T obj){
        String tableName = "";
        Class clazz = obj.getClass();
        if (!clazz.isAnnotationPresent(Table.class)){
            return false;
        }
        Table table = (Table) clazz.getDeclaredAnnotation(Table.class);
        if (table.name() != null && table.name().length() > 0){
            tableName = table.name();
        }else {
            tableName = clazz.getSimpleName() + "s";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO");
        stringBuilder.append(" ");
        stringBuilder.append(tableName);

        // Lấy ra thông tin trường.
        StringBuilder filedNameBuilder = new StringBuilder();
        filedNameBuilder.append("(");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:
             fields) {
            if (!field.isAnnotationPresent(Column.class)){
                continue;
            }
            Column column = field.getDeclaredAnnotation(Column.class);
            filedNameBuilder.append(column.name());
            filedNameBuilder.append(", ");
        }
        filedNameBuilder.setLength(filedNameBuilder.length() -2);
        filedNameBuilder.append(")");
        stringBuilder.append(" ");
        stringBuilder.append(filedNameBuilder);
        stringBuilder.append(" ");
        stringBuilder.append("VALUES");
        stringBuilder.append(" ");

        //xu ly lay gia tri cac truong
        StringBuilder fieldValueBuilder = new StringBuilder();
        fieldValueBuilder.append("(");
        for (Field field:
             fields) {
            try {
                if (!field.isAnnotationPresent(Column.class)){
                    continue;
                }
                Column column = field.getDeclaredAnnotation(Column.class);
                field.setAccessible(true);
                if (column.type().contains("VARCHAR") || column.type().contains("TEXT")){
                    fieldValueBuilder.append("'");
                    fieldValueBuilder.append(field.get(obj));
                    fieldValueBuilder.append("'");
                }else {
                    fieldValueBuilder.append(field.get(obj));
                }
                fieldValueBuilder.append(", ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        fieldValueBuilder.setLength(fieldValueBuilder.length() -2);
        fieldValueBuilder.append(")");
        stringBuilder.append(fieldValueBuilder);
        try {
            Connection connection = ConnectionHelper.getConnection();
            Statement stt = connection.createStatement();
            stt.execute(stringBuilder.toString());
            System.out.println("Action success");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

//    public List<T> toList(){
//        //select * from table name
//        // build sql command
//
//        List<T> res = new ArrayList<>();
//        try {
//            Connection connection = ConnectionHelper.getConnection();
//            if (connection == null){
//                throw new EntityException("Can not connect to db");
//            }
//            if (!isEntity()){
//                throw new EntityException("Not an entity class");
//            }
//            String tableName = clazz.getAnnotation(Entity.class).tableName();
//            StringBuilder stringCmd = new StringBuilder();
//            stringCmd.append(SQLConfig.SELECT_ASTERISK);
//            stringCmd.append(SQLConfig.SPACE);
//            stringCmd.append(SQLConfig.FORM);
//            stringCmd.append(SQLConfig.SPACE);
//            stringCmd.append(tableName);
//
//            PreparedStatement preparedStatement = connection.prepareStatement(stringCmd.toString());
//            ResultSet resultSet = preparedStatement.executeQuery();
//            List<T> fullFiled = fullFillObject(resultSet);
//            if (fullFiled.size() == 0){
//                throw  new EntityException("Not Fund");
//            }
//            res = fullFiled;
//        } catch (EntityException | IllegalAccessException | ClassNotFoundException | SQLException error) {
//            System.out.printf("Find all error %s\n", error.getMessage());
//        }
//        return res;
//    }
    public T findById(Object id){

        return null;
    }

    public boolean update(Object id,T updateObj){
        return false;
    }

    public boolean delete(Object id){
        return false;
    }
//    public List<T> fullFillObject(ResultSet resultSet) throws InstantiationError, IllegalAccessException, SQLException {
//        ArrayList<T> listObj = new ArrayList<>();
//        while (resultSet.next()){
//            T obj = clazz.newTnstance();
//            for (Field field : clazz.getDeclareFields()) {
//                if (!field.isAnnotationPresent(Column.class)){
//                    continue;
//                }
//                field.setAccessible(true);
//                Column columnInfor  = field.getAnnotation(Column.class);
//                switch (columnInfor.columnType()){
//                    case SQLConfig.INTEGER:
//                        field.set(obj, resultSet.getInt(columnInfor.columnName()));
//                        break;
//                    case SQLConfig.VARCHAR255:
//                    case SQLConfig.VARCHAR50:
//                    case SQLConfig.TEXT:
//                        field.set(obj, resultSet.getString(columnInfor.columnName()));
//                        break;
//                    case SQLConfig.DOUBLE:
//                        field.set(obj, resultSet.getDouble(columnInfor.columnName()));
//                        break;
//                    case SQLConfig.DATE:
//                        field.set(obj, ConverHelper.convertSqlDateToJavaDate(resultSet.getDate(columnInfor.columnName())));
//                        break;
//                    case SQLConfig.DATETIME:
//                    case SQLConfig.TIME_STAMP:
//                        field.set(obj, ConverHelper.convertSqlTimeStampToJavaDate(resultSet.getTimestamp(columnInfor.columnName())));
//                        break;
//                }
//            }
//            listObj.add(obj);
//        }
//        return listObj;
//    }

}
