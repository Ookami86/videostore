public class ChildrensMovie extends Movie {

	public ChildrensMovie(String title) {
		super(title);
	}

	public double determineAmount(final int daysRented) {
		double thisAmount = 1.5;
		if (daysRented > 3)
			thisAmount += (daysRented - 3) * 1.5;
		return thisAmount;
	}

	public int determineFrequentRenterPoints(final int daysRented) {
		return 1;
	}

}
