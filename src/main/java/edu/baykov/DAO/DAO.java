package edu.baykov.DAO;


import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class DAO{
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "admin";

    public<T> List<T> findAll(Class<T> clz){

        List<T> result = new ArrayList<>();
        String tableName = clz.getSimpleName();
        Field[] fields = clz.getDeclaredFields();
        String rowsNames = Arrays.stream(fields).map(Field::getName).collect(Collectors.joining(", "));

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select " + rowsNames + "  from " + tableName);
            while (resultSet.next()) {
                result.add(create(clz, fields,resultSet));
            }
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    private <T> T  create(Class<T> clz, Field[] fields, ResultSet resultSet) throws Exception {
        T obj = clz.getDeclaredConstructor().newInstance();
        for (Field f : fields) {
            f.setAccessible(true);
            f.set(obj, resultSet.getObject(f.getName()));
        }
        return obj;
    }

}
