package video_store;

import java.util.List;

public class StatementData {
    private final double totalAmount;
    private final int frequentRenterPoints;
    private final List<Rental> rentals;
    private final String name;

    public StatementData(double totalAmount, int frequentRenterPoints, List<Rental> rentals, String name) {
        this.totalAmount = totalAmount;
        this.frequentRenterPoints = frequentRenterPoints;
        this.rentals = rentals;
        this.name = name;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public String getName() {
        return name;
    }
}
