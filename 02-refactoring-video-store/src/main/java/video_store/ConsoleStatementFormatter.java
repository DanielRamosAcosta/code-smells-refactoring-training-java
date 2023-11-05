package video_store;

import java.util.ArrayList;
import java.util.List;

public class ConsoleStatementFormatter implements StatementFormatter {
    @Override
    public String render(StatementDto statementDto) {
        List<String> lines = new ArrayList<>();
        lines.add(renderHeader(statementDto.getName()));
        lines.addAll(statementDto.getRentals().map(this::renderLineFor));
        lines.add(renderTotalAmount(statementDto.getTotalAmount()));
        lines.add(renderFrequentRenterPoints(statementDto.getFrequentRenterPoints()));
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
