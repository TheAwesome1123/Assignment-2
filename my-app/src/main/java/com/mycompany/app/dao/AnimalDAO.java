package com.mycompany.app.dao;

import com.mycompany.app.models.*;
import com.mycompany.app.database.*;
import java.sql.*;

public class AnimalDAO  {
    public void createAnimal(ConnectionPool pool, String type, String sex) throws SQLException {
        Connection connection = pool.getConnection();

        String createStatement = "insert into Animals (Type, Sex) values (?, ?);";
        PreparedStatement create = connection.prepareStatement(createStatement);

        // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
        create.setString(1, type);
        create.setString(2, sex);
        create.executeUpdate();
        pool.putBackConnection(connection);
    }

    public Animal getAnimal(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String selectStatement = "select ? from Animals where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

        preparedStatement.setString(1, "*");
        preparedStatement.setInt(2, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        pool.putBackConnection(connection);

        int resultID = resultSet.getInt("ID");
        String type = resultSet.getString("Type");
        String sex = resultSet.getString("Sex");

        Animal animal;

        if(type.equals("Pet")) {
            animal = new Pet();
        }
        else if(type.equals("Wild")) {
            animal = new WildAnimal();
        }
        else {
            animal = new DomesticOrWild();
        }

        animal.setID(resultID);
        animal.setSex(sex);

        return animal;
    }
    public void updateAnimal(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "update Animals where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
    public void deleteAnimal(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "delete from Animals where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
}
