package fr.fms.entities;

import exBDD.Main;

public class Article {
	private int articleId;
	private String articleDescription;
	private String articleBrand;
	private double articlePrice;
	private int IdCategory;
	private String CatName;
	

	public Article( String articleDescription, String articleBrand, double articlePrice, int IdCategory) {
		//this.articleId = articleId;
		this.articleDescription = articleDescription;
		this.articleBrand = articleBrand;
		this.articlePrice = articlePrice;
		this.IdCategory = IdCategory;
	}
	public Article(int articleId, String articleDescription, String articleBrand, double articlePrice, String CatName) {
		this.articleId = articleId;
		this.articleDescription = articleDescription;
		this.articleBrand = articleBrand;
		this.articlePrice = articlePrice;
		this.CatName = CatName;
	}
	public Article(int articleId, String articleDescription, String articleBrand, double articlePrice, int IdCategory) {
		this.articleId = articleId;
		this.articleDescription = articleDescription;
		this.articleBrand = articleBrand;
		this.articlePrice = articlePrice;
		this.IdCategory = IdCategory;
	}
	public Article(int articleId) {
		this.articleId = articleId;
	}
	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getArticleDescription() {
		return articleDescription;
	}

	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}

	public String getArticleBrand() {
		return articleBrand;
	}

	public void setArticleBrand(String articleBrand) {
		this.articleBrand = articleBrand;
	}

	public double getArticlePrice() {
		return articlePrice;
	}

	public void setArticlePrice(double articlePrice) {
		this.articlePrice = articlePrice;
	}
	public int getIdCategory() {
		return IdCategory;
	}
	public void setIdCategory(int idCategory) {
		this.IdCategory = idCategory;
	}
	public String getCatName() {
		return CatName;
	}
	public void setCatName(String catName) {
		this.CatName = catName;
	}
	@Override
	public String toString() {
		return Main.ANSI_GREEN + "| articleId =  " + Main.ANSI_RESET  + articleId +
				Main.ANSI_GREEN+ ", articleDescription = " +Main.ANSI_RESET + articleDescription +
				Main.ANSI_GREEN+ ", articleBrand = "+Main.ANSI_RESET + articleBrand +
				Main.ANSI_GREEN+ ", articlePrice = " + Main.ANSI_RESET +articlePrice +
				Main.ANSI_GREEN+ " categorie = " +Main.ANSI_RESET + IdCategory  +
				Main.ANSI_GREEN+" " + Main.ANSI_RESET +CatName  + " |\n";
	}
}
