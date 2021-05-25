package solutions;


import medium.L547FindCircleNum;


public class Driver {
    public static void main(String[] args) {
        L547FindCircleNum newNum = new L547FindCircleNum();
//        int[][] isConnected = new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        int[][] isConnected = new int[][]{{1,1,0},{1,1,0},{0,0,1}};

        System.out.println(newNum.findCircleNum(isConnected));
    }

}
