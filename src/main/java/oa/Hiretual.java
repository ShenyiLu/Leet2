package oa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Hiretual {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("2015-01-01");
        list1.add("2017-01-01");
        List<String> list2 = new ArrayList<>();
        list2.add("2016-01-01");
        list2.add("2017-01-01");
        List<String> list3 = new ArrayList<>();
        list3.add("2017-01-01");
        list3.add("present");

        List<List<String>> input = new ArrayList<>();
        input.add(list1);
        input.add(list2);
        input.add(list3);

        int totalMonth = count_working_months_special(input);
        System.out.println(totalMonth);
    }


    private static int[] parseDate(String dateStr) {
        String[] strArray = dateStr.split("-");
        int[] result = new int[2];
        for (int i = 0; i < 2; i++) {
            result[i] = Integer.parseInt(strArray[i].trim());
        }
        return result;
    }

    private static int count_working_months_special(List<List<String>> input) {
        int sum = 0;
        List<Working> workingList = new ArrayList<>();
        Stack<Working> started = new Stack<>();
        for (List<String> subInput: input) {
            parseOneJob(subInput, workingList);
        }

        Collections.sort(workingList);

        Working startWorking = null;
        for (Working w: workingList) {
            if (w.ifStart()) {
                if (started.isEmpty()){
                    startWorking = w;

                }
                started.push(w);

            } else {
                started.pop();
                if (startWorking != null && started.isEmpty()) {
                    sum += getTimeDifference(startWorking, w);
                }

            }

        }
        return sum;

    }

    private static int getTimeDifference(Working start, Working end) {
        int startYear = start.getYear();
        int startMonth = start.getMonth();
        int endYear = end.getYear();
        int endMonth = end.getMonth();

        if (endMonth < startMonth) {
            endMonth += 12;
            endYear -= 1;
        }

        return 12 * (endYear - startYear) + (endMonth - startMonth);
    }

    private static void parseOneJob(List<String> input, List<Working> workingList) {
        String date1 = input.get(0);
        String date2 = input.get(1);
        if (date2.equals("present")) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            date2 = dateFormat.format(date).toString();
        }
        int[] date1Array = parseDate(date1);
        int[] date2Array = parseDate(date2);

        Working working1 = new Working(date1Array[0], date1Array[1], true);
        Working working2 = new Working(date2Array[0], date2Array[1], false);
        workingList.add(working1);
        workingList.add(working2);
    }


}

class Working implements Comparable<Working> {
    int year;
    int month;
    boolean start;
    public Working(int year, int month, boolean start) {
        this.year = year;
        this.month = month;
        this.start = start;
    }

    public int compareTo(Working w1) {
        if (this.year == w1.getYear()) {
            return this.month - w1.getMonth();
        }
        return this.year - w1.getYear();
    }

    public int getYear() {
        return year;
    }

    public int getMonth(){
        return month;}

    public boolean ifStart() {
        return start;
    }
}

