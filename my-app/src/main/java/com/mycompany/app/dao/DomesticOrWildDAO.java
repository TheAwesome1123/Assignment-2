package com.mycompany.app.dao;

import com.mycompany.app.database.DatabaseMain;
import com.mycompany.app.models.DomesticOrWild;
import com.mycompany.app.database.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DomesticOrWildDAO {
    public void createDomesticOrWildAnimal(ConnectionPool pool, String type, boolean isDomesticated, String name,
        int ownerID, int animalID) throws SQLException {
            String isDomesticatedColumnVal;
            if(isDomesticated) {
                isDomesticatedColumnVal = "True";
            }
            else {
                isDomesticatedColumnVal = "False";
            }

            Connection connection = pool.getConnection();
            String createStatement = "insert into DomesticOrWilds (Type, IsDomesticated, Animal_ID) values (?, ?, ?);";
            PreparedStatement create = connection.prepareStatement(createStatement);

            // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
            create.setString(1, type);
            create.setString(2, isDomesticatedColumnVal);
            create.setInt(3, animalID);
            create.executeUpdate();

            pool.putBackConnection(connection);
    }

    public DomesticOrWild getDomesticOrWildAnimal(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String selectStatement = "select ? from DomesticOrWilds where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

        preparedStatement.setString(1, "*");
        preparedStatement.setInt(2, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        pool.putBackConnection(connection);

        int resultID = resultSet.getInt("ID");
        String type = resultSet.getString("Type");
        String isDomesticated = resultSet.getString("IsDomesticated");
        int animalID = resultSet.getInt("Animal_ID");

        DomesticOrWild domesticatedOrWild = new DomesticOrWild();

        domesticatedOrWild.setDomesticOrWildID(resultID);
        domesticatedOrWild.setDomesticOrWildType(type);
        domesticatedOrWild.setDomesticated(isDomesticated.equals("True"));
        domesticatedOrWild.setAnimalID(animalID);
        return domesticatedOrWild;
    }

    public void updateDomesticOrWildAnimal(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "update DomesticOrWilds where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }

    public void deletedDomesticOrWildAnimal(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "delete from DomesticOrWilds where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }

}
