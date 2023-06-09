package com.mycompany.app.dao;

import com.mycompany.app.models.DomesticOrWild;
import com.mycompany.app.database.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DomesticOrWildDAO {
    ConnectionPool pool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(DomesticOrWildDAO.class);

    public void createDomesticOrWildAnimal(String type, boolean isDomesticated, String name, int ownerID, int animalID) {
        String isDomesticatedColumnVal;
        if(isDomesticated) {
            isDomesticatedColumnVal = "True";
        }
        else {
            isDomesticatedColumnVal = "False";
        }

        Connection connection = pool.retrieve();
        String createStatement = "insert into DomesticOrWilds (Type, IsDomesticated, Animal_ID) values (?, ?, ?);";
        PreparedStatement create = null;

        try {
            create = connection.prepareStatement(createStatement);

            // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
            create.setString(1, type);
            create.setString(2, isDomesticatedColumnVal);
            create.setInt(3, animalID);
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

    public DomesticOrWild getDomesticOrWildAnimal(int id) {
        Connection connection = pool.retrieve();
        DomesticOrWild domesticatedOrWild = new DomesticOrWild();
        ResultSet resultSet = null;
        String selectStatement = "select ? from DomesticOrWilds where id = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(selectStatement);
            preparedStatement.setString(1, "*");
            preparedStatement.setInt(2, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int resultID = resultSet.getInt("ID");
            String type = resultSet.getString("Type");
            String isDomesticated = resultSet.getString("IsDomesticated");
            int animalID = resultSet.getInt("Animal_ID");

            domesticatedOrWild.setDomesticOrWildID(resultID);
            domesticatedOrWild.setDomesticOrWildType(type);
            domesticatedOrWild.setDomesticated(isDomesticated.equals("True"));
            domesticatedOrWild.setAnimalID(animalID);
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

        return domesticatedOrWild;
    }

    public void updateDomesticOrWildAnimal(int id, String isDomesticated) {
        Connection connection = pool.retrieve();
        String updateStatement = "update DomesticOrWilds set IsDomesticated = ? where id = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(updateStatement);
            preparedStatement.setString(1, isDomesticated);
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

    public void deletedDomesticOrWildAnimal(int id) {
        Connection connection = pool.retrieve();
        String updateStatement = "delete from DomesticOrWilds where id = ?;";
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
