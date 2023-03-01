package exBDD;

import java.util.ArrayList;
import fr.fms.dao.ArticleDao;
import fr.fms.entities.Article;


public class Main {

	public static void main(String[] args) throws Exception  {
		ArrayList<Article>articles = new ArrayList<Article>();
		
			ArticleDao.selectAll(articles, BddConnection.getConnection());
			ArticleDao.update(articles, BddConnection.getConnection(), 10);
			ArticleDao.create(articles, BddConnection.getConnection(), "switch", "Nintendu", 300, 4);
			ArticleDao.delete(articles, BddConnection.getConnection(), 16);
			ArticleDao.selectById(articles, BddConnection.getConnection(), 10);
			
			for(Article article : articles) {
				System.out.println("| " + article.getResultId() + " - " + article.getResultDescription() + " - " + article.getResultBrand() + " - " + article.getResultPrice() + " |");
				System.out.println();
			}
		} 
} 