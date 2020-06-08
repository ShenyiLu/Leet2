package solutions;


import medium.L18FourSum;

import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        int[] nums = {-1,-5,-5,-3,2,5,0,4
        };
        int target = -7;
        L18FourSum temp = new L18FourSum();
        List<List<Integer>> result = temp.fourSum(nums, target);
        System.out.println(result);
    }

}
