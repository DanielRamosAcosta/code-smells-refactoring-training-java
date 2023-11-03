package video_store;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Enumeration;

public class Customer {
    private final String name;

    private final List<Rental> rentals = new ArrayList<>();


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
        String result = "Rental Record for " + getName() + "\n";

        final double totalAmount = getTotalAmount();
        final int frequentRenterPoints = getFrequentRenterPoints();

        for (Rental rental : this.rentals) {
            double thisAmount = rental.calculateAmount();
            result += "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
        }

        result += "You owed " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";

        return result;
    }

    private int getFrequentRenterPoints() {
        return this.rentals.stream().mapToInt(Rental::computeFrequentRenterPoints).sum();
    }

    private double getTotalAmount() {
        return this.rentals.stream().mapToDouble(Rental::calculateAmount).sum();
    }
}
