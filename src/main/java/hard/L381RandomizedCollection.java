package hard;

import java.util.*;

public class L381RandomizedCollection {
    HashMap<Integer, TreeSet<Integer>> map;
    ArrayList<Integer> arrayList;
    Random rand;

    /** Initialize your data structure here. */
    public L381RandomizedCollection() {
        map = new HashMap<>();
        arrayList = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        arrayList.add(val);
        if (map.containsKey(val)){
            map.get(val).add(arrayList.size() - 1);
            return false;
        }

        TreeSet<Integer> temp = new TreeSet<>();
        temp.add(arrayList.size() - 1);
        map.put(val, temp);
        return true;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val).last();
        map.get(val).remove(index);
        int last = arrayList.size() - 1;
        if (index < last){
            int tailVal = arrayList.get(last);
            arrayList.set(index, tailVal);
            map.get(tailVal).remove(last);
            map.get(tailVal).add(index);
        }
        if (map.get(val).size() == 0) {
            map.remove(val);
        }
        arrayList.remove(arrayList.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return arrayList.get(rand.nextInt(arrayList.size()));
    }
}
