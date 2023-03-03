package fr.fms.entities;

public class Basket extends Article {
	private int basketId;
	private int userId;
	public Basket(int articleId, String articleDescription, String articleBrand, double articlePrice, int CatId, int userId) {
		super( articleDescription, articleBrand, articlePrice, CatId);
	
		this.userId = userId;

	}
	public int getBasketId() {
		return basketId;
	}
	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
