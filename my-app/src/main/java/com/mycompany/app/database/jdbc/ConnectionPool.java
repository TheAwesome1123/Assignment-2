package com.mycompany.app.database.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
import org.apache.logging.log4j.*;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static final int CON_POOL_SIZE = 5;
    private static Properties p = new Properties();
    private static final String userName;
    private static final String url;
    private static final String password;
    private static String driver;
    private Vector<Connection> conPool = new Vector<>(CON_POOL_SIZE, 1);
    private Vector<Connection> activeConnections = new Stack<>();

    static {
        try (FileInputStream f = new FileInputStream("my-app/src/main/resources/db.properties")) {
            p.load(f);
        }
        catch (IOException e) {
            LOGGER.info(e);
        }
        url = p.getProperty("db.url");
        userName = p.getProperty("db.username");
        password = p.getProperty("db.password");
    }

    private ConnectionPool() {
        for (int i = 0; i < CON_POOL_SIZE; i++) {
            Connection connection = null;

            try {
                driver = p.getProperty("db.driver");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, userName, password);
            }
            catch (Exception e) {
                LOGGER.info(e);
            }

            conPool.add(connection);
        }
    }
    private static ConnectionPool instance = null;

    public static ConnectionPool getInstance() {
        if (instance == null) instance = new ConnectionPool();
        return instance;
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
        }
        catch (Exception e) {
            LOGGER.info(e);
        }

        return conn;
    }

    public synchronized Connection retrieve() {
        Connection newConn = null;

        if (conPool.size() == 0) {
            newConn = getConnection();
        }
        else {
            newConn = (Connection) conPool.lastElement();
            conPool.removeElement(newConn);
        }

        activeConnections.addElement(newConn);
        LOGGER.info("The connection was retrieved: " + newConn.toString());
        return newConn;
    }

    public synchronized void putBack(Connection c) {
        if (c != null) {
            if (activeConnections.removeElement(c)) {
                conPool.addElement(c);
                LOGGER.info("Putting the connection back to Connection pool: " + c.toString());
            }
            else {
                throw new NullPointerException("Connection is not in the Active Connections array");
            }
        }
    }
}