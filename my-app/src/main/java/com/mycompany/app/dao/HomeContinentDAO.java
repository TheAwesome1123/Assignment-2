package com.mycompany.app.dao;

import com.mycompany.app.models.HomeContinent;
import com.mycompany.app.database.ConnectionPool;

import java.sql.*;

public class HomeContinentDAO {
    public void createHomeContinent(ConnectionPool pool, String homeContinent, int wildAnimalID)
            throws SQLException {
        Connection connection = pool.getConnection();
        String createStatement = "insert into HomeContinents (HomeContinent, WildAnimal_ID) values (?, ?);";
        PreparedStatement create = connection.prepareStatement(createStatement);

        // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
        create.setString(1, homeContinent);
        create.setInt(2, wildAnimalID);
        create.executeUpdate();
        pool.putBackConnection(connection);
    }

    public HomeContinent getHomeContinent(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String selectStatement = "select ? from HomeContinents where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

        preparedStatement.setString(1, "*");
        preparedStatement.setInt(2, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        pool.putBackConnection(connection);

        int resultID = resultSet.getInt("ID");
        String homeContinent = resultSet.getString("HomeContinent");
        int wildAnimalID = resultSet.getInt("WildAnimal_ID");

        HomeContinent newHomeContinent = new HomeContinent();
        newHomeContinent.setContinentID(resultID);
        newHomeContinent.setContinent(homeContinent);
        newHomeContinent.setWildAnimalID(wildAnimalID);

        return newHomeContinent;
    }

    public void updateHomeContinent(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "update HomeContinents where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
    public void deleteHomeContinent(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "delete from HomeContinents where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
}
