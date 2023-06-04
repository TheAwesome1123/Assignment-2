package com.mycompany.app.dao;

import com.mycompany.app.models.*;
import com.mycompany.app.database.ConnectionPool;
import java.sql.*;

public class PetDAO {
    public void createPet(ConnectionPool pool, String type, String name, int ownerID, int animalID)
        throws SQLException {
            Connection connection = pool.getConnection();
            String createStatement = "insert into Pets (Type, Name, Owner_ID, Animal_ID) values (?, ?, ?, ?);";
            PreparedStatement create = connection.prepareStatement(createStatement);

            // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
            create.setString(1, type);
            create.setString(2, name);
            create.setInt(3, ownerID);
            create.setInt(4, animalID);
            create.executeUpdate();
            pool.putBackConnection(connection);
    }

    public Pet getPet(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String selectStatement = "select ? from Pets where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

        preparedStatement.setString(1, "*");
        preparedStatement.setInt(2, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        pool.putBackConnection(connection);

        int resultID = resultSet.getInt("animalID");
        String type = resultSet.getString("Type");
        String name = resultSet.getString("Name");
        int ownerID = resultSet.getInt("Owner_ID");
        int animalID = resultSet.getInt("Animal_ID");

        Pet pet;
        if(type.equals("Dog")) {
            pet = new Dog();

        }
        else {
            pet = new Cat();

        }

        pet.setPetID(resultID);
        pet.setType(type);
        pet.setName(name);
        pet.setOwnerID(ownerID);
        pet.setAnimalID(animalID);
        return pet;
    }
    public void updatePet(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "update Pets where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
    public void deletePet(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "delete from Pets where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
}
