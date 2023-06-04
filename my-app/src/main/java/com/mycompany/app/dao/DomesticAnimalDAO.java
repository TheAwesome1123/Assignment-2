package com.mycompany.app.dao;

import com.mycompany.app.models.DomesticAnimal;
import com.mycompany.app.database.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DomesticAnimalDAO {
    public void createDomesticAnimal(ConnectionPool pool, String name, int ownerID, int domesticOrWildID)
        throws SQLException {
            Connection connection = pool.getConnection();
            String createStatement = "insert into DomesticAnimals (Name, Owner_ID, DomesticOrWild_ID) values " +
                "(?, ?, ?);";
            PreparedStatement create = connection.prepareStatement(createStatement);

            // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
            create.setString(1, name);
            create.setInt(2, ownerID);
            create.setInt(3, domesticOrWildID);
            create.executeUpdate();

            pool.putBackConnection(connection);
    }

    public DomesticAnimal getDomesticAnimal(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String selectStatement = "select ? from DomesticAnimals where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

        preparedStatement.setString(1, "*");
        preparedStatement.setInt(2, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        pool.putBackConnection(connection);

        int resultID = resultSet.getInt("ID");
        String name = resultSet.getString("Name");
        int owner = resultSet.getInt("Owner_ID");
        int domesticOrWildID = resultSet.getInt("DomesticOrWild_ID");

        DomesticAnimal domesticAnimal = new DomesticAnimal();
//
//        if(type.equals("Bird")) {
//            domesticatedOrWild = new Bird();
//        }
//        else {
//            domesticatedOrWild = new Horse();
//        }


        domesticAnimal.setDomesticAnimalID(resultID);
        domesticAnimal.setName(name);
        domesticAnimal.setOwnerID(owner);
        domesticAnimal.setDomesticOrWildID(domesticOrWildID);

        return domesticAnimal;
    }

    public void updateDomesticOrWildAnimal(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "update DomesticAnimals where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }

    public void deletedDomesticOrWildAnimal(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "delete from DomesticAnimals where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
}
