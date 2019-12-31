package com.matlegdal.codingame;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Scrabble {
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
