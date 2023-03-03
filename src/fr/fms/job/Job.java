package fr.fms.job;



abstract interface Job<T> {
	public int addArticles(T obj);
	public int deleteArticle (T obj);
	
	
}
