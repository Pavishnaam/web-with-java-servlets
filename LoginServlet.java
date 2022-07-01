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
public class LoginServlet extends HttpServlet{
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
String title;
String s1=request.getParameter("username");
String s2=request.getParameter("password");
System.out.println(s1+"\t"+s2);
// if (s1.equals("admin") && (s2.equals("admin")))
ResultSet rs = stmt.executeQuery("select * from login where loginid='"+s1+"' and password='"+s2+"';");
// int l=rs.getRow();
if(rs.next()){
title=s1 + " is a Valid User";
// out.println("<html><body><form action=\"login2sevlet\" method=\"POST\">"+
// "<input type=text name=\"registerno\">"+
// "<input type=submit name=\"submit\">");
}
//out.println("<html><body><form action=\"login2sevlet\" method=\"POST\">"+
// "<input type=text name=\"registerno\">"+
// "<input type=submit name=\"submit\">");
// title="Invalid USer";
else{
title=s1 + "is an Invalid User.... User added newly ";
// stmt.executeUpdate("insert into login values('"+s1+"','"+s2+"')");
}
out.println("<html>\n" +
"<body bgcolor = \"#f0f0f0\">\n" +
"<h1 align = \"center\">" + title + "</h1>\n" +
"</body>\n"+
"</html>"
);
}catch(SQLException | ClassNotFoundException ex ){
Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);// Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
}
}
}