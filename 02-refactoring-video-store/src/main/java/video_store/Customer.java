package video_store;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;

    private final List<Rental> rentals = new ArrayList<>();


    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement(StatementFormatter formatter) {
        final double totalAmount = computeTotalAmount();
        final int frequentRenterPoints = computeFrequentRenterPoints();
        final StatementData statementData = new StatementData(totalAmount, frequentRenterPoints, this.rentals, name);
        return formatter.render(statementData);
    }

    private int computeFrequentRenterPoints() {
        return this.rentals.stream().mapToInt(Rental::computeFrequentRenterPoints).sum();
    }

    private double computeTotalAmount() {
        return this.rentals.stream().mapToDouble(Rental::calculateAmount).sum();
    }
}
