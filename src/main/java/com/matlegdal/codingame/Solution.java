package com.matlegdal.codingame;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        Set<String> words = new HashSet<>();

        for (int i = 0; i < n; i++) {
            words.add(in.nextLine());
        }
        String letters = in.nextLine();

//        Scrabble scrabble = new Scrabble(words);

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println("invalid word");
    }
}