package com.mycompany.app.dao;

import com.mycompany.app.models.Owner;
import com.mycompany.app.database.ConnectionPool;
import java.sql.*;

public class OwnerDAO {
    ConnectionPool pool = ConnectionPool.getInstance();

    public void createOwner(String firstName, String lastName) {
        Connection connection = pool.retrieve();
        String createStatement = "insert into Owners (First_Name, Last_Name) values (?, ?);";
        PreparedStatement create = null;

        try {
            create = connection.prepareStatement(createStatement);

            // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
            create.setString(1, firstName);
            create.setString(2, lastName);
            create.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (connection != null) pool.putBack(connection);
                if (create != null) create.close();
            }
            catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public Owner getOwner(int id) {
        Connection connection = pool.retrieve();
        Owner owner = new Owner();
        ResultSet resultSet = null;
        String selectStatement = "select ? from Owners where id = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(selectStatement);
            preparedStatement.setString(1, "*");
            preparedStatement.setInt(2, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int resultID = resultSet.getInt("ID");
            String firstName = resultSet.getString("First_Name");
            String lastName = resultSet.getString("Last_Name");

            owner.setOwnerID(resultID);
            owner.setFirstName(firstName);
            owner.setLastName(lastName);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (connection != null) pool.putBack(connection);
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            }
            catch (SQLException e) {
                System.out.println(e);
            }
        }

        return owner;
    }

    public void updateOwner(int id) {
        Connection connection = pool.retrieve();
        String updateStatement = "update Owners where id = ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(updateStatement);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (connection != null) pool.putBack(connection);
                if (preparedStatement != null) preparedStatement.close();
            }
            catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    public void deleteOwner(int id) {
        Connection connection = pool.retrieve();
        String updateStatement = "delete from Owners where id = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(updateStatement);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (connection != null) pool.putBack(connection);
                if (preparedStatement != null) preparedStatement.close();
            }
            catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
