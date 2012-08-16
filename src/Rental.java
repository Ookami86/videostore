public class Rental {
	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	double determineAmountForRental() {
		return movie.determineAmount(getDaysRented());
	}

	int determineFrequentRenterPoints() {
		return movie.determineFrequentRenterPoints(getDaysRented());
	}

	private Movie movie;
	private int daysRented;
}