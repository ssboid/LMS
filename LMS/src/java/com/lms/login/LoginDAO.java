/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lms.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class LoginDAO {
    public boolean validate(LoginBean loginBean) throws SQLException, ClassNotFoundException {
        boolean status = false;
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/library", "root", "");
            PreparedStatement pst = con.prepareStatement("Select * from users where USERNAME=? and PASSWORD=?")) {
                   
            pst.setString(1, loginBean.getUsername());
            pst.setString(2, loginBean.getPassword());
            ///something is wrong here
            ResultSet rs = pst.executeQuery();
            status= rs.next();
            String statusa =String.valueOf(status);  
            System.out.println(statusa);
            
//            while(rs.next()){
////                String username = rs.getString("USERNAME");
////                String password = rs.getString("PASSWORD");
//            }
//            if (rs.next()) {
//                System.out.print("You are successfully loggedin...");
//                return true;
//    
//            } else {
//                System.out.println("Username or Password incorrect");
//                return false;
//
//            }
            
        }
        catch (SQLException e) {
        } 
        return status;
    }

}
