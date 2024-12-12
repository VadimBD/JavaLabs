package org.example;
import TransactionAnalyzers.Transaction;
import TransactionAnalyzers.TransactionAnalyzer;
import TransactionAnalyzers.TransactionCSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TransactionAnalyzerTest{
    @Test
    public void testCalculateTotalBalance() {
        // Створення тестових даних
        Transaction transaction1 = new Transaction("2023-01-01", 100.0, "Дохід");
        Transaction transaction2 = new Transaction("2023-01-02", -50.0, "Витрата");
        Transaction transaction3 = new Transaction("2023-01-03", 150.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);




        // Виклик методу, який потрібно протестувати
        double result = TransactionAnalyzer.calculateTotalBalance(transactions);

        // Перевірка результату
        assertEquals(200.0, result, "Розрахунок загального балансу неправильний");
    }
    @Test
    public void testCountTransactionsByMonth() {
        // Підготовка тестових даних
        Transaction transaction1 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction transaction2 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction transaction3 = new Transaction("05-03-2023", 100.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        // Створення екземпляру TransactionAnalyzer з тестовими даними


        int countFeb = TransactionAnalyzer.countTransactionsByMonth( "02-2023",transactions,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        int countMar = TransactionAnalyzer.countTransactionsByMonth("03-2023",transactions,DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        // Перевірка результатів
        assertEquals(2, countFeb, "Кількість транзакцій за лютий неправильна");
        assertEquals(1, countMar, "Кількість транзакцій за березень неправильна");
    }

    @Test
    public void CanReadFile()
    {
        String file="https://informer.com.ua/dut/java/pr2.csv";
        var result= TransactionCSVReader.readTransactions(file);
        assertNotNull(result);
        Assertions.assertTrue(result.size() > 0);
    }
    @Test
    public void CanFindTopTransactions()
    {
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(new Transaction("02-01-2023",-10000,""));
        for (int i=1;i<21;i++)
        {
            transactions.add(new Transaction("05-03-2023",-i,""));
            transactions.add(new Transaction("05-03-2023",i,""));
        }
        transactions.add(new Transaction("02-04-2023",-10000,""));
       var result= TransactionAnalyzer.findTopTransactionsByMonth("03-2023",transactions,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
       assertNotNull(result);
       assertNotNull(result.CheapestTransactions);
        assertNotNull(result.ExpensiveTransactions);
        assertEquals(10, result.CheapestTransactions.size());
        assertEquals(10, result.ExpensiveTransactions.size());
        assertEquals(result.ExpensiveTransactions.get(0).getAmount(),-20);
        assertEquals(result.ExpensiveTransactions.get(0).getDate(),"05-03-2023");
        assertEquals(result.CheapestTransactions.get(0).getAmount(),-1);
        assertEquals(result.CheapestTransactions.get(0).getDate(),"05-03-2023");
        assertFalse(result.ExpensiveTransactions.stream().anyMatch(x->!x.getDate().equals("05-03-2023")));
        assertFalse(result.CheapestTransactions.stream().anyMatch(x->!x.getDate().equals("05-03-2023")));
        assertFalse(result.ExpensiveTransactions.stream().anyMatch(x->x.getAmount()>0));
        assertFalse(result.CheapestTransactions.stream().anyMatch(x->x.getAmount()>0));
    }

}
