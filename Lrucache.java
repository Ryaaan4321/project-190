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
        ListNode head = new ListNode(0, 0);
        ListNode tail = new ListNode(0, 0);
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
            if (hashMap.containsKey(key)) {
                remove(hashMap.get(key));
            }
            if (hashMap.size() == capacity) {
                remove(tail.prev); // Remove the least recently used node from the cache
            }
            insert(new ListNode(key, value));
        }

        private void remove(ListNode node) {
            hashMap.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
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
