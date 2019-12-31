package com.matlegdal.codingame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordTest {
    public static final String A_WORD = "banjo";
    public static final int SCORE_OF_THE_WORD = 14;

    @Test
    void whenConstructing_thenCountTheScore() {
        Word word = new Word(A_WORD);

        int score = word.getScore();

        assertEquals(SCORE_OF_THE_WORD, score);
    }
}