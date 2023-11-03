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

    public int getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }

    int frequentRenterPointsFor(int daysRented1) {
        int frequentRenterPointsToAdd = 1;
        if (getPriceCode() == NEW_RELEASE) {
            if (daysRented1 > 1) {
                frequentRenterPointsToAdd++;
            }
        }
        return frequentRenterPointsToAdd;
    }

    double amountFor(int daysRented1) {
        double thisAmount = 0;
        switch (getPriceCode()) {
            case REGULAR:
                thisAmount += 2;
                if (daysRented1 > 2)
                    thisAmount += (daysRented1 - 2) * 1.5;
                break;
            case NEW_RELEASE:
                thisAmount += daysRented1 * 3;
                break;
            case CHILDRENS:
                thisAmount += 1.5;
                if (daysRented1 > 3)
                    thisAmount += (daysRented1 - 3) * 1.5;
                break;
        }
        return thisAmount;
    }
}
