package video_store;

import java.util.ArrayList;
import java.util.List;

public class ConsoleStatementFormatter implements StatementFormatter {
    @Override
    public String render(StatementData statementData) {
        List<String> lines = new ArrayList<>();

        lines.add(renderHeader(statementData.getName()));
        for (Rental rental : statementData.getRentals()) {
            lines.add(renderLineFor(rental));
        }
        lines.add(renderTotalAmount(statementData.getTotalAmount()));
        lines.add(renderFrequentRenterPoints(statementData.getFrequentRenterPoints()));

        return String.join("\n", lines);
    }

    private String renderFrequentRenterPoints(int frequentRenterPoints) {
        return "You earned " + frequentRenterPoints + " frequent renter points\n";
    }

    private String renderTotalAmount(double totalAmount) {
        return "You owed " + totalAmount;
    }

    private String renderLineFor(Rental rental) {
        return "\t" + rental.getTitle() + "\t" + rental.calculateAmount();
    }

    private String renderHeader(String name) {
        return "Rental Record for " + name;
    }
}
