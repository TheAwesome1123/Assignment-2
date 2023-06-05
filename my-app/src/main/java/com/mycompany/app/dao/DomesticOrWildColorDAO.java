package com.mycompany.app.dao;

import com.mycompany.app.animals.Dog;
import com.mycompany.app.database.ConnectionPool;
import com.mycompany.app.models.DomesticOrWildColor;

import java.sql.*;

public class DomesticOrWildColorDAO {
    public void createDomesticOrWildColor(ConnectionPool pool, String color, String shade)
            throws SQLException {
        Connection connection = pool.getConnection();
        String createStatement = "insert into DomesticOrWildColors (Color, Shade) values (?, ?);";
        PreparedStatement create = connection.prepareStatement(createStatement);

        // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
        create.setString(1, color);
        create.setString(2, shade);
        create.executeUpdate();
        pool.putBackConnection(connection);
    }

    public DomesticOrWildColor getDomesticOrWildColor(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String selectStatement = "select ? from DomesticOrWildColors where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

        preparedStatement.setString(1, "*");
        preparedStatement.setInt(2, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        pool.putBackConnection(connection);

        int resultID = resultSet.getInt("ID");
        String color = resultSet.getString("Color");
        String shade = resultSet.getString("Shade");

        return null;
    }

    public void updateDomesticOrWildColor(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "update DomesticOrWildColors where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
    public void deleteDomesticOrWildColor(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "delete from DomesticOrWildColors where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
}
