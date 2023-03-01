package exBDD;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BddConnection {
public static Connection getConnection() {
	Properties props = null;
	
	try {
		CreateConfigFile.CreateConf();
		 props = readConfigFile("config.properties");
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	try {
		Class.forName(props.getProperty("driver.class"));
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	
	String url = props.getProperty("url");
	String login =props.getProperty("login");
	String password =props.getProperty("password");
	
	Connection connection = null;
	try {
		connection = DriverManager.getConnection(url, login, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;

}
public static Properties readConfigFile(String file) throws IOException  {
	 FileInputStream fis = null;
	 Properties props = null;
	 try {
		 fis = new FileInputStream(file);
		 props = new Properties();
		 props.load(fis);
	 } catch (Exception e) {
		e.printStackTrace();
	} finally {
		fis.close();
	}
	 return props;
}
}


