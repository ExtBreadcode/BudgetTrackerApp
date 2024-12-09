import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BudgetTracker budgetTracker = new BudgetTracker();

        // Load existing transactions from file
        budgetTracker.getTransactions().addAll(DatabaseHelper.loadTransactions());

        while (true) {
            System.out.println("Budget Tracker");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. View Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("Enter transaction type (Income/Expense): ");
                String type = scanner.nextLine();
                System.out.print("Enter transaction description: ");
                String description = scanner.nextLine();
                System.out.print("Enter transaction amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();  // Consume newline

                Transaction transaction = new Transaction(description, amount, type);
                budgetTracker.addTransaction(transaction);
                System.out.println("Transaction added.");
            } else if (choice == 2) {
                System.out.println("Transactions:");
                budgetTracker.displayTransactions();
            } else if (choice == 3) {
                System.out.println("Current balance: $" + budgetTracker.getBalance());
            } else if (choice == 4) {
                // Save transactions to file before exiting
                DatabaseHelper.saveTransactions(budgetTracker.getTransactions());
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
