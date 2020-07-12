package easy;

import java.util.LinkedList;
import java.util.List;

public class MyHashMap {
    /**
     * Initialize your data structure here.
     */
    private List<LinkedList<Element>> hashMap;
    final int size = 1000;

    public MyHashMap() {
        hashMap = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            hashMap.add(new LinkedList<>());
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        LinkedList<Element> linkedList = hashMap.get(hash(key));
        for (Element e : linkedList) {
            if (e.getKey() == key) {
                e.setValue(value);
                e.setDeleted(false);
                return;
            }
        }
        linkedList.add(new Element(key, value));
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        LinkedList<Element> linkedList = hashMap.get(hash(key));
        for (Element e : linkedList) {
            if (e.getKey() == key) {
                if (e.isDeleted()) {
                    return -1;
                }
                return e.getValue();
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        LinkedList<Element> linkedList = hashMap.get(hash(key));
        for (Element e : linkedList) {
            if (e.getKey() == key) {
                e.setDeleted(true);
                return;
            }
        }
    }

    private int hash(int key) {
        return key % size;
    }

    class Element {
        private int key;
        private int value;
        private boolean isDeleted;

        public Element(int k, int v) {
            key = k;
            value = v;
            isDeleted = false;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public boolean isDeleted() {
            return isDeleted;
        }

        public void setDeleted(boolean deleted) {
            isDeleted = deleted;
        }
    }
}
