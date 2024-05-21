package mobiclick.application.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DennisMutethia
 */
public class DBConnect {

    private static final String URL = "jdbc:sqlite:pos.db";

    public static Connection getConnection() {
        try (Connection conn = DriverManager.getConnection(URL)) {
            if (conn != null) {
                System.out.println("Connected to the database.");
                return conn;                
            }
        } catch (SQLException e) {

        }        
        return null;
    }
}
