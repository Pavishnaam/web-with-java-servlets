import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class regServlet extends HttpServlet{
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
int s1=Integer.valueOf(request.getParameter("name"));
String s2=request.getParameter("reg");
ResultSet rs = stmt.executeQuery("select * from stud where reg="+s1+" and name='"+s2+"';");
if(rs.next()){
RequestDispatcher req = request.getRequestDispatcher("reg_success.jsp");
req.include(request, response);
}

else{
RequestDispatcher req = request.getRequestDispatcher("reg_failure.jsp");
req.include(request, response);
}
}catch(SQLException | ClassNotFoundException ex ){
Logger.getLogger(regServlet.class.getName()).log(Level.SEVERE, null, ex);
}
}
}