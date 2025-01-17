package de.ppi.tasks.service;

import java.util.HashMap;
import java.util.Map;

public class StringProcessor {

    // Checks if a given string is a palindrome (ignores case and spaces)
    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String cleaned = input.replaceAll("[\\s+]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    // Counts the number of words in a given string
    public int countWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        return input.trim().split("\\s+").length;
    }

    // Finds the most frequent word in a given string
    public String mostFrequentWord(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }

        String[] words = input.toLowerCase().split("\\s+");
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        String mostFrequent = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequent = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostFrequent;
    }
}
