import org.example.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the expression you want to calculate: ");
        String expression = scanner.nextLine();
        var calculator = new Calculator();

        try {
            System.out.println(calculator.Calculate(expression));
        } catch (RuntimeException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
