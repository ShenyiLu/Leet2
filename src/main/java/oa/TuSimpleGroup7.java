package oa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TuSimpleGroup7 {
    public static int countRoutes(int fuel, List<Integer> cities) {
        // Write your code here
        // get rid of duplicate cities
        ArrayList<Integer> startIndex = new ArrayList<>();
        HashSet<Integer> visitedCity = new HashSet<>();

        // build index of visited city
        int start = cities.get(0);
        startIndex.add(0);
        for (int i = 1; i < cities.size(); i++) {
            if (cities.get(i) == start) {
                startIndex.add(i);
            }
        }

        int max = -1;
        for (int startCity : startIndex) {
            max = Math.max(max, bfs(fuel, startCity, cities, visitedCity));
            visitedCity.clear();
        }
        return max;
    }

    private static int bfs(int fuelRemain, int currentCity, List<Integer> cities, HashSet<Integer> visitedCity) {
        int routeCount = 0;
        if (fuelRemain == 0 || currentCity == cities.size() - 1) {
            return 1;
        }

        visitedCity.add(cities.get(currentCity));
        boolean lastCity = true;
        for (int i = currentCity + 1; i < cities.size(); i++) {
            if (visitedCity.contains(cities.get(i))) {
                continue;
            }
            int newRemain = fuelRemain - Math.abs((cities.get(i) - cities.get(currentCity)));
            if (newRemain >= 0) {
                routeCount = routeCount + bfs(newRemain, i, cities, visitedCity);
                lastCity = false;
            }
        }
        if (lastCity) {
            routeCount = 1;
        }
        visitedCity.remove(cities.get(currentCity));
        return routeCount;
    }
}
