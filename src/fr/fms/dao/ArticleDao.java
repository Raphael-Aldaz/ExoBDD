package fr.fms.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Article;

public class ArticleDao<T> implements Dao<Article> {
	
	
	
//	public   ArrayList<Article> readAll( ) {
//		ArrayList<Article> list = new ArrayList<>();
//		 String querySql = "SELECT IdArticle, Description, Brand, UnitaryPrice, CatName  FROM T_Articles INNER JOIN T_Category on 		T_Articles.IdCategory = T_Category.IdCategory";
//			try(Statement statement = connection.createStatement()){
//				PreparedStatement myQuery = connection.prepareStatement(querySql);
//				try(ResultSet resultSet = myQuery.executeQuery()){
//					while(resultSet.next()) {
//							int resultId = resultSet.getInt(1);
//							String resultDescription = resultSet.getString(2);
//							String resultBrand = resultSet.getString(3);
//							double resultPrice = resultSet.getDouble(4);
//							String resultCatName = resultSet.getString(5);
//							list.add(new Article(resultId,resultDescription,resultBrand,resultPrice, resultCatName));
//					}
//					list.stream()
//					.forEach(System.out::print);
//					
//				}
//			}
//			catch(SQLException e){
//				e.printStackTrace();
//			}
//			return list;
//			
//		 
//	 }
//	public  boolean update(int IdToUpdate, String Description, String Brand, double Price, int IdCategory) {
//			
//			String queryUpdateSql = "UPDATE `t_articles` SET `Description`='" +Description +"', `Brand`='"+Brand+"', 		`UnitaryPrice`='"+Price+"', `IdCategory`='"+IdCategory+"' WHERE `IdArticle`="+IdToUpdate;
//			try(Statement statement = connection.createStatement()){
//				PreparedStatement myQuery = connection.prepareStatement(queryUpdateSql);
//				try(ResultSet resultSet = myQuery.executeQuery()){
//					System.out.println("Update done !");
//				}
//			}
//			catch(SQLException e){
//				e.printStackTrace();
//			}
//		 return true;
//	 }
//	public boolean delete(  int Id) {
//			
//			String queryDelete = "DELETE FROM T_Articles WHERE IdArticle ="+ Id;
//			try(Statement statement = connection.createStatement()){
//				PreparedStatement myQuery = connection.prepareStatement(queryDelete);
//				try(ResultSet resultSet = myQuery.executeQuery()){
//					System.out.println("Deleted with succes");	
//				}
//			}
//			catch(SQLException e){
//				e.printStackTrace();
//			}
//			return true;
//		 
//	} 
//	public  Article selectById( int Id) {
//
//			Article articleSelected = new Article(Id, null, null, Id, Id) ;
//			String querySelectById = "SELECT * FROM T_Articles WHERE IdArticle ="+ Id;
//			try(Statement statement = connection.createStatement()){
//				PreparedStatement myQuery = connection.prepareStatement(querySelectById);
//				try(ResultSet resultSet = myQuery.executeQuery()){
//					while(resultSet.next()) {
//						articleSelected.setArticleId(resultSet.getInt(1));
//						articleSelected.setArticleDescription(resultSet.getString(2));
//						articleSelected.setArticleBrand(resultSet.getString(3));
//						articleSelected.setArticlePrice(resultSet.getDouble(4));
//						articleSelected.setIdCategory(resultSet.getInt(5));
//
//				}
//				
//			}
//			}
//			catch(SQLException e){
//				e.printStackTrace();
//			}
//			return articleSelected;
//					
//}
//	public void create( String Description, String Brand, double Price, int Category) {
//		
//		String queryInsert = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice, idCategory) VALUES('"+ Description +"', '"+ Brand +"', "+ Price + ", "+ Category +");";
//		try(Statement statement = connection.createStatement()){
//			PreparedStatement myQuery = connection.prepareStatement(queryInsert);
//			try(ResultSet resultSet = myQuery.executeQuery()){
//				System.out.println("Creation Done !");
//			}			
//		}
//		catch(SQLException e){
//			e.printStackTrace();
//		}
//}
//	
	@Override
	public boolean update(Article obj) {
		String queryUpdateSql = "UPDATE `t_articles` SET `Description`='" +obj.getArticleDescription() +"', `Brand`='"+obj.getArticleBrand()+"', 		`UnitaryPrice`='"+obj.getArticlePrice()+"', `IdCategory`='"+obj.getIdCategory()+"' WHERE `IdArticle`="+obj.getArticleId();
		
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
	public boolean delete(Article obj) {
		String queryDelete = "DELETE FROM T_Articles WHERE IdArticle ="+ obj.getArticleId();
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
	public void create(Article obj) {
		String queryInsert = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice, idCategory) VALUES('"+ obj.getArticleDescription() +"', '"+ obj.getArticleBrand() +"', "+ obj.getArticlePrice() + ", "+ obj.getIdCategory() +");";
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
	public Article selectById(int id) {
		Article articleSelected = new Article(id, null, null, id,  null);
		String querySql = "SELECT *  FROM T_Articles INNER JOIN T_Category on T_Articles.IdCategory = T_Category.IdCategory WHERE IdArticle =" + id;
		
		try(Statement statement = connection.createStatement()){
			PreparedStatement myQuery = connection.prepareStatement(querySql);
			try(ResultSet resultSet = myQuery.executeQuery()){
				while(resultSet.next()) {
					System.out.println(resultSet + "result");
					articleSelected.setArticleId(resultSet.getInt(1));
					articleSelected.setArticleDescription(resultSet.getString(2));
					articleSelected.setArticleBrand(resultSet.getString(3));
					articleSelected.setArticlePrice(resultSet.getDouble(4));
					articleSelected.setIdCategory(resultSet.getInt(5));
					articleSelected.setCatName(resultSet.getString(7));

			}
			
		}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return articleSelected;
	}
	@Override
	public ArrayList<Article> readAll() {
		ArrayList<Article> list = new ArrayList<>();
		 String querySql = "SELECT IdArticle, Description, Brand, UnitaryPrice, CatName  FROM T_Articles INNER JOIN T_Category on 		T_Articles.IdCategory = T_Category.IdCategory";
			try(Statement statement = connection.createStatement()){
				PreparedStatement myQuery = connection.prepareStatement(querySql);
				try(ResultSet resultSet = myQuery.executeQuery()){
				while(resultSet.next()) {
							int resultId = resultSet.getInt(1);
						String resultDescription = resultSet.getString(2);
							String resultBrand = resultSet.getString(3);
							double resultPrice = resultSet.getDouble(4);
							String resultCatName = resultSet.getString(5);
							list.add(new Article(resultId,resultDescription,resultBrand,resultPrice, resultCatName));
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