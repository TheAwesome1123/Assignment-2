package com.mycompany.app.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMethods {
    public int getNumOfEntriesInTable(ConnectionPool connectionPool, String tableName) throws SQLException {
        Connection connection = connectionPool.getConnection();

        String selectStatement = "select count(*) as NumEntries from ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

        preparedStatement.setString(1, tableName);
        ResultSet resultSet = preparedStatement.executeQuery();
        connectionPool.putBackConnection(connection);

        return resultSet.getInt("NumEntries");
    }
}
