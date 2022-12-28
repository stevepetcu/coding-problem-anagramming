package com.stefanpetcu.anagramming;

import java.util.List;

public interface AnagramFilter {
    List<String> filterAnagrams(String word, String ...dictionary);
    List<String> syncFilterAnagrams(String word, String... dictionary);
}
