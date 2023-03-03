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

	public static void main(String[] args) throws Exception  {
		
		ArticleDao<Article> articleDao = new ArticleDao<Article>();
		BasketDao<Basket> basketDao = new BasketDao<Basket>();
		UserDao<User> userDao = new UserDao<User>();
		CategoryDao<Category>categoryrDao = new CategoryDao<Category>();
		Scanner scan = new Scanner(System.in);
		categoryrDao.readAll(); 
		

		} 
} 