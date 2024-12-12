package org.example;
import TransactionAnalyzers.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
public class Main {
    public static void main(String[] args) {

                String filePath = "https://informer.com.ua/dut/java/pr2.csv";
                List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

                for (Transaction transaction : transactions) {
                    System.out.println(transaction);
                }

        double totalBalance = TransactionAnalyzer.calculateTotalBalance(transactions);
        TransactionReportGenerator.printBalanceReport(totalBalance);

        System.out.println("Загальний баланс: " + totalBalance);
        String monthYear = "01-2024";
        int transactionsCount = TransactionAnalyzer.countTransactionsByMonth(monthYear,transactions, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        TransactionReportGenerator.printTransactionsCountByMonth(monthYear, transactionsCount);
        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);
        TransactionReportGenerator.printTopExpensesReport(topExpenses);

    }

    }
