package exBDD;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.dao.ArticleDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Article;
import fr.fms.entities.User;


public class Main {

	public static void main(String[] args) throws Exception  {
		Connection connect = BddConnection.getConnection();
		ArrayList<Article>articles = new ArrayList<Article>();
		ArrayList<User>users = new ArrayList<User>();
		Scanner scan = new Scanner(System.in);
		
//			ArticleDao.selectAll(articles, BddConnection.getConnection());
//			ArticleDao.update(articles, BddConnection.getConnection(), 10);
//			ArticleDao.create(articles, BddConnection.getConnection(), "switch", "Nintendu", 300, 4);
//			ArticleDao.delete(articles, BddConnection.getConnection(), 16);
//			ArticleDao.selectById(articles, BddConnection.getConnection(), 10);
//			UserDao.selectAll(users, connect);
			System.out.println("Pour voir la liste des articles, merci de saisir votre login et votre mot de passe :\n"
					+ "Login :");
			String login = scan.nextLine();
			System.out.println("Password :");
			String password = scan.next();
			UserDao.selectAll(users, connect);
			
			
	
			Boolean registeredUser = false;
			for(User user : users) {
				if(login.equals(user.getUserLogin()) && password.equals(user.getUserPassword())) registeredUser = true;
			}
			
			if(registeredUser == true) {
				ArticleDao.selectAll(articles, BddConnection.getConnection());
			} else {
				System.out.println("Utilistaeur pas enregistré !");
			}
			for(Article article : articles) {
				System.out.println("| " + article.getResultId() + " - " + article.getResultDescription() + " - " + article.getResultBrand() + " - " + article.getResultPrice() + " |");
				System.out.println();
			}

		} 
} 