package video_store;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private final String title;

    public static Movie create(String title, int priceCode) {
        return switch (priceCode) {
            case CHILDRENS -> childrens(title);
            case NEW_RELEASE -> getNewReleaseMovie(title);
            default -> regular(title);
        };
    }

    public static Movie regular(String title) {
        return new Movie(title);
    }

    public static NewReleaseMovie getNewReleaseMovie(String title) {
        return new NewReleaseMovie(title);
    }

    public static ChildrensMovie childrens(String title) {
        return new ChildrensMovie(title);
    }

    Movie(String title) {
        this.title = title;
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
