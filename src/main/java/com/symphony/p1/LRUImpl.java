package com.symphony.p1;

import lombok.ToString;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;

@ToString
class Pair {
    String key;
    int val;
    Pair(String key, int val){
        this.key = key;
        this.val = val;
    }
}

public class LRUImpl {
    private int limit = 5;
    Map<String, Integer> map = new HashMap<>();
    LinkedList<Pair> list = new LinkedList<>();

    public void put(String key, int val) {
        Pair pair = new Pair(key, val);
        if (map.size() == limit){
            map.remove(list.getLast().key);
            list.removeLast();
        }
        map.put(key, val);
        list.addFirst(pair);
    }

    public int get(String key) {
        int val = map.get(key);
        Pair pair = list.stream().filter(x -> x.key.equals(key) && x.val == val).findFirst().orElseThrow(NoSuchElementException::new);
        list.remove(pair);
        list.addFirst(pair);
        return val;
    }

    public static void main(String[] args) {
        LRUImpl lru = new LRUImpl();
        lru.put("1",1);
        lru.put("2", 2);
        lru.put("3", 3);
        lru.put("4", 4);
        lru.put("5", 5);

        lru.get("3");
        lru.get("1");
        lru.put("6", 6);
        lru.put("7", 7);
        lru.put("1", 8);

        System.out.println(lru.list);
        System.out.println(lru.map);

    }
}
