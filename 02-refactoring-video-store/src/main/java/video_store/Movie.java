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
        if (priceCode == REGULAR) {
            return 1.5;
        } else if (priceCode == NEW_RELEASE) {
            return 3;
        } else if (priceCode == CHILDRENS) {
            return 1.5;
        }
        return 0;
    }

    int limitDaysForRental() {
        if (priceCode == REGULAR) {
            return 2;
        } else if (priceCode == NEW_RELEASE) {
            return 0;
        } else if (priceCode == CHILDRENS) {
            return 3;
        }
        return 0;
    }

    double baseAmount() {
        if (priceCode == REGULAR) {
            return 2;
        } else if (priceCode == NEW_RELEASE) {
            double thisAmount = 0;
            return thisAmount;
        } else if (priceCode == CHILDRENS) {
            double thisAmount = 1.5;
            return thisAmount;
        }
        return 0;
    }
}
