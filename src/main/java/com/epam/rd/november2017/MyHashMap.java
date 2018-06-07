package com.epam.rd.november2017;

import java.util.Iterator;

import com.epam.rd.november2017.MyMap;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private Entry<K, V>[] hashMap;
    private int size;
    private float threshold;

    public MyHashMap() {
        hashMap = new Entry[16];
        threshold = hashMap.length * 0.75f;
    }

    @Override
    public V get(K key) {
        for (Entry<K, V> entry : hashMap) {
            if (entry != null && entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        if (size + 1 >= threshold) {
            threshold *= 2;
            arrayIncreasingTwice();
        }
        if (get(key) == null) {
            size++;
        }
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % hashMap.length;
        hashMap[index] = new Entry<>(key, value);
    }

    void arrayIncreasingTwice() {
        Entry<K, V>[] oldHashTable = hashMap;
        hashMap = new Entry[oldHashTable.length * 2];
        size = 0;
        for (Entry<K, V> entry : oldHashTable) {
            if (entry != null) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new EntryIterator(hashMap);
    }

}
