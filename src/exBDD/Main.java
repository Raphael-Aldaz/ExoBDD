package exBDD;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;


public class Main {

	public static void main(String[] args) throws Exception {
		ArrayList<Article>articles = new ArrayList<Article>();
		CreateConfigFile.CreateConf();
		Properties props = readConfigFile("config.properties");
		

		try {
			Class.forName(props.getProperty("driver.class"));
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		String url = props.getProperty("url");
		String login =props.getProperty("login");
		String password =props.getProperty("password");
		
		try(Connection connection = DriverManager.getConnection(url, login, password)){
			selectAll(articles, connection);
			update(articles, connection, 10);
			insert(articles, connection, "switch", "Nintendu", 300, 4);
			delete(articles, connection, 16);
			selectById(articles, connection, 10);
			} catch (Exception e) {
				e.printStackTrace();
			}
			for(Article article : articles) {
				System.out.println("| " + article.getResultId() + " - " + article.getResultDescription() + " - " + article.getResultBrand() + " - " + article.getResultPrice() + " |");
				System.out.println();
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
 public static void update(ArrayList<Article> list, Connection connection, double IdToUpdate) {
	
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
 public static void insert(ArrayList<Article> list, Connection connection, String Description, String Brand, double Price, int Category) {
		
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
