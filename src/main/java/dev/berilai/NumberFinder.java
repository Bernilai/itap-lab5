package dev.berilai;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price is $19.99, another price is 123, and a third is 456.78. Also, 999 and 1234567.89 and 123456789123 and 0,1 and .5 and -.5 and 19.4532."; // Пример строки без чисел

        try {
            findAndPrintNumbers(text);
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void findAndPrintNumbers(String text) {
        Pattern pattern = Pattern.compile("-?(?:\\d+(?:[.,]\\d+)?|[.,]\\d+)");
        Matcher matcher = pattern.matcher(text);

        boolean numbersFound = matcher.find();
        if (!numbersFound) {
            throw new IllegalStateException("Error: No numbers found in the input string.");
        }

        matcher.reset();
        while (matcher.find()) {
            System.out.println(matcher.group().replace(',', '.'));
        }
    }
}
