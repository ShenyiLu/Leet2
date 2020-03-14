package hackerRankContest;

import java.util.*;

public class Fundraising {
    /*
     * Complete the guestTable function below.
     */
    static void guestTable(int[] generosities, List<List<Integer>> guestTable, int index) {
        /*
         * Write your code here.
         */
        List<Integer> guestList = new ArrayList<>();
        for (int g : generosities) {
            guestList.add(g);
        }
        Collections.sort(guestList, Collections.reverseOrder());
        guestTable.add(guestList);

    }

    /*
     * Complete the solve function below.
     */
    static void solve(int[][] charm, List<List<Integer>> guestTable, int k) {
        /*
         * Write your code here.
         */
        int[][] kRemainsMatrix = new int[charm.length][charm[0].length];
        for (int height = 0; height < charm.length; height++) {
            for (int width = 0; width < charm[0].length; width++) {
                kRemainsMatrix[height][width] = k;
            }
        }

        List<HashMap<TreeSet<Integer>, Integer>> maxProfitAllGroups = new ArrayList<>();

        for (int groupIndex = 0; groupIndex < charm.length; groupIndex++) {
            int[] studentCharm = charm[groupIndex];
            int[] kRemains = kRemainsMatrix[groupIndex];

            HashMap<TreeSet<Integer>, Integer> maxProfitPerGroup = new HashMap<>();
            dfsMaxCollect(studentCharm, guestTable, new ArrayList<>(), kRemains, 0, maxProfitPerGroup);
            maxProfitAllGroups.add(maxProfitPerGroup);
        }

        // build data structure to handle each possible divide
        HashMap<TreeSet<Integer>, List<List<Integer>>> reverseMap = buildReverseMap(maxProfitAllGroups);
        List<List<TreeSet<Integer>>> subsets = getSubsets(reverseMap, guestTable.size());
        int maxCollected = -1;
        for (List<TreeSet<Integer>> layer : subsets) {
            // all layers should be valid
            maxCollected = Math.max(maxCollected, getMax(reverseMap, layer, guestTable.size()));
        }
        System.out.println(maxCollected);
    }

    static List<List<TreeSet<Integer>>> getSubsets(HashMap<TreeSet<Integer>, List<List<Integer>>> reverseMap, int tableCount) {
        List<TreeSet<Integer>> subsetList = new ArrayList<>();
        List<List<TreeSet<Integer>>> result = new ArrayList<>();
        for (TreeSet<Integer> treeSet : reverseMap.keySet()) {
            subsetList.add(treeSet);
        }
        getSubsetDFS(subsetList, 0, tableCount,new HashSet<>(), new ArrayList<>(), result);
        return result;
    }

    // horrible time complexity
    static void getSubsetDFS(List<TreeSet<Integer>> subsetList, int index, int tableCount, HashSet<Integer> visited,
                             List<TreeSet<Integer>> current, List<List<TreeSet<Integer>>> result) {
        if (visited.size() == tableCount) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index >= subsetList.size()) {
            return;
        }

        // case 1: try to include this subset
        boolean hasDuplicate = false;
        TreeSet<Integer> currentTreeSet = subsetList.get(index);
        for (int element: currentTreeSet) {
            if (visited.contains(element)) {
                hasDuplicate = true;
                break;
            }
        }

        // do dfs
        if (!hasDuplicate) {
            for (int element: currentTreeSet) {
                visited.add(element);
            }
            current.add(currentTreeSet);
            getSubsetDFS(subsetList, index + 1, tableCount, visited, current, result);
            current.remove(current.size() - 1);
            for (int element: currentTreeSet) {
                visited.remove(element);
            }
        }

