package com.example.DemoServlet2.util;


import com.example.DemoServlet2.annocation.Column;
import com.example.DemoServlet2.annocation.Table;
import javafx.scene.control.Tab;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Set;

public class MigrationJava {

    public static void main(String[] args) {
        Reflections reflections = new Reflections("com.example.DemoServlet2");
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Table.class);
        for (Class<?> table : annotated){
            createTableFromEntity(table);
        }
    }

    private static void createTableFromEntity(Class clazz) {
        // check class có phải được đặt annotation này không
        if (!clazz.isAnnotationPresent(Table.class)){
            return;
        }
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE");
        sqlStringBuilder.append(" ");

        System.out.println("______________");
        // Lấy ra thông tin class
        // Lấy ra tên ngắn gọn
        String tableName = clazz.getSimpleName().toLowerCase() + "s";
        Table table = (Table) clazz.getDeclaredAnnotation(Table.class);
        if (table.name() != null && table.name().length() > 0){
            tableName = table.name();
        }
        sqlStringBuilder.append(tableName);
        sqlStringBuilder.append(" ");
        sqlStringBuilder.append("(");
        //Lấy ra mảng các trường của class đó.
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String columnName = field.getName();
            String columnType = "";
            if (field.getType().getSimpleName().contains("String")){
                columnType = "VARCHAR(255)";
            }else {
                columnType = field.getType().getSimpleName();

            }
            if (field.isAnnotationPresent(Column.class)){
                Column column = field.getDeclaredAnnotation(Column.class);
                columnName = column.name();
                columnType = column.type();
            }
            sqlStringBuilder.append(columnName);
            sqlStringBuilder.append(" ");
            sqlStringBuilder.append(columnType);

            sqlStringBuilder.append(",");
        }
        sqlStringBuilder.setLength(sqlStringBuilder.length() - 1);
        sqlStringBuilder.append(")");
        System.out.println(sqlStringBuilder.toString());

        try {
            Connection connection = ConnectionHelper.getConnection();
            Statement dropStatement = connection.createStatement();
            dropStatement.execute(String.format("DROP TABLE %s", tableName));
            System.out.println(String.format("Drop table %s success!", tableName));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        try{
            Connection connection = ConnectionHelper.getConnection();
            Statement dropStatement = connection.createStatement();
            dropStatement.execute(sqlStringBuilder.toString());
            System.out.println(String.format("Create table %s success!", tableName));

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
