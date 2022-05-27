package com.lms.actions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
@WebServlet(urlPatterns = {"/AddBook"})
public class AddBook extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("add_books.html").forward(request, response);
        response.setContentType("text/html;charset=UTF-8");

           
              String book_name = request.getParameter("bname");
              String book_genre = request.getParameter("genre");
              int book_price = Integer.parseInt(request.getParameter("price"));
              
              try
              {
//connect to db
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  Connection con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/library", "root", "");
                  Statement stmt = con.createStatement();
// write to db
                    stmt.executeUpdate("insert into books (book_name,book_genre,book_price)"+"values ('"+book_name+"','"+book_genre+"','"+book_price+"')"); 
                    response.sendRedirect("http://localhost:8080/LMS/AddBook.java");
//                  PreparedStatement ps=con.prepareStatement("insert into books (book_name,book_genre,book_price) values (?,?,?)");
//                  ps.setString(1,book_name);
//                  ps.setString(2,book_genre);
//                  ps.setInt(3, book_price);
              }
              catch (ClassNotFoundException | SQLException ex)
              {
              }
          
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
