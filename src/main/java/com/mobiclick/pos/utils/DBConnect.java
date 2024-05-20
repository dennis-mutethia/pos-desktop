/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobiclick.pos.utils;

import com.mobiclick.pos.Init;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dennis Mutethia
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
                                    + Init.APPLICATION_PROPERTIES.getProperty("db_host") + ":"
                                    + Init.APPLICATION_PROPERTIES.getProperty("db_port") + "/"
                                    + Init.APPLICATION_PROPERTIES.getProperty("db_name"),
                            Init.APPLICATION_PROPERTIES.getProperty("db_user"),
                            Init.APPLICATION_PROPERTIES.getProperty("db_user_password")
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
