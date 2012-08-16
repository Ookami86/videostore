
public abstract class Movie {

	private String title;
	private int priceCode;

	public Movie(String title) {
		this.title = title;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int code) {
		priceCode = code;
	}

	public String getTitle() {
		return title;
	}

	public abstract double determineAmount(int daysRented);

	public abstract int determineFrequentRenterPoints(int daysRented);

}