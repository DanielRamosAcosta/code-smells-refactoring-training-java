package video_store;

import java.util.List;

public class StatementDto {
    private final String name;
    private final Rentals rentals;
    private final double totalAmount;
    private final int frequentRenterPoints;

    public StatementDto(String name, double totalAmount, int frequentRenterPoints, Rentals rentals) {
        this.totalAmount = totalAmount;
        this.frequentRenterPoints = frequentRenterPoints;
        this.name = name;
        this.rentals = rentals;
    }

    public String getName() {
        return name;
    }

    public Rentals getRentals() {
        return rentals;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }
}
