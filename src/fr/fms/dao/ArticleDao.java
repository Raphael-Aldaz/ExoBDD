package fr.fms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Article;

public class ArticleDao<T> implements Dao<Article> {
	
	
	
	public   ArrayList<Article> readAll( ) {
		ArrayList<Article> list = new ArrayList<>();
		 String querySql = "SELECT IdArticle, Description, Brand, UnitaryPrice, CatName  FROM T_Articles INNER JOIN T_Category on 		T_Articles.IdCategory = T_Category.IdCategory";
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(querySql)){
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
	public  boolean update(int IdToUpdate, String Description, String Brand, double Price, int IdCategory) {
			
			String queryUpdateSql = "UPDATE `t_articles` SET `Description`='" +Description +"', `Brand`='"+Brand+"', 		`UnitaryPrice`='"+Price+"', `IdCategory`='"+IdCategory+"' WHERE `IdArticle`="+IdToUpdate;
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(queryUpdateSql)){
					System.out.println("Update done !");
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		 return true;
	 }
	public boolean delete(  int Id) {
			
			String queryDelete = "DELETE FROM T_Articles WHERE IdArticle ="+ Id;
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(queryDelete)){
					System.out.println("Deleted with succes");	
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return true;
		 
	} 
	public  Article selectById( int Id) {

			Article articleSelected = new Article(Id, null, null, Id, Id) ;
			String querySelectById = "SELECT * FROM T_Articles WHERE IdArticle ="+ Id;
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(querySelectById)){
					while(resultSet.next()) {
						articleSelected.setArticleId(resultSet.getInt(1));
						articleSelected.setArticleDescription(resultSet.getString(2));
						articleSelected.setArticleBrand(resultSet.getString(3));
						articleSelected.setArticlePrice(resultSet.getDouble(4));
						articleSelected.setIdCategory(resultSet.getInt(5));

				}
				
			}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return articleSelected;
					
}
	public void create( String Description, String Brand, double Price, int Category) {
		
		String queryInsert = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice, idCategory) VALUES('"+ Description +"', '"+ Brand +"', "+ Price + ", "+ Category +");";
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(queryInsert)){
				System.out.println("Creation Done !");
			}			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
}
	
	@Override
	public boolean update(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void create(Article obj) {
		// TODO Auto-generated method stub
		
	}

	

}