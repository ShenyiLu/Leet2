package solutions;


import easy.L263UglyNumber;
import hard.L68TextJustification;
import medium.L1048LongestStringChain;
import medium.L18FourSum;
import medium.L934ShortestBridge;
import medium.SnakeGame;

import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        L68TextJustification justification = new L68TextJustification();
//        String[] words = new String[]{"a","b","c","d","e"};
//        List<String> result = justification.fullJustify(words, 3);

//        String[] words = new String[]{"Listen","to","many,","speak","to","a","few."};
//        List<String> result = justification.fullJustify(words, 6);
//
//        System.out.println(result);
//        String temp = "beginIndex";
//        System.out.println("substring(i)");
//        for (int i = 0; i < temp.length(); i++) {
//            System.out.println(temp.substring(i + 1));
//        }
//
//        System.out.println("substring(0, i)");
//        for (int i = 0; i < temp.length(); i++) {
//            System.out.println(temp.substring(0, i));
//        }
        L1048LongestStringChain longestStringChain = new L1048LongestStringChain();
        System.out.println(longestStringChain.longestStrChain(new String[]{"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"}));
    }

}
