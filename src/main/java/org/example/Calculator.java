package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;

public class Calculator {
    private Map<String, Function<String, Double>> functions = new HashMap<>();

    public Calculator() {
        InitFunctions();
    }

    private void InitFunctions() {
        functions.put("+", this::Sum);
        functions.put("*", this::Multiply);
        functions.put("-", this::Subtract);
        functions.put("/", this::Divide);
        functions.put("sqrt", this::SquareRoot);
    }

    public double Calculate(String input) {
        for (Map.Entry<String, Function<String, Double>> entry : functions.entrySet()) {
            if (input.contains(entry.getKey())) {
                return entry.getValue().apply(input);
            }
        }
        throw new RuntimeException("Undefined mathematical operation");
    }

    private double Sum(String value) {
        try {
            double[] operands = parseOperands(value, "+");
            return operands[0] + operands[1];
        } catch (Exception e) {
            throw new RuntimeException("Error during addition operation: " + e.getMessage(), e);
        }
    }

    private double Multiply(String value) {
        try {
            double[] operands = parseOperands(value, "*");
            return operands[0] * operands[1];
        } catch (Exception e) {
            throw new RuntimeException("Error during multiplication operation: " + e.getMessage(), e);
        }
    }

    private double Subtract(String value) {
        try {
            double[] operands = parseOperands(value, "-");
            return operands[0] - operands[1];
        } catch (Exception e) {
            throw new RuntimeException("Error during subtraction operation: " + e.getMessage(), e);
        }
    }

    public double Divide(String value) {
        try {
            double[] operands = parseOperands(value, "/");
            if (operands[1] == 0) {
                throw new ArithmeticException("Divide by zero");
            }
            return operands[0] / operands[1];
        } catch (Exception e) {
            throw new RuntimeException("Error during division operation: " + e.getMessage(), e);
        }
    }

    private double SquareRoot(String value) {
        try {
            String sanitized = value.replace("sqrt(", "").replace(")", "").trim();
            double number = Double.parseDouble(sanitized);
            if (number < 0) {
                throw new RuntimeException("The value must be greater than zero");
            }
            return Math.sqrt(number);
        } catch (Exception e) {
            throw new RuntimeException("Error during square root operation: " + e.getMessage(), e);
        }
    }

    private double[] parseOperands(String value, String operator) {
        String[] splitResult = value.split(Pattern.quote(operator));
        if (splitResult.length != 2) {
            throw new RuntimeException("Invalid input format for operation: " + operator);
        }
        try {
            return new double[]{
                    Double.parseDouble(splitResult[0].trim()),
                    Double.parseDouble(splitResult[1].trim())
            };
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid number format in input: " + value, e);
        }
    }
}

