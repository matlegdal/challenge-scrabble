package com.matlegdal.codingame;

import java.util.HashMap;
import java.util.Map;

public class Helpers {
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