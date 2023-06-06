package com.mycompany.app.dao;

import com.mycompany.app.models.DomesticAnimal;
import com.mycompany.app.database.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DomesticAnimalDAO {
    ConnectionPool pool = ConnectionPool.getInstance();

    public void createDomesticAnimal(String name, int ownerID, int domesticOrWildID) {
        Connection connection = pool.retrieve();
        String createStatement = "insert into DomesticAnimals (Name, Owner_ID, DomesticOrWild_ID) values " +
            "(?, ?, ?);";
        PreparedStatement create = null;

        try {
            create = connection.prepareStatement(createStatement);

            // https://stackoverflow.com/questions/1639269/java-enum-to-mysql-enum-in-prepared-statement
            create.setString(1, name);
            create.setInt(2, ownerID);
            create.setInt(3, domesticOrWildID);
            create.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (connection != null) pool.putBack(connection);
                if (create != null) create.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public DomesticAnimal getDomesticAnimal(int id) {
        Connection connection = pool.retrieve();
        DomesticAnimal domesticAnimal = new DomesticAnimal();
        ResultSet resultSet = null;
        String selectStatement = "select ? from DomesticAnimals where id = ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(selectStatement);
            preparedStatement.setString(1, "*");
            preparedStatement.setInt(2, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int resultID = resultSet.getInt("ID");
            String name = resultSet.getString("Name");
            int owner = resultSet.getInt("Owner_ID");
            int domesticOrWildID = resultSet.getInt("DomesticOrWild_ID");

            domesticAnimal.setDomesticAnimalID(resultID);
            domesticAnimal.setName(name);
            domesticAnimal.setOwnerID(owner);
            domesticAnimal.setDomesticOrWildID(domesticOrWildID);
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

        return domesticAnimal;
    }

    public void updateDomesticOrWildAnimal(int id)  {
        Connection connection = pool.retrieve();
        String updateStatement = "update DomesticAnimals where id = ?;";
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

    public void deleteDomesticOrWildAnimal(int id) {
        Connection connection = pool.retrieve();
        String updateStatement = "delete from DomesticAnimals where id = ?;";
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
