/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_management.controller;
import java.sql.*;
/**
 *
 * @author HCMUT
 */
public class ConnectDBController {
    private static Connection con;
    
    public Connection connectDB() {
        try {
            // Importing and registering drivers
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/project_management",
                "root", "123456");
            // here,root is the username and 1234 is the
            // password,you can set your own username and
            // password.
            return con;
        }
        catch (SQLException e) {
 
            System.out.println(e);
            return null;
        }
        
    }
    public Connection getConnection() {
        return con;
    }
}
