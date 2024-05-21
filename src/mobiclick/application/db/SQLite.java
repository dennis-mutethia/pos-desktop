package mobiclick.application.db;

/**
 *
 * @author DennisMutethia
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLite {

    final static Logger logger = Logger.getLogger(SQLite.class.getName());
    private static final String URL = "jdbc:sqlite:sample.db";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL)) {
            if (conn != null) {
                System.out.println("Connected to the database.");

                createTable(conn);
                //createRecord(conn, "John Doe", 30);
                //readRecords(conn);
                //updateRecord(conn, 1, "Jane Doe", 25);
                //deleteRecord(conn, 1);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "{0}", e);
        }
    }

    public static void createTable(Connection conn) {
        String sql = "INSERT OR IGNORE INTO user_roles(name,description) \n" +
"VALUES\n" +
"    ('Admin','All Permissions'), \n" +
"    ('Supervisor','Supervisor Permissions'), \n" +
"    ('Cashier','Cashier Permissions'), \n" +
"    ('Waiter','Waiter Permissions')";
        
        System.out.println(sql);
        /*
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                + " id integer PRIMARY KEY, "
                + " name text NOT NULL, "
                + " age integer "
                + ");";
         */

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "{0}", e);
        }
    }

    public static void createRecord(Connection conn, String name, int age) {
        String sql = "INSERT INTO users(name, age) VALUES(?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            int success = pstmt.executeUpdate();
            if (success == 1) {
                System.out.println("Record inserted.");
            } else {
                System.out.println("Record not inserted.");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "{0}", e);
        }
    }

    public static void readRecords(Connection conn) {
        String sql = "SELECT id, name, age FROM users";

        try (Statement stmt = conn.createStatement(); 
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t"
                        + rs.getString("name") + "\t"
                        + rs.getInt("age"));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "{0}", e);
        }
    }

    public static void updateRecord(Connection conn, int id, String name, int age) {
        String sql = "UPDATE users SET name = ? , "
                + "age = ? "
                + "WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
            int success = pstmt.executeUpdate();
            if (success == 1) {
                System.out.println("Record updated.");
            } else {
                System.out.println("Record not updated.");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "{0}", e);
        }
    }

    public static void deleteRecord(Connection conn, int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int success = pstmt.executeUpdate();
            if (success == 1) {
                System.out.println("Record deleted.");
            } else {
                System.out.println("Record not deleted.");
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "{0}", e);
        }
    }
}
