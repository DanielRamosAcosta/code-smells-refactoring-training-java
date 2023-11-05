package video_store;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    protected int frequentRenterPointsFor(int daysRented) {
        int frequentRenterPointsToAdd = 1;
        if (daysRented > 1) {
            frequentRenterPointsToAdd++;
        }
        return frequentRenterPointsToAdd;
    }

    @Override
    protected double amountForExtraDay() {
        return 3;
    }

    @Override
    protected int limitDaysForRental() {
        return 0;
    }

    @Override
    protected double baseAmount() {
        return 0;
    }
}
