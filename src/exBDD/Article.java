package exBDD;

public class Article {
	private int resultId;
	private String resultDescription;
	private String resultBrand;
	private double resultPrice;

	public Article(int resultId, String resultDescription, String resultBrand, double resultPrice) {
		this.resultId = resultId;
		this.resultDescription = resultDescription;
		this.resultBrand = resultBrand;
		this.resultPrice = resultPrice;
	}
	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public String getResultDescription() {
		return resultDescription;
	}

	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}

	public String getResultBrand() {
		return resultBrand;
	}

	public void setResultBrand(String resultBrand) {
		this.resultBrand = resultBrand;
	}

	public double getResultPrice() {
		return resultPrice;
	}

	public void setResultPrice(double resultPrice) {
		this.resultPrice = resultPrice;
	}

}
