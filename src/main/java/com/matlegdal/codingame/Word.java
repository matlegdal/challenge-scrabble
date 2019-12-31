package com.matlegdal.codingame;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Word  {
    private String word;
    private Map<Character, Integer> countOfLetters;
    private int score;

    public Word(String word) {
        this.word = word;
        countOfLetters = countLetters(word);
        score = countPoints(countOfLetters);
    }

    private int countPoints(Map<Character, Integer> countOfLetters) {
        return countOfLetters.entrySet().stream()
            .mapToInt(entry -> Helpers.POINTS_FOR_LETTERS.get(entry.getKey()) * entry.getValue())
            .sum();
    }

    private Map<Character, Integer> countLetters(String word) {
        Map<Character, Integer> countOfLetters = new HashMap<>();
        for (char character : word.toCharArray()) {
            countOfLetters.putIfAbsent(character, 0);
            countOfLetters.compute(character, (letter, count) -> ++count);
        }
        return countOfLetters;
    }

    public int getScore() {
        return score;
    }

    public boolean isContainedIn(Word letters) {
        return countOfLetters.entrySet().stream()
            .allMatch(hasEnoughLetter(letters));
    }

    private Predicate<Map.Entry<Character, Integer>> hasEnoughLetter(Word letters) {
        return entry -> entry.getValue() <= letters.countOfLetters.getOrDefault(entry.getKey(), 0);
    }

    public String asString() {
        return word;
    }
}