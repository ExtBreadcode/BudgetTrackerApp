import java.util.ArrayList;
import java.util.List;

public class BudgetTracker {
    private List<Transaction> transactions;

    public BudgetTracker() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public double getBalance() {
        double balance = 0.0;
        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase("Income")) {
                balance += transaction.getAmount();
            } else if (transaction.getType().equalsIgnoreCase("Expense")) {
                balance -= transaction.getAmount();
            }
        }
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void displayTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
