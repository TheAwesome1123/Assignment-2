package com.mycompany.app.dao;

import com.mycompany.app.models.Owner;
import com.mycompany.app.database.ConnectionPool;
import java.sql.*;

public class OwnerDAO {
    public void createOwner(ConnectionPool pool, String firstName, String lastName)
            throws SQLException {
        Connection connection = pool.getConnection();
        String createStatement = "insert into Owners (First_Name, Last_Name) values (?, ?);";
        PreparedStatement create = connection.prepareStatement(createStatement);

        // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
        create.setString(1, firstName);
        create.setString(2, lastName);
        create.executeUpdate();
        pool.putBackConnection(connection);
    }

    public Owner getOwner(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String selectStatement = "select ? from Owners where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

        preparedStatement.setString(1, "*");
        preparedStatement.setInt(2, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        pool.putBackConnection(connection);

        int resultID = resultSet.getInt("ID");
        String firstName = resultSet.getString("First_Name");
        String lastName = resultSet.getString("Last_Name");

        Owner owner = new Owner();
        owner.setOwnerID(resultID);
        owner.setFirstName(firstName);
        owner.setLastName(lastName);

        return owner;
    }

    public void updateOwner(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "update Owners where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
    public void deleteOwner(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "delete from Owners where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
}
