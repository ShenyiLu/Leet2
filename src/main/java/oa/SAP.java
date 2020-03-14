package oa;

import java.util.Scanner;

public class SAP {
    public void question1() {
        Scanner input = new Scanner(System.in);
        int y = input.nextInt();
        int x = input.nextInt();
        char[][] classroom = new char[y][x];
        int currentColumn = 0;

        while (input.hasNextLine()) {
            String currentRow = input.nextLine();
            if (currentColumn < y) {
                for (int i = 0; i < currentRow.length(); i++) {
                    classroom[currentColumn][i] = currentRow.charAt(i);
                }
            }
            currentColumn++;
        }

        input.nextLine();

//        for (int i = 0; i < y; i++) {
//            for (int j = 0; j < x; j++) {
//                System.out.print(classroom[i][j]);
//            }
//            System.out.println();
//        }
        // greedy
        // case1: select all even ones, insert to odd ones
        // case2: select all odd ones, insert to even ones
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i < y; i++) {
            // select all even
            for (int even = 0; even < x; even += 2) {
                if (classroom[i][even] == '.') {
                    evenSum++;
                }
            }

            // select all odd
            for (int odd = 1; odd < x; odd += 2) {
                if (classroom[i][odd] == '.') {
                    oddSum++;
                }
            }
        }
        System.out.println("Evensum: " + evenSum);
        System.out.println("Oddsum: " + oddSum);

        // insertion part
        for (int i = 0; i < y; i++) {
            // insert odd ones
            for (int odd = 1; odd < x; odd += 2) {
                if (classroom[i][odd] == '.' && !canCheat(classroom, i, odd)) {
                    evenSum++;
                }
            }
            // insert even ones
            for (int even = 0; even < x; even += 2) {
                if (classroom[i][even] == '.' && !canCheat(classroom, i, even)) {
                    oddSum++;
                }
            }
        }

        System.out.println(Math.max(evenSum, oddSum));
    }

    private static boolean canCheat(char[][] classroom, int y, int x) {
        int height = classroom.length;
        int width = classroom[0].length;

        if (y == 0) {
            if (x >= 1 && classroom[y][x - 1] == '.') {
                return true;
            }
            if (x <= width - 2 && classroom[y][x + 1] == '.') {
                return true;
            }
            return false;
        }

        if (x >= 1) {
            if (classroom[y][x - 1] == '.' || classroom[y - 1][x - 1] == '.') {
                return true;
            }
        }
        if (x <= width - 2) {
            if (classroom[y][x + 1] == '.' || classroom[y - 1][x + 1] == '.') {
                return true;
            }
        }
        return false;
    }

    public void question2() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

    }

    private static boolean containsThree(int n) {
        while (n >= 1) {
            if (n % 10 == 3) {
                return true;
            }
            n /= 10;
        }
        return false;
    }













}
