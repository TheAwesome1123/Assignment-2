package com.mycompany.app.dao.jdbc;

import com.mycompany.app.models.WildAnimal;
import com.mycompany.app.database.jdbc.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WildAnimalDAO {
    ConnectionPool pool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(WildAnimalDAO.class);

    public void createWildAnimal(String type, int animalID) {
        Connection connection = pool.retrieve();
        String createStatement = "insert into WildAnimals (Type, Animal_ID) values (?, ?);";
        PreparedStatement create = null;

        try {
            create = connection.prepareStatement(createStatement);

            // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
            create.setString(1, type);
            create.setInt(2, animalID);
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

    public WildAnimal getWildAnimal(int id) {
        Connection connection = pool.retrieve();
        WildAnimal wildAnimal = new WildAnimal();
        ResultSet resultSet = null;
        String selectStatement = "select * from WildAnimals where ID = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(selectStatement);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int resultID = resultSet.getInt("ID");
            String type = resultSet.getString("Type");
            int animalID = resultSet.getInt("Animal_ID");
            int weight = resultSet.getInt("Weight");

            wildAnimal.setWildAnimalID(resultID);
            wildAnimal.setWildAnimalType(type);
            wildAnimal.setAnimalID(animalID);
            wildAnimal.setWeight(weight);
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

        return wildAnimal;
    }
    public void updateWildAnimalWeight(int id, int weight) {
        Connection connection = pool.retrieve();
        String updateStatement = "update WildAnimals set Weight = ? where id = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(updateStatement);
            preparedStatement.setInt(1, weight);
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
    public void deleteWildAnimal(int id) {
        Connection connection = pool.retrieve();
        String updateStatement = "delete from WildAnimals where id = ?;";
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