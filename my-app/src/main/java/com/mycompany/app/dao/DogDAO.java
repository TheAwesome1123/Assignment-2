package com.mycompany.app.dao;

import com.mycompany.app.models.Dog;
import com.mycompany.app.database.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DogDAO {
    ConnectionPool pool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(DogDAO.class);

    public void createDog(String breed, int petID) {
        Connection connection = pool.retrieve();
        String createStatement = "insert into Dogs (Breed, Pet_ID) values (?, ?);";
        PreparedStatement create = null;
        try {
            create = connection.prepareStatement(createStatement);

            // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
            create.setString(1, breed);
            create.setInt(2, petID);
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
                LOGGER.info(e);
            }
        }
    }

    public Dog getDog(int id) {
        Connection connection = pool.retrieve();
        Dog dog = new Dog();
        ResultSet resultSet = null;
        String selectStatement = "select ? from Dogs where id = ?;";
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

            dog.setDogID(resultID);
            dog.setBreed(breed);
            dog.setPetID(petID);
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
                LOGGER.info(e);
            }
        }

        return dog;
    }

    public void updateDog(int id) {
        Connection connection = pool.retrieve();
        String updateStatement = "update Dogs where id = ?;";
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
    public void deleteDog(int id) {
        Connection connection = pool.retrieve();
        String updateStatement = "delete from Dogs where id = ?;";
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
