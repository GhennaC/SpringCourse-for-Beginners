package org.testdb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/testdbServlet")
public class testdbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // setup connection variables
        String user = "springstudent";
        String pass = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";

        String driver = "com.mysql.jdbc.Driver";

        //get connection to database
        try{
            PrintWriter out = response.getWriter();

            out.println("Connecting to database: "+jdbcUrl);

            Class.forName(driver);

            Connection connection = DriverManager.getConnection(jdbcUrl,user,pass);

            out.println("connection succesfull");

            connection.close();
        }catch (Exception e ) {
            e.printStackTrace();
            throw new ServletException(e);
        }



    }

}
