package com.matlegdal.codingame;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Scrabble {
    Set<String> words;

    public Scrabble(Set<String> words) {
        this.words = words;
    }

    public String resolve(String letters) {
        Map<Character, Long> letterMap = explode(letters);
        for (String word : words) {
            if (match(explode(word), letterMap)) {
                return word;
            }
        }
        throw new NoMatchingWord();
    }

    private Map<Character, Long> explode(String letters) {
        Map<Character, Long> map = new HashMap<>();
        for (char character : letters.toCharArray()) {
            map.putIfAbsent(character, 0L);
            map.compute(character, (letter, count) -> ++count);
        }
        return map;
    }

    private boolean match(Map<Character, Long> word, Map<Character, Long> letters) {
        return word.equals(letters);
    }
}
