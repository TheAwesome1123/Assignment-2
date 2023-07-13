package com.mycompany.app.dao.jdbc;

import com.mycompany.app.models.Cat;
import com.mycompany.app.services.jdbc.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class CatDAO {
    ConnectionPool pool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(CatDAO.class);

    public void createCat(String breed, int petID) {
        Connection connection = pool.retrieve();
        String createStatement = "insert into Cats (Breed, Pet_ID) values (?, ?);";
        PreparedStatement create = null;
        try {
            // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
            create = connection.prepareStatement(createStatement);
            create.setString(1, breed);
            create.setInt(2, petID);
            create.executeUpdate();
        }
        catch (SQLException e) {
            LOGGER.info(e);
        }
        finally {
            try {
                if (connection != null) pool.putBack(connection);
                if (create != null) create.close();
            }
            catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    public Cat getCat(int id) {
        Connection connection = pool.retrieve();
        ResultSet resultSet = null;
        Cat cat = new Cat();
        String selectStatement = "select ? from Cats where id = ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(selectStatement);
            preparedStatement.setString(1, "*");
            preparedStatement.setInt(2, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int resultID = resultSet.getInt("ID");
            String breed = resultSet.getString("Breed");
            int petID = resultSet.getInt("Pet_ID");

            cat.setCatID(resultID);
            cat.setBreed(breed);
            cat.setPetID(petID);
        }
        catch (SQLException e) {
            LOGGER.info(e);
        }
        finally {
            try {
                if (connection != null) pool.putBack(connection);
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            }
            catch (SQLException e) {
                LOGGER.info(e);
            }
        }

        return cat;
    }
    public void updateCat(int id, String breed) {
        Connection connection = pool.retrieve();
        String updateStatement = "update Cats set Breed = ? where id = ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(updateStatement);
            preparedStatement.setString(1, breed);
            preparedStatement.setInt(2, id);

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
                LOGGER.info(e);
            }
        }
    }

    public void deleteCat(int id) {
        Connection connection = pool.retrieve();
        String updateStatement = "delete from Cats where id = ?;";
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
                LOGGER.info(e);
            }
        }
    }
}
