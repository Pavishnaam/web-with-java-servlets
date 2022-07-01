/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PAVISHNA
 */
public class bookServlet extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("Inside Servlet....");
response.setContentType("text/html");
final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
final String DB_URL="jdbc:mysql://localhost:3306/pavidb?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
final String USER="root";
final String PASS="987654321";
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
System.out.println("DB connected....");
PrintWriter out = response.getWriter();
Statement stmt=conn.createStatement();
String s1=request.getParameter("b_name");
String s2=request.getParameter("a_name");
int s3=Integer.valueOf(request.getParameter("quantity"));
int s4=Integer.valueOf(request.getParameter("price"));

 stmt.executeUpdate("insert into book values('"+s1+"','"+s2+"',"+s3+","+s4+");");
out.println("<html>\n" +
"<body bgcolor = \"#f0f0f0\">\n" +
"<h1 align = \"center\">" + "VALUES INSERTED SUCCESFULLY" + "</h1>\n" +
"</body>\n"+
"</html>"        
);
int cost = s3*s4;
out.println("<html>"+"<body>"+"<h2>"+"TOTAL_COST : "+cost+"</h2>"+"</body>"+"</html>");

}catch(SQLException | ClassNotFoundException ex ){
Logger.getLogger(bookServlet.class.getName()).log(Level.SEVERE, null, ex);
}
}

}
