package com.experiment;

import java.util.*;

public class CollectionsExplore {
    List<String> stringLinkedList;
    List<String> stringArrayList;

    Set<String> hashSet;
    Set<String> linkedHashSet;
    Set<String> treeSet;

    Map<Integer, String> hashMap;
    Map<Integer, String> treeMap;
    Map<Integer, String> weakHashMap;
    Map<Integer, String> linkedHashMap;
    Map<Integer, Object> identityHashMap;

    public CollectionsExplore() {
        stringLinkedList = new LinkedList<>();
        stringArrayList = new ArrayList<>();

        hashSet = new HashSet<>();
        linkedHashSet = new LinkedHashSet<>();
        treeSet = new TreeSet<>();

        hashMap = new HashMap<>();
        treeMap = new TreeMap<>();
        weakHashMap = new WeakHashMap<>();
        linkedHashMap = new LinkedHashMap<>();
        identityHashMap = new IdentityHashMap<>();
    }

    public void exploreCollections() {
        exploreLinkedList();
        exploreArrayList();
        exploreHashSet();
        exploreHashMap();
        exploreTreeMap();
        exploreLinkedHashMap();
    }

    private void exploreLinkedHashMap() {
        linkedHashMap.put(1, "h");
        linkedHashMap.put(1, "i");
        linkedHashMap.put(2, "j");
        linkedHashMap.put(3, null);
        linkedHashMap.put(-1, "k");
        printMap(linkedHashMap);
    }

    private void exploreTreeMap() {
            treeMap.put(1, "h");
            treeMap.put(1, "i");
            treeMap.put(2, "j");
            treeMap.put(3, null);
            treeMap.put(-1, "k");
            printMap(treeMap);

    }

    private void exploreHashMap() {
        hashMap.put(1, "h");
        hashMap.put(1, "i");
        hashMap.put(2, "j");
        hashMap.put(3, null);
        hashMap.put(-1, "k");
        printMap(hashMap);
    }
    private void printMap(Map<Integer,String > map) {
        if(map != null) {
            System.out.println("printing of map of type:" + map.getClass());
            map.forEach((x, value) -> {
                System.out.println(x + value);
            });

            for (Map.Entry<Integer, String> k : map.entrySet()) {
                System.out.println(k.getKey() + k.getValue());
            }

            Set<Integer> integers = map.keySet();
            integers.forEach(System.out::println);
            Collection<String> values = map.values();
            values.forEach(System.out::println);
        }
    }
    private void exploreHashSet() {
        hashSet.add("f");
        hashSet.add("f");
        hashSet.add("f");
        hashSet.add("g");

        hashSet.forEach(System.out::println);
        System.out.println("Size of Hash Set: " + hashSet.size());
    }
    private void exploreArrayList() {
        stringArrayList.add("c");
        stringArrayList.add("d");
        stringArrayList.add("e");
        System.out.println("string Array List with enhanced for loop");
        for(String s: stringArrayList) {
            System.out.println(s);
        }
        stringArrayList.forEach(System.out::println);
        ListIterator<String> iterator = stringArrayList.listIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next() + " at location: " + iterator.nextIndex());
            iterator.remove();
        }
    }
    private void exploreLinkedList() {
        stringLinkedList.add("a");
        stringLinkedList.add("b");

        System.out.println("string Linked List with enhanced for loop");
        for(String s: stringLinkedList) {
            System.out.println(s);
        }
        stringLinkedList.forEach(System.out::println);
        System.out.println("string Linked List with Iteration");
        ListIterator<String> iterator = stringLinkedList.listIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next() + " at location: " + iterator.nextIndex());
            iterator.remove();
        }
        String s = stringLinkedList.isEmpty() ? "List is empty" : "List is not empty";
        System.out.println(s);

    }

}
