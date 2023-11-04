package video_store;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    int frequentRenterPointsFor(int daysRented) {
        int frequentRenterPointsToAdd = 1;
        if (daysRented > 1) {
            frequentRenterPointsToAdd++;
        }
        return frequentRenterPointsToAdd;
    }

    @Override
    double amountForExtraDay() {
        return 3;
    }

    @Override
    int limitDaysForRental() {
        return 0;
    }

    @Override
    double baseAmount() {
        return 0;
    }
}
