package com.mycompany.app.dao;

import com.mycompany.app.models.*;
import com.mycompany.app.database.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class AnimalDAO {
    ConnectionPool pool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(AnimalDAO.class);

    public void createAnimal(String type, String sex) {
        Connection connection = pool.retrieve();

        String createStatement = "insert into Animals (Type, Sex) values (?, ?);";
        PreparedStatement create = null;
        try {
            create = connection.prepareStatement(createStatement);
            // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
            create.setString(1, type);
            create.setString(2, sex);
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

    public Animal getAnimal(int id) {
        Connection connection = pool.retrieve();
        Animal animal = new Animal();
        ResultSet resultSet = null;
        String selectStatement = "select * from Animals where ID = ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(selectStatement);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            // https://stackoverflow.com/questions/2120255/resultset-exception-before-start-of-result-set
            resultSet.next();

            int resultID = resultSet.getInt("ID");
            String type = resultSet.getString("Type");
            String sex = resultSet.getString("Sex");

            animal.setID(resultID);
            animal.setType(type);
            animal.setSex(sex);
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

        return animal;
    }
    public void updateAnimal(int id, String type, String sex) {
        Connection connection = pool.retrieve();
        String updateStatement = "update Animals set Type = ?, Sex = ? where ID = ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(updateStatement);
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, sex);
            preparedStatement.setInt(3, id);
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
    public void deleteAnimal(int id) {
        Connection connection = pool.retrieve();
        String updateStatement = "delete from Animals where id = ?;";
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
