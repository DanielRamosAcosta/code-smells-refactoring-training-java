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

    int frequentRenterPointsFor(int daysRented1) {
        int frequentRenterPointsToAdd = 1;
        if (priceCode == NEW_RELEASE) {
            if (daysRented1 > 1) {
                frequentRenterPointsToAdd++;
            }
        }
        return frequentRenterPointsToAdd;
    }

    double amountFor(int daysRented1) {
        if (priceCode == REGULAR) {
            double thisAmount = 0;
            thisAmount += 2;
            if (daysRented1 > 2)
                thisAmount += (daysRented1 - 2) * 1.5;
            return thisAmount;
        } else if (priceCode == NEW_RELEASE) {
            double thisAmount = 0;
            thisAmount += daysRented1 * 3;
            return thisAmount;
        } else if (priceCode == CHILDRENS) {
            double thisAmount = 0;
            thisAmount += 1.5;
            if (daysRented1 > 3)
                thisAmount += (daysRented1 - 3) * 1.5;
            return thisAmount;
        }
        return 0;
    }
}
