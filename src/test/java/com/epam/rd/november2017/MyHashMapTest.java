package com.epam.rd.november2017;


import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class MyHashMapTest<K, V> {

    private MyHashMap<K, V> myHashMap = new MyHashMap<>();
    private V value;
    private K key;
    private MyMap.Entry<K, V> entry;
    private Iterator iterator = myHashMap.iterator();

    @Test
    public void testGetMethod() {
        key = (K) "key_2";
        value = (V) "value_2";
        myHashMap.put(key, value);
        assertEquals((V) value, myHashMap.get(key));
    }

    @Test
    public void testPutMethod() {
        myHashMap.put((K) "key_1", (V) "value_1");
        myHashMap.put((K) "key_3", (V) "value_3");
        assertEquals(2, myHashMap.size());
    }

    @Test
    public void testSizeMethod() {
        myHashMap.put((K) "key_1", (V) "value_1");
        assertEquals(1, myHashMap.size());
    }

    @Test
    public void testIteratorMethod() {
        myHashMap.put((K) "key_1", (V) "value_1");
        assertEquals(true, iterator.hasNext());
        assertEquals("Entry{key=key_1, value=value_1}", iterator.next().toString());
        myHashMap.iterator().remove();
        assertEquals(false, iterator.hasNext());
    }
}