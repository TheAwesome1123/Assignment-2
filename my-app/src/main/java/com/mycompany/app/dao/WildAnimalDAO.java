package com.mycompany.app.dao;

import com.mycompany.app.models.WildAnimal;
import com.mycompany.app.database.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WildAnimalDAO {
    public void createWildAnimal(ConnectionPool pool, String type, int animalID)
        throws SQLException {
            Connection connection = pool.getConnection();
            String createStatement = "insert into WildAnimals (Type, Animal_ID) values (?, ?);";
            PreparedStatement create = connection.prepareStatement(createStatement);

            // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
            create.setString(1, type);
            create.setInt(2, animalID);
            create.executeUpdate();
            pool.putBackConnection(connection);
    }

    public WildAnimal getWildAnimal(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String selectStatement = "select * from WildAnimals where ID = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        pool.putBackConnection(connection);

        WildAnimal wildAnimal = new WildAnimal();
        int resultID = resultSet.getInt("ID");
        String type = resultSet.getString("Type");
        int animalID = resultSet.getInt("Animal_ID");

        wildAnimal.setWildAnimalID(resultID);
        wildAnimal.setType(type);
        wildAnimal.setAnimalID(animalID);
        return wildAnimal;
    }
    public void updateWildAnimal(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "update WildAnimals where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
    public void deleteWildAnimal(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "delete from WildAnimals where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
}