package com.mycompany.app.dao;

import com.mycompany.app.animals.Dog;
import com.mycompany.app.database.ConnectionPool;

import java.sql.*;

public class WildAnimalColorDAO {
    public void createWildAnimalColor(ConnectionPool pool, String color, String shade)
            throws SQLException {
        Connection connection = pool.getConnection();
        String createStatement = "insert into WildAnimalColors (Color, Shade) values (?, ?);";
        PreparedStatement create = connection.prepareStatement(createStatement);

        // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
        create.setString(1, color);
        create.setString(2, shade);
        create.executeUpdate();
        pool.putBackConnection(connection);
    }

    public Dog getWildAnimalColor(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String selectStatement = "select ? from WildAnimalColors where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

        preparedStatement.setString(1, "*");
        preparedStatement.setInt(2, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        pool.putBackConnection(connection);

        int resultID = resultSet.getInt("ID");
        String color = resultSet.getString("Color");
        String shade = resultSet.getString("Shade");

        return null;
    }

    public void updateWildAnimalColor(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "update WildAnimalColors where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
    public void deleteWildAnimalColor(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "delete from WildAnimalColors where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
}
