package fr.fms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import fr.fms.entities.User;

public abstract class UserDao<T> implements Dao<T> {
public static void create(ArrayList<User> list, Connection connection, String Login, String Password) {
	String queryInsert = "INSERT INTO T_Users (Login, Password) VALUES('"+ Login +"', '"+ Password +");";
	try(Statement statement = connection.createStatement()){
		try(ResultSet resultSet = statement.executeQuery(queryInsert)){
			while(resultSet.next()) {
				int userId = resultSet.getInt(1);
				String userLogin = resultSet.getString(2);
				String userPassword = resultSet.getString(3);
				list.add(new User(userId,userLogin,userPassword));
			}
		}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
}
public static void selectAll(ArrayList<User> list, Connection connection) {
	 String querySql = "SELECT * FROM T_Users";
		//String queryUpdateSql = "UPDATE T_Articles SET UnitaryPrice = 100 WHERE IdArticle = 15 ";
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(querySql)){
				while(resultSet.next()) {
					int userId = resultSet.getInt(1);
					String userLogin = resultSet.getString(2);
					String userPassword = resultSet.getString(3);
					list.add(new User(userId,userLogin,userPassword));
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	 
}
public static  void update(ArrayList<User> list, Connection connection, double IdToUpdate) {
	
	String queryUpdateSql = "UPDATE T_User SET Password = 12345 WHERE IdUser =" + IdToUpdate;
	try(Statement statement = connection.createStatement()){
		try(ResultSet resultSet = statement.executeQuery(queryUpdateSql)){
			while(resultSet.next()) {
				int userId = resultSet.getInt(1);
				String userLogin = resultSet.getString(2);
				String userPassword = resultSet.getString(3);
				list.add(new User(userId,userLogin,userPassword));
			}
		}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
 
}
public static void delete(ArrayList<User> list, Connection connection, int Id) {
	
	String queryDelete = "DELETE FROM T_User WHERE IdUser ="+ Id;
	try(Statement statement = connection.createStatement()){
		try(ResultSet resultSet = statement.executeQuery(queryDelete)){
			while(resultSet.next()) {
				int userId = resultSet.getInt(1);
				String userLogin = resultSet.getString(2);
				String userPassword = resultSet.getString(3);
				list.add(new User(userId,userLogin,userPassword));
			}
		}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
 
}
public static void selectById(ArrayList<User> list, Connection connection, int Id) {

	
	String querySelectById = "SELECT * FROM T_Users WHERE IdUser ="+ Id;
	try(Statement statement = connection.createStatement()){
		try(ResultSet resultSet = statement.executeQuery(querySelectById)){
			while(resultSet.next()) {
				int userId = resultSet.getInt(1);
				String userLogin = resultSet.getString(2);
				String userPassword = resultSet.getString(3);
				list.add(new User(userId,userLogin,userPassword));
			}
		}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
}
}
