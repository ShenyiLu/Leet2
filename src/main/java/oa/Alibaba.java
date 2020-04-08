package oa;

import java.util.Scanner;

public class Alibaba {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int[] nmab = new int[4];
            for (int j = 0; j < nmab.length; j++) {
                nmab[j] = in.nextInt();
            }
            System.out.println(training(nmab));
        }
    }

    private static int training(int[] nmab) {
        int n = nmab[0];
        int m = nmab[1];
        int a = nmab[2];
        int b = nmab[3];
        if (a > n) {
            return 0;
        }
        if (a == n) {
            return Math.min(m, b);
        }

        if (m <= b) {
            return m;
        }

        int maxPossible = b + m % b;

        return Math.min(m, (n * b) / a);
    }
}
