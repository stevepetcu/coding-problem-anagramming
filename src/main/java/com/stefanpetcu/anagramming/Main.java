package com.stefanpetcu.anagramming;

import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a word and a dictionary <word>; <dictionary_word1>, <dictionary_word2>: ");

        String[] userInputArray = scanner.nextLine().split("; ");

        scanner.close();

        String word = userInputArray[0];
        String[] dictionary = userInputArray[1].split(", ");

        AnagramFilter anagramFilter = new AnagramFilterImpl();

        long startTime = System.nanoTime();
        List<String> result = anagramFilter.syncFilterAnagrams(word, dictionary);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
        System.err.println("Took: " + duration);

        System.out.println(String.join(", ", result));
    }
}
