package video_store;

public class Customer {
    private final String name;

    private final Rentals rentals = Rentals.empty();


    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement(StatementFormatter formatter) {
        final double totalAmount = this.rentals.computeTotalAmount();
        final int frequentRenterPoints = this.rentals.computeFrequentRenterPoints();
        final StatementDto statementDto = new StatementDto(name, totalAmount, frequentRenterPoints, this.rentals);
        return formatter.render(statementDto);
    }
}
