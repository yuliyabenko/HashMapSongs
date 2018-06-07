package com.epam.rd.november2017;

public interface MyMap<K, V> extends Iterable<MyMap.Entry<K, V>> {

    class Entry<K, V> {

        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    V get(K key);

    void put(K key, V value);

    int size();

}