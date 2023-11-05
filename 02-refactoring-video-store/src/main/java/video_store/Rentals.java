package video_store;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Rentals {
    private final List<Rental> rentals = new ArrayList<>();

    public static Rentals empty() {
        return new Rentals();
    }

    private Rentals() {}

    public void add(Rental rental) {
        rentals.add(rental);
    }

    int computeFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::computeFrequentRenterPoints).sum();
    }

    double computeTotalAmount() {
        return rentals.stream().mapToDouble(Rental::calculateAmount).sum();
    }

    public <T> List<T> map(Function<Rental, T> toFunction) {
        return rentals.stream().map(toFunction).collect(java.util.stream.Collectors.toList());
    }
}
