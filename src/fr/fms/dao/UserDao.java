package fr.fms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Article;
import fr.fms.entities.User;

public  class UserDao<T> implements Dao<User> {
public void create( String Login, String Password) {
	String queryInsert = "INSERT INTO T_Users (Login, Password) VALUES('"+ Login +"', '"+ Password +");";
	try(Statement statement = connection.createStatement()){
		try(ResultSet resultSet = statement.executeQuery(queryInsert)){
			System.out.println("Creation done !");
		}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
}
public ArrayList<User> readAll() {
	ArrayList<User> listUser = new ArrayList<>();
	 String querySql = "SELECT * FROM T_Users";
		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(querySql)){
				while(resultSet.next()) {
					int userId = resultSet.getInt(1);
					String userLogin = resultSet.getString(2);
					String userPassword = resultSet.getString(3);
					listUser.add(new User(userId,userLogin,userPassword));
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listUser;
	 
}
public boolean update( double IdToUpdate, String login, String password) {
	
	String queryUpdateSql = "UPDATE `t_users` SET `Login`='"+login+"', `Password`='"+password+"' WHERE  `IdUser`=" + IdToUpdate;
	try(Statement statement = connection.createStatement()){
		try(ResultSet resultSet = statement.executeQuery(queryUpdateSql)){
			System.out.println("Update User done !");
		}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
 return true;
}
public boolean delete( int Id) {
	
	String queryDelete = "DELETE FROM T_User WHERE IdUser ="+ Id;
	try(Statement statement = connection.createStatement()){
		try(ResultSet resultSet = statement.executeQuery(queryDelete)){
			System.out.println("User deleted !");
		}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
 return true;
}
public User selectById( int Id) {

	User userSelected = new User(Id, null, null);
	String querySelectById = "SELECT * FROM T_Users WHERE IdUser ="+ Id;
	try(Statement statement = connection.createStatement()){
		try(ResultSet resultSet = statement.executeQuery(querySelectById)){
			while(resultSet.next()) {
				userSelected.setUserId(resultSet.getInt(1));
				userSelected.setUserLogin(resultSet.getString(2));
				userSelected.setUserPassword(querySelectById);
			}
		}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return userSelected;
}
@Override
public void create(User obj) {
	// TODO Auto-generated method stub
	
}

@Override
public boolean update(User obj) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean delete(User obj) {
	// TODO Auto-generated method stub
	return false;
}

}
