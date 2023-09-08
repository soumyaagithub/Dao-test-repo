package pp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response, String query) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				    // Establish the connection to the database
				    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");
				    // Create a statement to execute SQL queries
				    Statement st = con.createStatement();
				  
				    ResultSet rs = st.executeQuery(query);

				    // Process the result set
				    while (rs.next()) {
				        int salary = rs.getInt("Salary");
				        String name = rs.getString("name");
	                    System.out.println(name + " " + salary);
				    }
			           }catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
			        	   e.printStackTrace();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
	}

}
}
