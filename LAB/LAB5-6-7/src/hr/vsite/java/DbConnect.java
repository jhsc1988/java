package hr.vsite.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DbConnect {

    // logger
    private static final Logger log = LoggerFactory.getLogger(ChatClient.class);

    public static Connection db_connect() throws SQLException {
        log.info("db_connect() enter");

        Connection connection = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://F00BAR\\SQLEXPRESS:1433;databaseName=java_lab;integratedSecurity=true;";
            connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException | ClassNotFoundException e) {
            log.info("db connection error", e);
            connection.close();
        }

        log.info("Database connection OK");
        log.info("db_connect() exit");
        return connection;
    }
}