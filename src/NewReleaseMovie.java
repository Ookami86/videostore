
public class NewReleaseMovie extends Movie {

	public NewReleaseMovie(String title) {
		super(title);
	}

	public double determineAmount(final int daysRented) {
		double thisAmount = 0;
		thisAmount += daysRented * 3;
		return thisAmount;
	}

	public int determineFrequentRenterPoints(final int daysRented) {
		int frequentRenterPoints = 1;
		if (daysRented > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

}
