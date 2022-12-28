package com.stefanpetcu.anagramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class AnagramFilterImpl implements AnagramFilter {
    @Override
    public List<String> filterAnagrams(String word, String... dictionary) {
        Set<Character> wordSet = new HashSet<>();

        for (char c : word.toCharArray()) {
            wordSet.add(c);
        }

        List<String> anagrams = Collections.synchronizedList(new ArrayList<>());

        Stream<String> dictionaryStream = StreamSupport.stream(Arrays.stream(dictionary).spliterator(), true);
        dictionaryStream.forEach(dictionaryWord -> {
            if (dictionaryWord.length() - word.length() == 1) {
                Set<Character> dictionaryWordSet = new HashSet<>();
                for (char c : dictionaryWord.toCharArray()) {
                    dictionaryWordSet.add(c);
                }

                if (dictionaryWordSet.containsAll(wordSet)) {
                    anagrams.add(dictionaryWord);
                }
            }
        });

        return anagrams;
    }

    @Override
    public List<String> syncFilterAnagrams(String word, String... dictionary) {
        Set<Character> wordSet = new HashSet<>();

        for (char c : word.toCharArray()) {
            wordSet.add(c);
        }

        List<String> anagrams = new ArrayList<>();

        for (String s : dictionary) {
            if (s.length() - word.length() == 1) {
                Set<Character> dictionaryWordSet = new HashSet<>();
                for (char c : s.toCharArray()) {
                    dictionaryWordSet.add(c);
                }

                if (dictionaryWordSet.containsAll(wordSet)) {
                    anagrams.add(s);
                }
            }
        }

        return anagrams;
    }
}
