package TransactionAnalyzers;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public abstract class TransactionCSVReader  {

    public static List<Transaction> readTransactions(String filePath) {
        List<Transaction> transactions=new ArrayList<Transaction>();
        for (String line : getTransaction(filePath))
        {
            transactions.add(parseTransaction(line));
        }
        return transactions;
    }

    private static List<String> getTransaction(String filePath)
    {
        List<String> lineces= new ArrayList<String>();
        try {
            URL url = new URL(filePath);
            // Відкриття потоку для читання з URL
            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lineces.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineces;
    }
    private static Transaction parseTransaction(String text)
    {
        var transaction=new Transaction();
        String[] values=text.split(",");
        transaction= new Transaction(values[0], Double.parseDouble(values[1]), values[2]);
        return transaction;
    }


}
