import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class VideoStoreTest

{
	private static final Rental REGULAR_3 = new Rental(new RegularMovie("Eraserhead"), 3);
	private static final Rental REGULAR_2 = new Rental(new RegularMovie("8 1/2"), 2);
	private static final Rental REGULAR_1 = new Rental(new RegularMovie("Plan 9 from Outer Space"), 1);
	private Customer customer;
	private static final double DELTA = .00001;

	@Before
	public void setUp() {
		customer = new Customer("Fred");
	}

	@Test
	public void testSingleNewReleaseStatement() {
		customer.addRental(new Rental(new NewReleaseMovie("The Cell"),
				3));

		customer.statement();

		assertThat(customer.frequentRenterPoints, is(2));
		assertThat(customer.totalAmount, is(closeTo(9.0, DELTA)));
	}

	@Test
	public void testDualNewReleaseStatement() {
		customer.addRental(new Rental(new NewReleaseMovie("The Cell"),
				3));
		customer.addRental(new Rental(new NewReleaseMovie("The Tigger Movie"), 3));

		customer.statement();

		assertThat(customer.frequentRenterPoints, is(4));
		assertThat(customer.totalAmount, is(closeTo(18.0, DELTA)));

	}

	@Test
	public void testSingleChildrensStatement() {
		customer.addRental(new Rental(new ChildrensMovie("The Tigger Movie"), 3));

		customer.statement();

		assertThat(customer.frequentRenterPoints, is(1));
		assertThat(customer.totalAmount, is(closeTo(1.5, DELTA)));

	}

	@Test
	public void testMultipleRegularStatement() {
		customer.addRental(REGULAR_1);
		customer.addRental(REGULAR_2);
		customer.addRental(REGULAR_3);

		customer.statement();

		assertThat(customer.frequentRenterPoints, is(3));
		assertThat(customer.totalAmount, is(closeTo(7.5, DELTA)));

	}

	@Test
	public void testMulitpleRegularStatementText() throws Exception {
		customer.addRental(REGULAR_1);
		customer.addRental(REGULAR_2);
		customer.addRental(REGULAR_3);

		assertEquals("Rental Record for Fred\n"
				+ "\tPlan 9 from Outer Space\t2.0\n"
				+ "\t8 1/2\t2.0\n\tEraserhead\t3.5\n"
				+ "You owed 7.5\nYou earned 3 frequent renter points\n",
				customer.statement());
	}

}