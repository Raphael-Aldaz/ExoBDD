package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import fr.fms.entities.Category;

public class CategoryDao<T> implements Dao<Category> {

	@Override
	public void create(Category obj) {
		String queryInsert = "INSERT INTO T_Category (CatName, CatDescription) VALUES('"+ obj.getCatName()+"', '"+ obj.getCatDescription() +");";
		try(Statement statement = connection.createStatement()){
		PreparedStatement myQuery = connection.prepareStatement(queryInsert);
			try(ResultSet resultSet = myQuery.executeQuery()){
				System.out.println("Creation Done !");
			}			
		}
		catch(SQLException e){
		e.printStackTrace();
		}
		
	}

	@Override
	public Category selectById(int id) {
		Category articleSelected = new Category(id, null, null);
		String querySql = "SELECT *  FROM t_category WHERE IdCategory = " + id;
		
		try(Statement statement = connection.createStatement()){
			PreparedStatement myQuery = connection.prepareStatement(querySql);
			try(ResultSet resultSet = myQuery.executeQuery()){
				while(resultSet.next()) {
					System.out.println(resultSet + "result");
					articleSelected.setIdCategory(resultSet.getInt(1));
					articleSelected.setCatName(resultSet.getString(2));
					articleSelected.setCatDescription(resultSet.getString(3));
			}
		}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return articleSelected;
	}

	@Override
	public boolean update(Category obj) {
	String queryUpdateSql = "UPDATE `t_category` SET `CatName`='" +obj.getCatName() +"', 	`CatDescription`='"+obj.getCatDescription() + ";";
		
	try(Statement statement = connection.createStatement()){
			PreparedStatement myQuery = connection.prepareStatement(queryUpdateSql);
			try(ResultSet resultSet = myQuery.executeQuery()){
				System.out.println("Update done !");
		}
		}
	catch(SQLException e){
			e.printStackTrace();
		}
	 return true;
	}

	@Override
	public boolean delete(Category obj) {
		String queryDelete = "DELETE FROM T_categorys WHERE IdArticle ="+ obj.getIdCategory();
		try(Statement statement = connection.createStatement()){
			PreparedStatement myQuery = connection.prepareStatement(queryDelete);
			try(ResultSet resultSet = myQuery.executeQuery()){
			System.out.println(obj.toString());	
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public ArrayList<Category> readAll() {
		System.out.println("cul");
		ArrayList<Category> list = new ArrayList<>();
		 String querySql = "SELECT *  FROM  T_Category ";
			try(Statement statement = connection.createStatement()){
				PreparedStatement myQuery = connection.prepareStatement(querySql);
				try(ResultSet resultSet = myQuery.executeQuery()){
					System.out.println("a");
				while(resultSet.next()) {
					
							int resultId = resultSet.getInt(1);
							String resultName = resultSet.getString(2);
							String resultDescription = resultSet.getString(3);
							list.add(new Category(resultId,resultName,resultDescription));
							System.out.println(resultId);
							
					}
				list.stream()
				.forEach(System.out::print);
					
				}
				
			}
			
			catch(SQLException e){
				e.printStackTrace();
			}
			return list;
	}

	
	}


