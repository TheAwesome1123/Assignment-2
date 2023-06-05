package com.mycompany.app.dao;

import com.mycompany.app.models.Dog;
import com.mycompany.app.database.ConnectionPool;

import java.sql.*;

public class DogDAO {
    public void createDog(ConnectionPool pool, String breed, int petID)
            throws SQLException {
        Connection connection = pool.getConnection();
        String createStatement = "insert into Dogs (Breed, Pet_ID) values (?, ?);";
        PreparedStatement create = connection.prepareStatement(createStatement);

        // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
        create.setString(1, breed);
        create.setInt(2, petID);
        create.executeUpdate();
        pool.putBackConnection(connection);
    }

    public Dog getDog(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String selectStatement = "select ? from Dogs where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

        preparedStatement.setString(1, "*");
        preparedStatement.setInt(2, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        pool.putBackConnection(connection);

        int resultID = resultSet.getInt("ID");
        String breed = resultSet.getString("Breed");
        int petID = resultSet.getInt("Pet_ID");

        Dog dog = new Dog();

        dog.setDogID(resultID);
        dog.setBreed(breed);
        dog.setPetID(petID);

        return dog;
    }

    public void updateDog(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "update Dogs where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
    public void deleteDog(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "delete from Dogs where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
}
