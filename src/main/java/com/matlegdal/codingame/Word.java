package com.matlegdal.codingame;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Word {
    private String word;
    private Map<Character, Long> countOfLetters = new HashMap<>();

    public Word(String word) {
        this.word = word;
        for (char character : word.toCharArray()) {
            countOfLetters.putIfAbsent(character, 0L);
            countOfLetters.compute(character, (letter, count) -> ++count);
        }
    }


    public boolean isContainedIn(Word letters) {
        return countOfLetters.entrySet().stream()
            .allMatch(hasEnoughLetter(letters));
    }

    private Predicate<Map.Entry<Character, Long>> hasEnoughLetter(Word letters) {
        return entry -> entry.getValue() <= letters.countOfLetters.getOrDefault(entry.getKey(), 0L);
    }

    public String asString() {
        return word;
    }
}