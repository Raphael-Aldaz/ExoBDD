package fr.fms.entities;

public class Category {
	private int IdCategory;
	private String CatName;
	private String CatDescription;
	
	public Category(int idCategory, String catName, String catDescription) {
		super();
		IdCategory = idCategory;
		CatName = catName;
		CatDescription = catDescription;
	}
	public int getIdCategory() {
		return IdCategory;
	}
	public void setIdCategory(int idCategory) {
		IdCategory = idCategory;
	}
	public String getCatName() {
		return CatName;
	}
	public void setCatName(String catName) {
		CatName = catName;
	}
	public String getCatDescription() {
		return CatDescription;
	}
	public void setCatDescription(String catDescription) {
		CatDescription = catDescription;
	}
	
	@Override
	public String toString() {
		return "Category [IdCategory=" + IdCategory + ", CatName=" + CatName + ", CatDescription=" + CatDescription
				+ "]";
	}
}
