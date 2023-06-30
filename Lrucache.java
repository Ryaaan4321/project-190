package project190;
import java.util.*;


public class Lrucache {
    public static class ListNode {
        ListNode prev, next;
        int key, value;

        ListNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    public static class LRUCache {
        ListNode head = new ListNode(0, 0);// intializing the doubly linked list head;
        ListNode tail = new ListNode(0, 0); // intializing the doubly linked list tail;
        int capacity;
        HashMap<Integer, ListNode> hashMap;

        public LRUCache(int _capacity) {
            capacity = _capacity;
            hashMap = new HashMap<>();
            head.next = tail; // Connect the head to the tail to create the linked list
            tail.prev = head; // Connect the prev to the head
        }

        public int get(int key) {
            if (hashMap.containsKey(key)) {
                ListNode node = hashMap.get(key);
                remove(node); // Move the accessed node to the front
                insert(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (hashMap.containsKey(key)) { // if in case wee already have the key value in hashmap then we need to remove it  and then only
                remove(hashMap.get(key)); // we can put the values into the hashmap so we removed the value from the hasshmap;
            }
            if (hashMap.size() == capacity) { // if the size is  equal to the capacity then then to insert the value we  first need to 
                remove(tail.prev); // remove the least recently used node from the cache
            }
            insert(new ListNode(key, value)); // and then wee can insert the new value into it..!
        }

        private void remove(ListNode node) { // once the vlue is removed we need to establish the connections again
            hashMap.remove(node.key);  // and for that
            node.prev.next = node.next; // connected the nodes previous element to the next element of the node
            node.next.prev = node.prev; // and connected the nodes next element to the previous element of the node
            // to establish a connection of doubly linked list againnnnn
        }

        private void insert(ListNode node) { //to insert the value in a doubly linked list we need to take care of both the factors next and prev;
            hashMap.put(node.key, node);// 
            node.next = head.next; // and for tht nodes next is equal to the heads next and
            node.prev = head; // nodes prev to the headdd
            head.next.prev = node; // head.next.prev = node tht means 
            head.next = node;
        }
    }



    //// all the test cases are approved in this code snipppet..!
import java.util.HashMap;

public class LRUCache {
    public static class ListNode {
        ListNode prev, next;
        int key, value;

        ListNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    ListNode head = new ListNode(0, 0);
    ListNode tail = new ListNode(0, 0);
    int capacity;
    HashMap<Integer, ListNode> hashMap;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        hashMap = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            ListNode node = hashMap.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            remove(hashMap.get(key));
        }
        if (hashMap.size() == capacity) {
            remove(tail.prev);
        }
        insert(new ListNode(key, value));
    }

    private void remove(ListNode node) {
        hashMap.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        if (tail.prev == node) {
            tail.prev = node.prev;
        }
    }

    private void insert(ListNode node) {
        hashMap.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3); // Create a cache with capacity 2

        // Perform cache operations
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(2, 3);
        System.out.println(cache.get(1)); // Output: 1
        cache.put(3, 3);
        System.out.println(cache.get(2)); // Output: -1 (not found)
        cache.put(4, 4);
        System.out.println(cache.get(1)); // Output: -1 (not found)
        System.out.println(cache.get(3)); // Output: 3
        System.out.println(cache.get(4)); // Output: 4
    }
}
