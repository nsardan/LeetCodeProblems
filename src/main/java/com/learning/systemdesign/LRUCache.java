package com.learning.systemdesign;

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, Entry> map;
    int size;
    Entry start, end;

    class Entry{
        Entry prev;
        Entry next;
        int key;
        int value;
    }
    //["LRUCache","put","get"]
    //[[1],[2,1],[2]]

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.size = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            removeNode(entry);
            addAtTop(entry);
            return entry.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Entry entry = map.get(key);

            removeNode(entry);
            entry.value = value;
            addAtTop(entry);
        }else{
            //new key and value
            Entry entry = new Entry();
            entry.key = key;
            entry.value = value;
            entry.prev = null;
            entry.next = null;
            if(map.size() >= size){
                //remove
                map.remove(end.key);
                removeNode(end);
            }
            addAtTop(entry);
            map.put(key, entry);


        }

    }

    public void addAtTop(Entry node){
        node.next = start;
        node.prev = null;
        if(start != null){
            start.prev = node;
        }
        this.start = node;
        if(end == null) this.end = start;

    }

    public void removeNode(Entry node){
        if(node.next != null){
            node.next.prev = node.prev;
        }else{
            //it is end
            if(node.prev != null) node.prev.next = null;
            this.end = node.prev;
        }

        if(node.prev != null){
            node.prev.next = node.next;
        }else{
            //it is start
            if(node.next != null) node.next.prev = null;
            this.start = node.next;
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(2,1);
        int ans = cache.get(2);
        System.out.println(ans);

    }
}
