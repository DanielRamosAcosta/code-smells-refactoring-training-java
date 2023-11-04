package video_store;

public class ChildrensMovie extends Movie {
    public ChildrensMovie(String title) {
        super(title);
    }


    @Override
    double amountForExtraDay() {
        return 1.5;
    }

    @Override
    int limitDaysForRental() {
        return 3;
    }

    @Override
    double baseAmount() {
        return 1.5;
    }
}
