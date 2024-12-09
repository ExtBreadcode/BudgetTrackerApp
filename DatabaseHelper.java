import java.io.*;
import java.util.*;

public class DatabaseHelper {

    private static final String FILE_PATH = "resources/budget_data.txt";

    public static void saveTransactions(List<Transaction> transactions) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Transaction transaction : transactions) {
                writer.write(transaction.getType() + ";" + transaction.getDescription() + ";" + transaction.getAmount());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving transactions: " + e.getMessage());
        }
    }

    public static List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String type = parts[0];
                String description = parts[1];
                double amount = Double.parseDouble(parts[2]);
                transactions.add(new Transaction(description, amount, type));
            }
        } catch (IOException e) {
            System.out.println("Error loading transactions: " + e.getMessage());
        }
        return transactions;
    }
}
