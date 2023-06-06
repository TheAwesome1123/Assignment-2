package com.mycompany.app.dao;

import com.mycompany.app.database.ConnectionPool;
import com.mycompany.app.models.DomesticOrWildColor;

import java.sql.*;

public class DomesticOrWildColorDAO {
    ConnectionPool pool = ConnectionPool.getInstance();

    public void createDomesticOrWildColor(String color, String shade) {
        Connection connection = pool.retrieve();
        String createStatement = "insert into DomesticOrWildColors (Color, Shade) values (?, ?);";
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
                System.out.println(e);
            }
        }
    }

    public DomesticOrWildColor getDomesticOrWildColor(int id) {
        Connection connection = pool.retrieve();
        DomesticOrWildColor domesticOrWildColor = new DomesticOrWildColor();
        ResultSet resultSet = null;
        String selectStatement = "select ? from DomesticOrWildColors where id = ?;";
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

            domesticOrWildColor.setColorID(resultID);
            domesticOrWildColor.setColor(color);
            domesticOrWildColor.setShade(shade);
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
                System.out.println(e);
            }
        }

        return domesticOrWildColor;
    }

    public void updateDomesticOrWildColor(int id) {
        Connection connection = pool.retrieve();
        String updateStatement = "update DomesticOrWildColors where id = ?;";
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
                System.out.println(e);
            }
        }

    }
    public void deleteDomesticOrWildColor(int id) {
        Connection connection = pool.retrieve();
        String updateStatement = "delete from DomesticOrWildColors where id = ?;";
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
                System.out.println(e);
            }
        }
    }
}
