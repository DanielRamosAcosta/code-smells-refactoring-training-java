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

    public String getName() {
        return name;
    }

    public String statement() {
        final double totalAmount = computeTotalAmount();
        final int frequentRenterPoints = computeFrequentRenterPoints();
        return renderStatement(totalAmount, frequentRenterPoints, this.rentals, name);
    }

    private static String renderStatement(double totalAmount, int frequentRenterPoints, List<Rental> rentals, String name) {
        List<String> lines = new ArrayList<>();

        lines.add(renderHeader(name));
        for (Rental rental : rentals) {
            lines.add(renderLineFor(rental));
        }
        lines.add(renderTotalAmount(totalAmount));
        lines.add(renderFrequentRenterPoints(frequentRenterPoints));

        return String.join("\n", lines);
    }

    private static String renderFrequentRenterPoints(int frequentRenterPoints) {
        return "You earned " + frequentRenterPoints + " frequent renter points\n";
    }

    private static String renderTotalAmount(double totalAmount) {
        return "You owed " + totalAmount;
    }

    private static String renderLineFor(Rental rental) {
        return "\t" + rental.getTitle() + "\t" + rental.calculateAmount();
    }

    private static String renderHeader(String name) {
        return "Rental Record for " + name;
    }

    private int computeFrequentRenterPoints() {
        return this.rentals.stream().mapToInt(Rental::computeFrequentRenterPoints).sum();
    }

    private double computeTotalAmount() {
        return this.rentals.stream().mapToDouble(Rental::calculateAmount).sum();
    }
}
