package fr.fms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Article;

public abstract class ArticleDao<T> implements Dao<T> {
	public static void create(ArrayList<Article> list, Connection connection, String Description, String Brand, double Price, int Category) {
		
		String queryInsert = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice, idCategory) VALUES('"+ Description +"', '"+ Brand +"', "+ Price + ", "+ Category +");";
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(queryInsert)){
				while(resultSet.next()) {
					int resultId = resultSet.getInt(1);
					String resultDescription = resultSet.getString(2);
					String resultBrand = resultSet.getString(3);
					double resultPrice = resultSet.getDouble(4);
					list.add(new Article(resultId,resultDescription,resultBrand,resultPrice));
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	 
}
	public static void selectAll(ArrayList<Article> list, Connection connection) {
		 String querySql = "SELECT * FROM T_Articles";
			//String queryUpdateSql = "UPDATE T_Articles SET UnitaryPrice = 100 WHERE IdArticle = 15 ";
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(querySql)){
					while(resultSet.next()) {
						int resultId = resultSet.getInt(1);
						String resultDescription = resultSet.getString(2);
						String resultBrand = resultSet.getString(3);
						double resultPrice = resultSet.getDouble(4);
						list.add(new Article(resultId,resultDescription,resultBrand,resultPrice));
					}
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		 
	 }
	public static  void update(ArrayList<Article> list, Connection connection, double IdToUpdate) {
			
			String queryUpdateSql = "UPDATE T_Articles SET UnitaryPrice = 100 WHERE IdArticle =" + IdToUpdate;
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(queryUpdateSql)){
					while(resultSet.next()) {
						int resultId = resultSet.getInt(1);
						String resultDescription = resultSet.getString(2);
						String resultBrand = resultSet.getString(3);
						double resultPrice = resultSet.getDouble(4);
						list.add(new Article(resultId,resultDescription,resultBrand,resultPrice));
					}
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		 
	 }
	public static void delete(ArrayList<Article> list, Connection connection, int Id) {
			
			String queryDelete = "DELETE FROM T_Articles WHERE IdArticle ="+ Id;
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(queryDelete)){
					while(resultSet.next()) {
						int resultId = resultSet.getInt(1);
						String resultDescription = resultSet.getString(2);
						String resultBrand = resultSet.getString(3);
						double resultPrice = resultSet.getDouble(4);
						list.add(new Article(resultId,resultDescription,resultBrand,resultPrice));
					}
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		 
	} 
	public static void selectById(ArrayList<Article> list, Connection connection, int Id) {

			
			String querySelectById = "SELECT * FROM T_Articles WHERE IdArticle ="+ Id;
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(querySelectById)){
					while(resultSet.next()) {
						int resultId = resultSet.getInt(1);
						String resultDescription = resultSet.getString(2);
						String resultBrand = resultSet.getString(3);
						double resultPrice = resultSet.getDouble(4);
						list.add(new Article(resultId,resultDescription,resultBrand,resultPrice));
					}
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
}

}