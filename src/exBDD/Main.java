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
		
		ArticleDao<Article> articleDao = new ArticleDao<Article>();
		Scanner scan = new Scanner(System.in);
		
			
			
			//articleDao.readAll();
			//articleDao.update(  10,"Batterie Laptop", "Sumsung2145", 250,2);	
			//articleDao.create(  "test", "test", 300, 4);
			System.out.println("###########################################################################");
//			
//			articleDao.delete( 33);
			Article a = articleDao.selectById( 15);
			System.out.println(a);
//			UserDao.selectAll(users, connect);
//			System.out.println("Pour voir la liste des articles, merci de saisir votre login et votre mot de passe :\n"
//					+ "Login :");
//			String login = scan.nextLine();
//			System.out.println("Password :");
//			String password = scan.next();
//			UserDao.selectAll(users, connect);
//			
//			Boolean registeredUser = false;
//			for(User user : users) {
//				if(login.equals(user.getUserLogin()) && password.equals(user.getUserPassword())) registeredUser = true;
//			}
//			
//			if(registeredUser == true) {
//				ArticleDao.selectAll(articles, BddConnection.getConnection());
//			} else {
//				System.out.println("Utilistaeur pas enregistré !");
//			}
//			for(Article article : articles) {
//				System.out.println("| " + article.getArticleId() + " - " + article.getArticleDescription() + " - " + article.getArticleBrand() + " - " + article.getArticlePrice() + " |");
//				System.out.println();
//			}
//			
//			while(true) {
//				System.out.println("Que voulez vous faire ? \n"
//						+"1-Ajouter un article 2-Retirer un article 3-Valider votre panier");
//				int choice = -1;
//				while(choice!=4) {
//					choice = scan.nextInt();
//					switch (choice) {
//					case 1:
//						System.out.println("Que voulez vous ajouter ? ");
//						break;
//					case 2 :
//						System.out.println("Que voulez vous supprimer ? ");
//						break;
//					case 3:
//						System.out.println("Valider le panier");
//					break;
//					}
//				}
//			}

		} 
} 