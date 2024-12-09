public class Transaction {
    private String description;
    private double amount;
    private String type; // "Income" or "Expense"

    public Transaction(String description, double amount, String type) {
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + ": " + description + " - $" + amount;
    }
}

