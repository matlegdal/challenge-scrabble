package com.matlegdal.codingame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ScrabbleTest {
    public static final String WORD = "word";
    public static final String LETTERS_FOR_WORD_PLUS_ONE = "ordwe";
    public static final String ANOTHER_WORD = "another";

    @Test
    void givenOnlyOneWordThatFitsTheLetters_whenResolving_thenChooseThisWord() {
        Scrabble scrabble = scrabbleWith(WORD, ANOTHER_WORD);

        String result = scrabble.resolve(LETTERS_FOR_WORD_PLUS_ONE);

        assertEquals(WORD, result);
    }

    private Scrabble scrabbleWith(String... words) {
        Set<String> dic = new HashSet<>();
        Collections.addAll(dic, words);
        return new Scrabble(dic);
    }
}