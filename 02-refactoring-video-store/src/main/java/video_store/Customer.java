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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : this.rentals) {
            double thisAmount = rental.calculateAmount();
            totalAmount += thisAmount;
        }

        for (Rental rental : this.rentals) {
            frequentRenterPoints = frequentRenterPoints + rental.computeFrequentRenterPoints();
        }

        for (Rental rental : this.rentals) {
            double thisAmount = rental.calculateAmount();
            result += "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
        }

        result += "You owed " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";

        return result;
    }
}
