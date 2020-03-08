package solutions;

import oa.SAPpractice;
import oa.TuSimpleGroup7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static oa.TuSimpleGroup13.findBeforeMatrix;

public class Driver {
    public static void main(String[] args) {
//        SAPpractice p = new SAPpractice();
//        System.out.println(p.getBingo(7892));
//
//
//        int n = 200;
//        int[] input = {26123, 11929, 12877, 17767, 14279, 20567, 8321, 9593, 11041, 5429, 7387, 5561, 4757,
//                9017, 12827, 15049, 15943, 19153, 24523, 22879, 17201, 19673, 26549, 13483, 10961};
//
//        System.out.println(p.decodeMessage(n, input));

//        int fuel = 5;
//        int[] cityArray = {2,6,2,3,4,8};
//        List<Integer> cities = new ArrayList<>();
//        for (int c: cityArray) {
//            cities.add(c);
//        }
//
//        int r = TuSimpleGroup7.countRoutes(fuel, cities);
//        System.out.println(r);
        System.out.println(findBeforeMatrix(Arrays.asList(Arrays.asList(2, 5), Arrays.asList(7, 17))));
    }

}
