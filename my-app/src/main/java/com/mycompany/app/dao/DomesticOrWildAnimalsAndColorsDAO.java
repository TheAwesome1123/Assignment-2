package com.mycompany.app.dao;

import com.mycompany.app.database.ConnectionPool;
import com.mycompany.app.models.WildAnimalAndColorRelation;

import java.sql.*;

public class DomesticOrWildAnimalsAndColorsDAO {
    public void createDomesticOrWildAnimalAndColorRelation(ConnectionPool pool, int domesticOrWildAnimalID, int colorID)
            throws SQLException {
        Connection connection = pool.getConnection();
        String createStatement = "insert into DomesticOrWildAnimalsAndColors (DomesticOrWildAnimal_ID, Color_ID) " +
            "values (?, ?);";
        PreparedStatement create = connection.prepareStatement(createStatement);

        // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
        create.setInt(1, domesticOrWildAnimalID);
        create.setInt(2, colorID);
        create.executeUpdate();
        pool.putBackConnection(connection);
    }

    public WildAnimalAndColorRelation getDomesticOrWildAnimalAndColorRelation(ConnectionPool pool, int id)
            throws SQLException {
        Connection connection = pool.getConnection();
        String selectStatement = "select ? from DomesticOrWildAnimalsAndColors where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

        preparedStatement.setString(1, "*");
        preparedStatement.setInt(2, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        pool.putBackConnection(connection);

        int resultID = resultSet.getInt("ID");
        int wildAnimalID = resultSet.getInt("DomesticOrWildAnimal_ID");
        int colorID = resultSet.getInt("Color_ID");

        WildAnimalAndColorRelation relation = new WildAnimalAndColorRelation();
        relation.setRelationID(resultID);
        relation.setWildAnimalID(wildAnimalID);
        relation.setColorID(colorID);

        return relation;
    }

    public void updateDomesticOrWildAnimalAndColorRelation(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "update DomesticOrWildAnimalsAndColors where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
    public void deleteDomesticOrWildAnimalAndColorRelation(ConnectionPool pool, int id) throws SQLException {
        Connection connection = pool.getConnection();
        String updateStatement = "delete from DomesticOrWildAnimalsAndColors where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        pool.putBackConnection(connection);
    }
}
