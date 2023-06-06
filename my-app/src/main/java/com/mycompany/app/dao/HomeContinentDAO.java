package com.mycompany.app.dao;

import com.mycompany.app.models.HomeContinent;
import com.mycompany.app.database.ConnectionPool;
import java.sql.*;

public class HomeContinentDAO {
    ConnectionPool pool = ConnectionPool.getInstance();

    public void createHomeContinent(String homeContinent, int wildAnimalID) {
        Connection connection = pool.retrieve();
        String createStatement = "insert into HomeContinents (HomeContinent, WildAnimal_ID) values (?, ?);";
        PreparedStatement create = null;
        try {
            create = connection.prepareStatement(createStatement);

            // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
            create.setString(1, homeContinent);
            create.setInt(2, wildAnimalID);
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

    public HomeContinent getHomeContinent(int id) {
        Connection connection = pool.retrieve();
        HomeContinent newHomeContinent = new HomeContinent();
        ResultSet resultSet = null;
        String selectStatement = "select ? from HomeContinents where id = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(selectStatement);
            preparedStatement.setString(1, "*");
            preparedStatement.setInt(2, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int resultID = resultSet.getInt("ID");
            String homeContinent = resultSet.getString("HomeContinent");
            int wildAnimalID = resultSet.getInt("WildAnimal_ID");

            newHomeContinent.setContinentID(resultID);
            newHomeContinent.setContinent(homeContinent);
            newHomeContinent.setWildAnimalID(wildAnimalID);
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

        return newHomeContinent;
    }

    public void updateHomeContinent(int id) {
        Connection connection = pool.retrieve();
        String updateStatement = "update HomeContinents where id = ?;";

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
    public void deleteHomeContinent(int id) {
        Connection connection = pool.retrieve();
        String updateStatement = "delete from HomeContinents where id = ?;";
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