        // case 2: not include this subset
        getSubsetDFS(subsetList, index + 1, tableCount, visited, current, result);
    }


    static int getMax(HashMap<TreeSet<Integer>, List<List<Integer>>> reverseMap, List<TreeSet<Integer>> layer, int tableCount) {
        if (layer.size() == tableCount) {
            // case: subset equals full set
            TreeSet<Integer> set = layer.get(0);
            List<List<Integer>> resultList = reverseMap.get(set);
            int result = -1;
            for (List<Integer> indexAndResult : resultList) {
                result = Math.max(result, indexAndResult.get(1));
            }

            return result;
        } else {
            return findMaxProfit2(layer, reverseMap);
        }
    }
    static void printLayer(List<TreeSet<Integer>> layer) {
        System.out.println("Print one layer of subsets");
        int index = 0;
        for (TreeSet<Integer> treeset: layer) {
            System.out.println("Print Treeset " + index);
            for (int i: treeset) {
                System.out.print(i + " ");
            }
            System.out.println();
            index++;
        }
    }

    static int findMaxProfit2(List<TreeSet<Integer>> searchResult, HashMap<TreeSet<Integer>, List<List<Integer>>> reverseMap) {
        if (searchResult.size() == 0) {
            return -1;
        }

        int max = -1;

        // search result to list of possible solutions
        List<List<List<Integer>>> dfsList = new ArrayList<>();

        for (TreeSet<Integer> key: searchResult) {
            dfsList.add(reverseMap.get(key));
        }

        // do dfs
        max = Math.max(max, findMaxProfitDFS(dfsList, 0, new HashSet<>()));
//        printDFSList(dfsList);
        dfsList.clear();

        return max;
    }

    static int findMaxProfit(List<List<TreeSet<Integer>>> searchResult, HashMap<TreeSet<Integer>, List<List<Integer>>> reverseMap) {
        if (searchResult.size() == 0) {
            return -1;
        }

        int max = -1;

        // search result to list of possible solutions
        List<List<List<Integer>>> dfsList = new ArrayList<>();
        for (List<TreeSet<Integer>> search : searchResult) {
            for (TreeSet<Integer> key: search) {
                dfsList.add(reverseMap.get(key));
            }
            // do dfs
            max = Math.max(max, findMaxProfitDFS(dfsList, 0, new HashSet<>()));
//            printDFSList(dfsList);
            dfsList.clear();
        }

        return max;
    }

    static void printDFSList(List<List<List<Integer>>> dfsList) {
        System.out.println("Assumed divide count: " + dfsList.size());
        for (int index = 0; index < dfsList.size(); index++) {
            System.out.println("divide index: " + index);
            List<List<Integer>> maybe = dfsList.get(index);
            for (List<Integer> list: maybe) {
                System.out.println("team: " + list.get(0) + " profit: " + list.get(1));
            }
        }
    }

    // TODO still not correct
    static int findMaxProfitDFS(List<List<List<Integer>>> dfsList, int index, HashSet<Integer> visited) {
        // TODO solve this
        if (index == dfsList.size()) {
            return 0;
        }



        int profit = -1;
        List<List<Integer>> teamAndProfitList = dfsList.get(index);
        for (List<Integer> teamAndProfit : teamAndProfitList) {
            int currTeam = teamAndProfit.get(0);
            int currProfit = teamAndProfit.get(1);
            if (visited.contains(currTeam)) {
                continue;
            }

            visited.add(currTeam);

            // dfs and profit
            int dfsResult = findMaxProfitDFS(dfsList, index + 1, visited);
            if (dfsResult == -1) {
                continue;
            }
            profit = Math.max(profit, currProfit + dfsResult);

            visited.remove(currTeam);
        }
        return profit;
    }

    static void findValidDivideDFS(List<TreeSet<Integer>> layer, int setCount, int currIndex,
                                   HashSet<Integer> currElements, List<TreeSet<Integer>> currSet, List<List<TreeSet<Integer>>> result) {
        if (currSet.size() == setCount) {
            result.add(new ArrayList<>(currSet));
            return;
        }
//        System.out.println("currSet size: " + currSet.size());

        for (int i = currIndex; i < layer.size(); i++) {
            TreeSet<Integer> maybe = layer.get(i);
            for (int element : maybe) {
                if (currElements.contains(element)) {
                    continue;
                }
            }
            // add elements to currElements
            for (int element : maybe) {
                currElements.add(element);
            }
            // add current set to currset
            currSet.add(maybe);

            // dfs
            findValidDivideDFS(layer, setCount, i + 1, currElements, currSet, result);

            // remove current set from currset
            currSet.remove(currSet.size() - 1);
            // remove elements from currElements
            for (int element : maybe) {
                currElements.remove(element);
            }
        }
    }

    static HashMap<TreeSet<Integer>, List<List<Integer>>> buildReverseMap(List<HashMap<TreeSet<Integer>, Integer>> maxProfitAllGroups) {
        HashMap<TreeSet<Integer>, List<List<Integer>>> reverseMap = new HashMap<>();
        for (int groupIndex = 0; groupIndex < maxProfitAllGroups.size(); groupIndex++) {
            HashMap<TreeSet<Integer>, Integer> maxProfitPerGroup = maxProfitAllGroups.get(groupIndex);
            for (TreeSet<Integer> treeSet : maxProfitPerGroup.keySet()) {
                int profit = maxProfitPerGroup.get(treeSet);
                List<Integer> groupAndProfit = new ArrayList<>();
                groupAndProfit.add(groupIndex);
                groupAndProfit.add(profit);
                if (reverseMap.containsKey(treeSet)) {
                    reverseMap.get(treeSet).add(groupAndProfit);
                } else {
                    List<List<Integer>> val = new ArrayList<>();
                    val.add(groupAndProfit);
                    reverseMap.put(treeSet, val);
                }
            }
        }
        return reverseMap;
    }

    static void dfsMaxCollect(int[] studentCharm, List<List<Integer>> guestTable, List<Integer> visited, int[] kRemains,
                              int currentSum, HashMap<TreeSet<Integer>, Integer> maxProfitPerGroup) {
        if (visited.size() == guestTable.size()) {
            return;
        }

        for (int guestTableIndex = 0; guestTableIndex < guestTable.size(); guestTableIndex++) {

            if (visited.contains(guestTableIndex)) {
                continue;
            }
            List<Integer> guests = guestTable.get(guestTableIndex);
            int[] kRemainsCopy = copyArray(kRemains);


            if (canCollect(studentCharm, guests, kRemainsCopy)) {
                visited.add(guestTableIndex);

                // collect money
                int collected = collectMoney(studentCharm, guests, kRemainsCopy);

                int sum = currentSum + collected;

                // update map of sum
                TreeSet<Integer> hashKey = new TreeSet<>();
                hashKey.addAll(visited);
                if (maxProfitPerGroup.containsKey(sum)) {
                    maxProfitPerGroup.replace(hashKey, Math.max(sum, maxProfitPerGroup.get(hashKey)));
                } else {
                    maxProfitPerGroup.put(hashKey, sum);
                }

                dfsMaxCollect(studentCharm, guestTable, visited, kRemainsCopy, sum, maxProfitPerGroup);
                visited.remove(visited.size() - 1);
            }
        }
    }

    static int[] copyArray(int[] kRemains) {
        int[] result = new int[kRemains.length];
        for (int i = 0; i < kRemains.length; i++) {
            result[i] = kRemains[i];
        }
        return result;
    }

    // check if there's enough students to collect money
    static boolean canCollect(int[] students, List<Integer> guests, int[] kRemains) {
        int count = 0;
        for (int can : kRemains) {
            if (can > 0) {
                count += can;
            }
        }
        return count >= guests.size();
    }

    // assume students and guests are sorted
    // use canCollect to make sure it is possible to collect money
    static int collectMoney(int[] students, List<Integer> guests, int[] kRemains) {
        int sum = 0;
        int studentIndex = 0;
        int guestIndex = 0;
        while (guestIndex < guests.size()) {
            while (kRemains[studentIndex] < 1) {
                studentIndex++;
            }
            while (guestIndex < guests.size() && kRemains[studentIndex] > 0) {
                sum += students[studentIndex] * guests.get(guestIndex);
                guestIndex++;
                kRemains[studentIndex]--;
            }
            studentIndex++;
        }

        return sum;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tc = Integer.parseInt(scanner.nextLine().trim());

        for (int tcItr = 0; tcItr < tc; tcItr++) {
            String[] mn = scanner.nextLine().split(" ");

            int m = Integer.parseInt(mn[0].trim());
            int n = Integer.parseInt(mn[1].trim());
            int t = Integer.parseInt(mn[2].trim());

            int[][] charm = new int[m][n];

            for (int charmRowItr = 0; charmRowItr < m; charmRowItr++) {
                String[] charmRowItems = scanner.nextLine().split(" ");

                for (int charmColumnItr = 0; charmColumnItr < n; charmColumnItr++) {
                    int charmItem = Integer.parseInt(charmRowItems[charmColumnItr].trim());
                    charm[charmRowItr][charmColumnItr] = charmItem;
                }
            }

            for (int i = 0; i < charm.length; i++) {
                int[] charmRow = charm[i];
                List<Integer> charmList = new ArrayList<>();
                for (int c : charmRow) {
                    charmList.add(c);
                }
                Collections.sort(charmList, Collections.reverseOrder());
                for (int j = 0; j < charmRow.length; j++) {
                    charm[i][j] = charmList.get(j);
                }
            }

            List<List<Integer>> guestTable = new ArrayList<>();

            for (int tItr = 0; tItr < t; tItr++) {
                String line = scanner.nextLine().trim();
                String[] lineBroken = line.split(" ");
                int x = Integer.parseInt(lineBroken[0]);

                int[] generosities = new int[x];

                for (int generositiesItr = 1; generositiesItr < lineBroken.length; generositiesItr++) {
                    int generositiesItem = Integer.parseInt(lineBroken[generositiesItr].trim());
                    generosities[generositiesItr - 1] = generositiesItem;
                }

                guestTable(generosities, guestTable, tItr);
            }

            int k = Integer.parseInt(scanner.nextLine().trim());

            solve(charm, guestTable, k);
        }
    }
}
