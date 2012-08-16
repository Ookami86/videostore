import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();
	protected double totalAmount;
	protected int frequentRenterPoints;

	
	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		resetTotals();
		return header() + body() + footer();
	}
	
	private String header() {
		return "Rental Record for " + getName() + "\n";
	}

	private String body() {
		String result = "";
		for (Rental each : rentals){
			double thisAmount = each.determineAmountForRental();
			frequentRenterPoints += each.determineFrequentRenterPoints();
			totalAmount += thisAmount;
			result += rentalLine(each, thisAmount);
		}
		return result;
	}

	private String footer() {
		String result =  "You owed " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points\n";
		return result;
	}

	private String rentalLine(Rental each, double thisAmount) {
		return "\t" + each.getMovie().getTitle() + "\t"
				+ String.valueOf(thisAmount) + "\n";
	}

	private void resetTotals() {
		totalAmount = 0;
		frequentRenterPoints = 0;
	}

}