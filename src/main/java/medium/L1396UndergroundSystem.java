package medium;

import java.util.HashMap;

public class L1396UndergroundSystem {
    HashMap<String, int[]> totalTimeBetweenStations;
    HashMap<Integer, CustomerStatus> customerStatusMap;

    public L1396UndergroundSystem() {
        totalTimeBetweenStations = new HashMap<>();
        customerStatusMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        customerStatusMap.putIfAbsent(id, new CustomerStatus(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CustomerStatus customerIn = customerStatusMap.get(id);
        String combinedStationName = combineStationName(customerIn.getStationIn(), stationName);
        int time = t - customerIn.getTimeIn();
        int[] totalTimeAndCount = totalTimeBetweenStations.getOrDefault(combinedStationName, new int[]{0, 0});
        totalTimeAndCount[0] += time;
        totalTimeAndCount[1] += 1;
        totalTimeBetweenStations.put(combinedStationName, totalTimeAndCount);
        customerStatusMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] totalTimeAndCount = totalTimeBetweenStations.get(combineStationName(startStation, endStation));
        return (double) totalTimeAndCount[0] / totalTimeAndCount[1];
    }

    private String combineStationName(String startStation, String endStation) {
        return startStation + "---" + endStation;
    }

    private class CustomerStatus {
        private String stationIn;
        private int timeIn;

        public CustomerStatus(String station, int time) {
            stationIn = station;
            timeIn = time;
        }

        public int getTimeIn() {
            return timeIn;
        }

        public String getStationIn() {
            return stationIn;
        }
    }
}
