package com.mycompany.app.dao.jdbc;

import com.mycompany.app.services.jdbc.ConnectionPool;
import com.mycompany.app.models.WildAnimalColor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class WildAnimalColorDAO {
    ConnectionPool pool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(WildAnimalColorDAO.class);

    public void createWildAnimalColor(String color, String shade) {
        Connection connection = pool.retrieve();
        String createStatement = "insert into WildAnimalColors (Color, Shade) values (?, ?);";
        PreparedStatement create = null;

        try {
            create = connection.prepareStatement(createStatement);

            // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
            create.setString(1, color);
            create.setString(2, shade);
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

    public WildAnimalColor getWildAnimalColor(int id) {
        Connection connection = pool.retrieve();
        WildAnimalColor wildAnimalColor = new WildAnimalColor();
        ResultSet resultSet = null;
        String selectStatement = "select ? from WildAnimalColors where id = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(selectStatement);
            preparedStatement.setString(1, "*");
            preparedStatement.setInt(2, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int resultID = resultSet.getInt("ID");
            String color = resultSet.getString("Color");
            String shade = resultSet.getString("Shade");

            wildAnimalColor.setColorID(resultID);
            wildAnimalColor.setColor(color);
            wildAnimalColor.setShade(shade);
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

        return wildAnimalColor;
    }

    public void updateWildAnimalColor(int id, String color, String shade) {
        Connection connection = pool.retrieve();
        String updateStatement = "update WildAnimalColors set Color = ?, Shade = ? where id = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(updateStatement);
            preparedStatement.setString(1, color);
            preparedStatement.setString(2, shade);
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
    public void deleteWildAnimalColor(int id) {
        Connection connection = pool.retrieve();
        String updateStatement = "delete from WildAnimalColors where id = ?;";
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
