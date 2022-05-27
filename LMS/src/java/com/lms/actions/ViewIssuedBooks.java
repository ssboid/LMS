package com.lms.actions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
@WebServlet(urlPatterns = {"/ViewIssuedBooks"})
public class ViewIssuedBooks extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //page header
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"pages.css\">");
            out.println("<title>Issued Books | Library Management System</title>");            
            out.println("</head>");
            out.println("<body id=\"bg\">");
            out.println("<div id=\"head\"><a href=\"http://localhost:8080/LMS/Welcome\"><div id=\"hbutton\"><h1>Library Management System</h1></div></a></div>");
            out.println("<div id=\"head2\"><p>Issued Books</p></div>");
            
            try {
                //connect to db
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/library", "root", "");
                Statement stmt = con.createStatement();
                //display content from table in db
                ResultSet rs = stmt.executeQuery("select * from issued_books");
                if (rs.isBeforeFirst()) {
                    out.println("<table id=\"table\"><tr>"
                            + "<th class=\"id\">Issue ID</th>"
                            + "<th class=\"bname\">Book Name</th>"
                            + "<th class=\"idate\">Issue Date</th>"
                            + "<th class=\"period\">Period</th>"
                            + "</tr>");
                    while (rs.next()) {
                    out.println("<tr><td class=\"id\">" + rs.getInt(1) + "</td><td class=\"bname\">" + rs.getString(2) + "</td><td class=\"idate\">" + rs.getString(3) + "</td><td class=\"period\">" + rs.getString(4) + "</td></tr>");
                    }   
                    out.println("</table>");
                }
                con.close();
            } catch (Exception e) {
                System.out.println("error");
                System.out.println(e);
                out.println("<h1>Error</h1> " + e);
            }
            out.println("</body>");
            out.println("</html>");
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
