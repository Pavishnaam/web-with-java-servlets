/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class employeeServlet extends HttpServlet {

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
String s1=request.getParameter("id");
String s2=request.getParameter("name");
String s3=request.getParameter("designation");
int s4=Integer.valueOf(request.getParameter("salary"));

 stmt.executeUpdate("insert into emp values('"+s1+"','"+s2+"','"+s3+"',"+s4+");");
out.println("<html>\n" +
"<body bgcolor = \"#f0f0f0\">\n" +
"<h1 align = \"center\">" + "VALUES INSERTED SUCCESFULLY" + "</h1>\n" +
"</body>\n"+
"</html>"        
);
 out.println("<html><body><form action=\"employee2Servlet\" method=\"POST\">"+
 "ENTER EMPLOYEE ID : <input type=text name=\"id\"> <br/>"+
 "<input type=submit name=\"submit\">");

}catch(SQLException | ClassNotFoundException ex ){
Logger.getLogger(employeeServlet.class.getName()).log(Level.SEVERE, null, ex);
}
}


}
