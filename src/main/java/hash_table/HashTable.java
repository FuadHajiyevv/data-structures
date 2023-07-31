package hash_table;

import linkedlists.singly.SinglyLinkedList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class HashTable<K, V> {
    private int size;
    private SinglyLinkedList<Entry<K, V>>[] table;

    private final int DEFAULT_CAPACITY = 16;

    private int capacity;

    private final float DEFAULT_LOAD_FACTOR =1f;

    private float loadFactor;

    public HashTable() {
        capacity = DEFAULT_CAPACITY;
        loadFactor = DEFAULT_LOAD_FACTOR;
        table = new SinglyLinkedList[DEFAULT_CAPACITY];
    }

    public HashTable(int initialCapacity) {
        if(initialCapacity < 0) throw new IllegalArgumentException();
        capacity = initialCapacity;
        loadFactor = DEFAULT_LOAD_FACTOR;
        table = new SinglyLinkedList[initialCapacity];
    }

    public HashTable(int initialCapacity,float loadFactor){
        if(initialCapacity < 0 || loadFactor < 0) throw  new IllegalArgumentException();
        capacity = initialCapacity;
        this.loadFactor = loadFactor;
        table = new SinglyLinkedList[initialCapacity];
    }

    public static class Entry<K, V> {
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key) && Objects.equals(value, entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString() {
            return "key:" + key + ",value:" + value;
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % (table.length - 1));
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new SinglyLinkedList<>();
            table[index].add(new Entry<>(key, value));
            size++;
            if(size == capacity * loadFactor){
                this.rehash();
            }
            return;
        }
        if (containsKey(key)) {
            get(key).value = value;
            return;
        }
        table[index].add(new Entry<>(key, value));
        size++;
        if(size == capacity * loadFactor){
            this.rehash();
        }
    }

    public void remove(K key){
        int index = hash(key);
        if(!containsKey(key)) throw new NoSuchElementException();
        table[index].delete(indexOf(key));
    }


    public boolean containsKey(K key) {
        int index = hash(key);
        for (int i = 0; i < table[index].size() ; i++) {
            if(table[index].get(i).key.equals(key)) return true;
        }
        return false;
    }

    private int indexOf(K key){
        int index = hash(key);
        return table[index].indexOf(get(key));
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public Entry<K, V> get(K key) {
        int index = hash(key);
        if(table[index] == null) throw new NoSuchElementException();
        for (int i = 0; i < table[index].size(); i++) {
            if (table[index].get(i).key.equals(key)) return table[index].get(i);
        }
        throw new NoSuchElementException();
    }



    private void rehash(){
        capacity = capacity * 2;
        HashTable<K,V> hashTable = new HashTable<>(capacity);
        for (K key : getSetKey()){
            hashTable.put(get(key).key,get(key).value);
        }
        this.table = hashTable.table;
    }

    public Set<K> getSetKey() {
        return Arrays.stream(table)
                .filter(Objects::nonNull)
                .flatMap((SinglyLinkedList<Entry<K, V>> eachLinkedList) -> StreamSupport.stream(eachLinkedList.spliterator(), false))
                .map(Entry::getKey)
                .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            sb.append(String.format("[%d] --> %s%n", i, table[i]));
        }
        return sb.toString();
    }
}

