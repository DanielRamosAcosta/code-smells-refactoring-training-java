package video_store;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private final String title;
    private final int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    int frequentRenterPointsFor(int daysRented) {
        int frequentRenterPointsToAdd = 1;
        if (priceCode == NEW_RELEASE) {
            if (daysRented > 1) {
                frequentRenterPointsToAdd++;
            }
        }
        return frequentRenterPointsToAdd;
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
        return switch (priceCode) {
            case REGULAR -> 1.5;
            case NEW_RELEASE -> 3;
            case CHILDRENS -> 1.5;
            default -> 0;
        };
    }

    int limitDaysForRental() {
        return switch (priceCode) {
            case REGULAR -> 2;
            case NEW_RELEASE -> 0;
            case CHILDRENS -> 3;
            default -> 0;
        };
    }

    double baseAmount() {
        return switch (priceCode) {
            case REGULAR -> 2;
            case NEW_RELEASE -> 0;
            case CHILDRENS -> 1.5;
            default -> 0;
        };
    }
}
