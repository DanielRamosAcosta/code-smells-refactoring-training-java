package video_store;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Enumeration;

public class Customer {
    private final String name;

    private final Vector rentals2 = new Vector();

    private final List<Rental> rentals = new ArrayList<>();


    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals2.addElement(rental);
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
            frequentRenterPoints = frequentRenterPoints + rental.computeFrequentRenterPoints();
            result += "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        result += "You owed " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";

        return result;
    }
}
