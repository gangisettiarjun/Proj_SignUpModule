package com.reg.pkg;

import java.io.IOException;
import com.reg.pkg.DBConfig;
import com.reg.pkg.RegistrationBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
/**
 * Servlet implementation class UserSignUp
 */
public class UserSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		out.print("Hello to Servlet World");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RegistrationBean rb=new RegistrationBean();
		DBConfig d1=new DBConfig();
		
		rb.setFirstname(request.getParameter("firstname"));
		rb.setLastname(request.getParameter("lastname"));
		rb.setUsername(request.getParameter("username"));
		System.out.println(rb.getUsername());
		rb.setPassword(request.getParameter("password"));
		rb.setEmail(request.getParameter("email"));

		try {
		Class.forName(d1.driver);
		d1.con = DriverManager.getConnection(d1.connectionURL, d1.dbUserName, d1.dbPassword); 
		String query = "insert into users(first_name,last_name,user_name,password,email_address) values(?,?,?,?,?)";
		PreparedStatement smt = d1.con.prepareStatement(query);
		
		smt.setString(1, rb.getFirstname());
		smt.setString(2, rb.getLastname());
		smt.setString(3, rb.getUsername());
		System.out.println(rb.getUsername());
		smt.setString(4, rb.getPassword());
		smt.setString(5, rb.getEmail());
		System.out.println(rb.getEmail());
		
		int i = smt.executeUpdate();

        if(i!=0){  
        	out.println("<font size='6' color=blue>" + "Sign Up Successful" + "</font>");
        	out.println("\n <font size='4' color=blue>" + "Welcome"+" "+rb.getFirstname());
        }  
        else{  
          out.println("<font size='6' color=blue>" + "Sign Up Failed" + "</font>");
         }       
        smt.close();
		}
		catch(ClassNotFoundException e){
		out.println("Couldn't load database driver: " + e.getMessage());
		}
		catch(SQLException e){
			if(e.getMessage().indexOf("Duplicate entry")!=-1) {
	            out.println("<font size='5' color=red>" + "User already exists. Please try another username.");
	        } 
			else {
	        	out.println("<font size='5' color=red>" + "SQLException caught: " + e.getMessage()+
	        			"\n Unable to register user. Please try again later");
	        }
		}
		catch (Exception e){
		out.println(e);
		}
		finally {
		try {
		if (d1.con != null) 
			d1.con.close();
		}
		catch (SQLException ex){
		out.println(ex);
		}
		}
		}
	}
