package TransactionAnalyzers;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import  lombok.AllArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private String date;
    private double amount;
    private String description;

    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';

    }
}
