package com.mycompany.app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private List<Connection> activeConnections = new ArrayList<>();
    private List<Connection> inactiveConnections = new ArrayList<>();

    public void initialize(int numOfConnections, String url, String user, String password) throws SQLException {
        for(int i = 0; i < numOfConnections; i++) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch(ClassNotFoundException cnfe) {

            }
            Connection connection = DriverManager.getConnection(url, user, password);
            this.inactiveConnections.add(connection);
        }
    }

    public Connection getConnection() {
        while(this.inactiveConnections.size() == 0) {

        }

        Connection connection = this.inactiveConnections.get(0);
        this.inactiveConnections.remove(connection);
        this.activeConnections.add(connection);

        return connection;
    }

    public void putBackConnection(Connection connection) {
        this.inactiveConnections.add(connection);
        this.activeConnections.remove(connection);
    }
}
