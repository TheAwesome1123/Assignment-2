package com.mycompany.app.dao.jdbc;

import com.mycompany.app.database.jdbc.ConnectionPool;
import com.mycompany.app.models.DomesticOrWildAnimalAndColorRelation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DomesticOrWildAnimalsAndColorsDAO {
    ConnectionPool pool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(DomesticOrWildAnimalsAndColorsDAO.class);

    public void createDomesticOrWildAnimalAndColorRelation(int domesticOrWildAnimalID, int colorID) {
        Connection connection = pool.retrieve();
        String createStatement = "insert into DomesticOrWildAnimalsAndColors (DomesticOrWildAnimal_ID, Color_ID) " +
            "values (?, ?);";
        PreparedStatement create = null;

        try {
            create = connection.prepareStatement(createStatement);
            // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
            create.setInt(1, domesticOrWildAnimalID);
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

    public DomesticOrWildAnimalAndColorRelation getDomesticOrWildAnimalAndColorRelation(int id) {
        Connection connection = pool.retrieve();
        DomesticOrWildAnimalAndColorRelation relation = new DomesticOrWildAnimalAndColorRelation();
        ResultSet resultSet = null;
        String selectStatement = "select ? from DomesticOrWildAnimalsAndColors where id = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(selectStatement);
            preparedStatement.setString(1, "*");
            preparedStatement.setInt(2, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int resultID = resultSet.getInt("ID");
            int domesticOrWildAnimalId = resultSet.getInt("DomesticOrWildAnimal_ID");
            int colorID = resultSet.getInt("Color_ID");

            relation.setRelationID(resultID);
            relation.setDomesticOrWildAnimalID(domesticOrWildAnimalId);
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

    public void updateDomesticOrWildAnimalAndColorRelation(int id, int domesticOrWildAnimalID, int colorID) {
        Connection connection = pool.retrieve();
        String updateStatement = "update DomesticOrWildAnimalsAndColors set DomesticOrWildAnimal_ID = ?, Color_ID = ? " +
            "where id = ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(updateStatement);
            preparedStatement.setInt(1, domesticOrWildAnimalID);
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
    public void deleteDomesticOrWildAnimalAndColorRelation(int id, int domesticOrWildID, int colorID) {
        Connection connection = pool.retrieve();
        String updateStatement =
            "delete from DomesticOrWildAnimalsAndColors where id = ? and DomesticOrWildAnimal_ID = ? and Color_ID = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(updateStatement);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, domesticOrWildID);
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
