package TransactionAnalyzers;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.Setter;

@Setter
public abstract class TransactionAnalyzer {

    // Метод для розрахунку загального балансу
    public static double calculateTotalBalance( List<Transaction> transactions) {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }
    public static int countTransactionsByMonth(String monthYear, List<Transaction> transactions,DateTimeFormatter dateFormatter) {
        int count = 0;
        for (Transaction transaction : transactions) {
            LocalDate date = LocalDate.parse(transaction.getDate(), dateFormatter);
            String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            if (transactionMonthYear.equals(monthYear)) {
                count++;
            }
        }
        return count;
    }
    public static List<Transaction> findTopExpenses( List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0) // Вибірка лише витрат (від'ємні значення)
                .sorted(Comparator.comparing(Transaction::getAmount)) // Сортування за сумою
                .limit(10) // Обмеження результату першими 10 записами
                .collect(Collectors.toList()); // Збір результату в список
    }

    public static FindTopResult findTopTransactionsByMonth(String monthYear , List<Transaction> transactions,DateTimeFormatter dateFormatter) {
        List<Transaction> monthTransactions= new ArrayList<>();
        for (Transaction transaction : transactions) {
            LocalDate date = LocalDate.parse(transaction.getDate(), dateFormatter);
            String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            if (transactionMonthYear.equals(monthYear)) {
                monthTransactions.add(transaction);
            }
        }
        var result= new FindTopResult();
        var filteredTransactions = monthTransactions.stream().filter(t -> t.getAmount() < 0).toList();
        result.ExpensiveTransactions = filteredTransactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount))
                .limit(10)
                .collect(Collectors.toList());
        result.CheapestTransactions=filteredTransactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .limit(10)
                .collect(Collectors.toList());

       return result;
    }

}
