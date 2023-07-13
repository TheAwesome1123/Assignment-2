package com.mycompany.app.dao.jdbc;

import com.mycompany.app.services.jdbc.ConnectionPool;
import com.mycompany.app.models.WildAnimalAndColorRelation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class WildAnimalsAndColorsDAO {
    ConnectionPool pool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(WildAnimalsAndColorsDAO.class);

    public void createWildAnimalAndColorRelation(int wildAnimalID, int colorID) {
        Connection connection = pool.retrieve();
        String createStatement = "insert into WildAnimalsAndColors (WildAnimal_ID, Color_ID) values (?, ?);";
        PreparedStatement create = null;

        try {
            create = connection.prepareStatement(createStatement);

            // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
            create.setInt(1, wildAnimalID);
            create.setInt(2, colorID);
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

    public WildAnimalAndColorRelation getWildAnimalAndColorRelation(int id) {
        Connection connection = pool.retrieve();
        WildAnimalAndColorRelation relation = new WildAnimalAndColorRelation();
        ResultSet resultSet = null;
        String selectStatement = "select ? from WildAnimalsAndColors where id = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(selectStatement);
            preparedStatement.setString(1, "*");
            preparedStatement.setInt(2, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int resultID = resultSet.getInt("ID");
            int wildAnimalID = resultSet.getInt("WildAnimal_ID");
            int colorID = resultSet.getInt("Color_ID");

            relation.setRelationID(resultID);
            relation.setWildAnimalID(wildAnimalID);
            relation.setColorID(colorID);
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

        return relation;
    }

    public void updateWildAnimalAndColorRelation(int id, int wildAnimalID, int colorID) {
        Connection connection = pool.retrieve();
        String updateStatement = "update WildAnimalsAndColors set WildAnimal_ID = ?, Color_ID = ? where id = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(updateStatement);
            preparedStatement.setInt(1, wildAnimalID);
            preparedStatement.setInt(2, colorID);
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
    public void deleteWildAnimalAndColorRelation(int id, int wildAnimalID, int colorID) {
        Connection connection = pool.retrieve();
        String updateStatement = "delete from WildAnimalsAndColors where id = ? and WildAnimal_ID = ? and Color_ID = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(updateStatement);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, wildAnimalID);
            preparedStatement.setInt(3, colorID);
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
