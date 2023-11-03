package video_store;

public class Rental {
    private final Movie movie;

    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    String getTitle() {
        return movie.getTitle();
    }

    int computeFrequentRenterPoints() {
        return movie.frequentRenterPointsFor(daysRented);
    }

    double calculateAmount() {
        return movie.amountFor(daysRented);
    }
}
