package mobiclick.application.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mobiclick.application.Application;

/**
 *
 * @author vinayak
 */
public class DBConnect {
    
    private static Connection con = null;

    public static Connection getConnection() {
        try {
            if(con ==null || !con.isValid(1) || con.isClosed())
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection(
                            "jdbc:mysql://"
                                    + Application.APPLICATION_PROPERTIES.getProperty("db_host") + ":"
                                    + Application.APPLICATION_PROPERTIES.getProperty("db_port") + "/"
                                    + Application.APPLICATION_PROPERTIES.getProperty("db_name"),
                            Application.APPLICATION_PROPERTIES.getProperty("db_user"),
                            Application.APPLICATION_PROPERTIES.getProperty("db_user_password")
                    );
                    
                } catch (ClassNotFoundException | SQLException e) {
                    System.out.println("Error" + e);
                }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
}
