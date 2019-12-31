package com.matlegdal.codingame.solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        Set<String> words = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            words.add(in.nextLine());
        }
        String letters = in.nextLine();

        Scrabble scrabble = new Scrabble(words);

        String found = scrabble.resolve(letters);
        System.out.println(found);
    }
}

class Scrabble {
    Set<Word> words = new LinkedHashSet<>();

    public Scrabble(Set<String> words) {
        for (String string : words) {
            this.words.add(new Word(string));
        }
    }

    public String resolve(String stringOfLetters) {
        Word letters = new Word(stringOfLetters);

        Word candidate = words.stream()
            .filter(word -> word.isContainedIn(letters))
            .max(Comparator.comparing(Word::getScore))
            .orElseThrow(NoMatchingWord::new);

        return candidate.asString();
    }
}

class Word {
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

class NoMatchingWord extends RuntimeException {
}

class Helpers {
    public static final Map<Character, Integer> POINTS_FOR_LETTERS = new HashMap<>();

    static {
        POINTS_FOR_LETTERS.put('a', 1);
        POINTS_FOR_LETTERS.put('b', 3);
        POINTS_FOR_LETTERS.put('c', 3);
        POINTS_FOR_LETTERS.put('d', 2);
        POINTS_FOR_LETTERS.put('e', 1);
        POINTS_FOR_LETTERS.put('f', 4);
        POINTS_FOR_LETTERS.put('g', 2);
        POINTS_FOR_LETTERS.put('h', 4);
        POINTS_FOR_LETTERS.put('i', 1);
        POINTS_FOR_LETTERS.put('j', 8);
        POINTS_FOR_LETTERS.put('k', 5);
        POINTS_FOR_LETTERS.put('l', 1);
        POINTS_FOR_LETTERS.put('m', 3);
        POINTS_FOR_LETTERS.put('n', 1);
        POINTS_FOR_LETTERS.put('o', 1);
        POINTS_FOR_LETTERS.put('p', 3);
        POINTS_FOR_LETTERS.put('q', 10);
        POINTS_FOR_LETTERS.put('r', 1);
        POINTS_FOR_LETTERS.put('s', 1);
        POINTS_FOR_LETTERS.put('t', 1);
        POINTS_FOR_LETTERS.put('u', 1);
        POINTS_FOR_LETTERS.put('v', 4);
        POINTS_FOR_LETTERS.put('w', 4);
        POINTS_FOR_LETTERS.put('x', 8);
        POINTS_FOR_LETTERS.put('y', 4);
        POINTS_FOR_LETTERS.put('z', 10);
    }
}