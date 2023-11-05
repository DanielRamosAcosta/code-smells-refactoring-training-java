package video_store;

public class Movie {
    private final String title;

    public static Movie regular(String title) {
        return new Movie(title);
    }

    public static NewReleaseMovie newRelease(String title) {
        return new NewReleaseMovie(title);
    }

    public static ChildrensMovie childrens(String title) {
        return new ChildrensMovie(title);
    }

    protected Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public double amountFor(int daysRented) {
        final int extraDays = daysPassedRelativeTo(daysRented);
        if (extraDays > 0) {
            return baseAmount() + extraDays * amountForExtraDay();
        }
        return baseAmount();
    }

    private int daysPassedRelativeTo(int daysRented) {
        return daysRented - limitDaysForRental();
    }

    protected int frequentRenterPointsFor(int daysRented) {
        return 1;
    }

    protected double amountForExtraDay() {
        return 1.5;
    }

    protected int limitDaysForRental() {
        return 2;
    }

    protected double baseAmount() {
        return 2;
    }
}
