package com.mycompany.app.dao.jdbc;

import com.mycompany.app.models.*;
import com.mycompany.app.database.jdbc.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class PetDAO {
    ConnectionPool pool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(PetDAO.class);

    public void createPet(String type, String name, int ownerID, int animalID) {
        Connection connection = pool.retrieve();
        String createStatement = "insert into Pets (Type, Name, Owner_ID, Animal_ID) values (?, ?, ?, ?);";
        PreparedStatement create = null;

        try {
            create = connection.prepareStatement(createStatement);

            // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
            create.setString(1, type);
            create.setString(2, name);
            create.setInt(3, ownerID);
            create.setInt(4, animalID);
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

    public Pet getPet(int id) {
        Connection connection = pool.retrieve();
        Pet pet = new Pet();
        ResultSet resultSet = null;
        String selectStatement = "select * from Pets where id = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(selectStatement);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int resultID = resultSet.getInt("ID");
            String type = resultSet.getString("Type");
            String name = resultSet.getString("Name");
            int ownerID = resultSet.getInt("Owner_ID");
            int animalID = resultSet.getInt("Animal_ID");
            int age = resultSet.getInt("Age");

            pet.setPetID(resultID);
            pet.setPetType(type);
            pet.setName(name);
            pet.setOwnerID(ownerID);
            pet.setAnimalID(animalID);
            pet.setAge(age);
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

        return pet;
    }

    public void updatePetAge(int id, int age) {
        Connection connection = pool.retrieve();
        String updateStatement = "update Pets set Age = ? where id = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(updateStatement);
            preparedStatement.setInt(1, age);
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

    public void deletePet(int id) {
        Connection connection = pool.retrieve();
        String updateStatement = "delete from Pets where ID = ?;";
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
