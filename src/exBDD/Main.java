package exBDD;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.dao.ArticleDao;
import fr.fms.dao.BasketDao;
import fr.fms.dao.CategoryDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Article;
import fr.fms.entities.Basket;
import fr.fms.entities.Category;
import fr.fms.entities.User;


public class Main {
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static void main(String[] args) throws Exception  {
		
		ArticleDao<Article> articleDao = new ArticleDao<Article>();
		BasketDao<Basket> basketDao = new BasketDao<Basket>();
		UserDao<User> userDao = new UserDao<User>();
		CategoryDao<Category>categoryrDao = new CategoryDao<Category>();
		Scanner scan = new Scanner(System.in);
		User a = userDao.selectById(5);
		User b = new User( "test1", "test2");
		a = new User(a.getUserId(),"test2", "test2");
		//userDao.delete(a);
		
		articleDao.readAll();
		
		System.out.println("Entrez votre login et mdp pour voir la liste des articles \n"
		+ "Login :");
		String login = scan.next();
		System.out.println("Password : ");
		String password = scan.next();
		
	
		ArrayList<User> listUser = userDao.readAll();
		for(User user : listUser) {
			if(user.getUserLogin().equals(login) && user.getUserPassword().equals(password)) {
				System.out.println("Bonjour " + user.getUserLogin());
				articleDao.readAll();
				break;
			} else if (user.getUserLogin().equals(login) || user.getUserPassword().equals(password)) {
				System.out.println("Login and password not matching");
				break;
			} else {
				System.out.println("This User doesn't exist !");
				break;
			}
		}
		} 
} 