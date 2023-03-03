package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import fr.fms.entities.Basket;

public class BasketDao<T> implements Dao<Basket> {

	@Override
	public void create(Basket obj) {
		String queryInsert = "INSERT INTO T_Basket (articleId, articleDescription, articleBrand, articlePrice, CatName, IdUser) VALUES('"+obj.getArticleId()+"','"+ obj.getArticleDescription() +"', '"+ obj.getArticleBrand() +"', "+ obj.getArticlePrice() + ", "+ obj.getIdCategory() +", " + obj.getUserId() +");";

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
	public Basket selectById(int id) {
		Basket basketSelected = new Basket(id, null, null, id, id, id);
		String querySelectById = "SELECT * FROM T_Basket WHERE IdArticle ="+ id; 
		try(Statement statement = connection.createStatement()){
			PreparedStatement myQuery = connection.prepareStatement(querySelectById);
			try(ResultSet resultSet = myQuery.executeQuery()){
				while(resultSet.next()) {
					basketSelected.setArticleId(resultSet.getInt(1));
					basketSelected.setArticleDescription(resultSet.getString(2));
					basketSelected.setArticleBrand(resultSet.getString(3));
					basketSelected.setArticlePrice(resultSet.getDouble(4));
					basketSelected.setIdCategory(resultSet.getInt(5));

			}
			
		}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return basketSelected;
	}

	@Override
	public boolean update(Basket obj) {

		String queryUpdateSql = "UPDATE `t_basket` SET `Description`='" +obj.getArticleDescription() +"', 		`Brand`='"+obj.getArticleBrand()+"', 		`UnitaryPrice`='"+obj.getArticlePrice()+"', `IdCategory`='"+obj.getIdCategory()+"', `userId` = '" + obj.getUserId() +"' WHERE 		`IdArticle`="+obj.getArticleId();
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
	public boolean delete(Basket obj) {
		String queryDelete = "DELETE FROM T_basket WHERE IdArticle ="+ obj.getArticleId();
		try(Statement statement = connection.createStatement()){
			PreparedStatement myQuery = connection.prepareStatement(queryDelete);
			try(ResultSet resultSet = myQuery.executeQuery()){
				System.out.println("Deleted with succes");	
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public ArrayList<Basket> readAll() {
		ArrayList<Basket> list = new ArrayList<>();
		 String querySql = "SELECT IdArticle, Description, Brand, UnitaryPrice, CatName  FROM T_Articles 		INNER JOIN T_Category on 		T_Articles.IdCategory = T_Category.IdCategory";
			try(Statement statement = connection.createStatement()){
				PreparedStatement myQuery = connection.prepareStatement(querySql);
				try(ResultSet resultSet = myQuery.executeQuery()){
					while(resultSet.next()) {
							int resultId = resultSet.getInt(1);
							String resultDescription = resultSet.getString(2);
							String resultBrand = resultSet.getString(3);
							double resultPrice = resultSet.getDouble(4);
							int resultCatName = resultSet.getInt(5);
							list.add(new Basket(resultId,resultDescription,resultBrand,resultPrice, resultCatName, resultId));
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
