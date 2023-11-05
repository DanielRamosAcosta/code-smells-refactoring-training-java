package video_store;

public class ChildrensMovie extends Movie {
    public ChildrensMovie(String title) {
        super(title);
    }

    @Override
    protected int limitDaysForRental() {
        return 3;
    }

    @Override
    protected double baseAmount() {
        return 1.5;
    }
}
