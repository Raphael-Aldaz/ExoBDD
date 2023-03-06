package fr.fms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import fr.fms.entities.User;

public  class UserDao<T> implements Dao<User> {

	@Override
	public void create(User obj) {
		String queryInsert = "INSERT INTO T_Users (Login, Password) VALUES('"+ obj.getUserLogin() +"', '"+ obj.getUserPassword() +"');";
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(queryInsert)){
			System.out.println("Creation done !");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		
	}
	}
	@Override
	public User selectById(int id) {
		User userSelected = new User(id, null, null);
		String querySelectById = "SELECT * FROM T_Users WHERE IdUser ="+ id;
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
	public boolean update(User obj) {
		String queryUpdateSql = "UPDATE `t_users` SET `Login`='"+obj.getUserLogin()+"', `Password`='"+obj.getUserPassword()+"' WHERE  `IdUser`=" + obj.getUserId();
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
	@Override
	public boolean delete(User obj) {
		String queryDelete = "DELETE FROM T_Users WHERE IdUser ="+ obj.getUserId();
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
	@Override
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
				//listUser.stream()
				//.forEach(System.out::println);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return listUser;
	}

}
