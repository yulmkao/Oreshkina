package Hash;

import java.util.ArrayList;

public class HashTable {

    private static class Pair {
        private String key;
        private String value;

        Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<Pair>[] table;
    private int size;
    private int count;

    public HashTable(int size) {
        this.size = size;
        this.count = 0;
        table = new ArrayList[size];
    }

    public int getIndex(String key) {
        int hash = key.hashCode();
        return Math.abs(hash % size);
    }

    public void put(String key, String value) {
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new ArrayList<>();
        }
        for (Pair pair : table[index]) {
            if (pair.key.equals(key)) {
                pair.value = value;
            }
        }
        table[index].add(new Pair(key, value));
        count++;
        if (count >= size) {
            resize();
        }
    }

    public String get(String key) {
        int index = getIndex(key);
        if (table[index] != null) {
            for (Pair pair : table[index]) {
                if (pair.key.equals(key)) {
                    return pair.value;
                }
            }
        }
        return null;
    }

    public void remove(String key) {
        int index = getIndex(key);
        if (table[index] != null) {
            for (int i = 0; i < table[index].size(); i++) {
                if (table[index].get(i).key.equals(key)) {
                    table[index].remove(i);
                    count--;
                }
            }
        }
    }

    private void resize() {
        ArrayList<Pair>[] oldTable = table;
        size *= 2;
        count = 0;
        table = new ArrayList[size];
        for (ArrayList<Pair> bucket : oldTable) {
            if (bucket != null) {
                for (Pair pair : bucket) {
                    put(pair.key, pair.value);
                }
            }
        }
    }
    public static void main(String[] args) {
        HashTable table = new HashTable(2);
        table.put("one", "один");
        table.put("two", "два");
        table.put("three", "три");
        System.out.println(table.get("one"));
        System.out.println(table.get("two"));
        System.out.println(table.get("three"));
        table.remove("two");
        System.out.println(table.get("two"));
        System.out.println(table.getIndex("one"));
        table.put("four", "четыре");
        System.out.println(table.get("four"));
        System.out.println(table.size);
    }
}
