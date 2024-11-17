package dev.berilai;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalLetterFinder {

    public static String highlightCapitalLetters(String text) {
        Pattern pattern = Pattern.compile("([a-z])([A-Z])");
        Matcher matcher = pattern.matcher(text);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(result, "!" + matcher.group(1) + matcher.group(2) + "!");
        }
        matcher.appendTail(result);
        return result.toString();
    }

    public static void main(String[] args) {
        String text = "ThisIsATestString. AnotherTestStringHere.  aBcDeFg.  Test123Test.";
        String highlightedText = highlightCapitalLetters(text);
        System.out.println("Original text: " + text);
        System.out.println("Highlighted text: " + highlightedText);
    }
}