package video_store;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private final String title;
    protected final int priceCode;

    public static Movie create(String title, int priceCode) {
        if (priceCode == CHILDRENS) return new ChildrensMovie(title, Movie.CHILDRENS);
        if (priceCode == NEW_RELEASE) return new NewReleaseMovie(title, Movie.NEW_RELEASE);

        return new Movie(title, REGULAR);
    }

    Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    int frequentRenterPointsFor(int daysRented) {
        return 1;
    }

    double amountFor(int daysRented) {
        final int extraDays = daysPassedRelativeTo(daysRented);
        if (extraDays > 0) {
            return baseAmount() + extraDays * amountForExtraDay();
        }
        return baseAmount();
    }

    private int daysPassedRelativeTo(int daysRented) {
        return daysRented - limitDaysForRental();
    }

    double amountForExtraDay() {
        return 1.5;
    }

    int limitDaysForRental() {
        return 2;
    }

    double baseAmount() {
        return 2;
    }
}
