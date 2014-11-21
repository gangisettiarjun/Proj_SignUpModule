package com.reg.pkg;

import java.sql.*;

public class DBConfig {
	
	String connectionURL = "jdbc:mysql://localhost:3306/registrationdb";
	Connection con=null;
    String driver="com.mysql.jdbc.Driver";
    String dbUserName="root";
    String dbPassword="test123";
}
