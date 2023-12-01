  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fatiq
 */
public class koneksi {
    private static Connection connection;
    
    public static Connection getConnection(){
        if (connection == null){
            try {
                String url = "jdbc:postgresql://localhost:5432/Cafe2K";
                String user = "postgres";
                String pass = "5127";
                connection = DriverManager.getConnection(url,user,pass);
            } catch (SQLException ex) {
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
}
