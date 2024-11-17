package dev.berilai;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class WordFinder {

    public static List<String> findWordsStartingWith(String text, char startLetter) {

        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }
        if (!Character.isLetter(startLetter)) {
            throw new IllegalArgumentException("Start letter must be a letter.");
        }


        String regex = "\\b" + startLetter + "\\w*\\b"; // \b - граница слова, \w - любая буква или цифра

        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            List<String> foundWords = new ArrayList<>();
            while (matcher.find()) {
                foundWords.add(matcher.group());
            }
            return foundWords;
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Invalid regular expression: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy fox. The dog barks.";
        char startLetter = 'T';

        try {
            List<String> words = findWordsStartingWith(text, startLetter);
            System.out.println("Words starting with '" + startLetter + "': " + words);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        //Пример с некорректной буквой
        try {
            List<String> words2 = findWordsStartingWith(text, '!');
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        //Пример с пустой строкой
        try {
            List<String> words3 = findWordsStartingWith("", 'T');
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
