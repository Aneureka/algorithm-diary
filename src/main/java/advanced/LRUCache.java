package advanced;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hiki on 2018-04-16
 * Implement with HashMap & LinkedList [double direction]
 */

public class LRUCache<K, V> {

    private static final int DEFAULT_SIZE = 5;

    private int size;

    private int currentSize;

    private Map<K, ListNode<K, V>> cacheReader;

    private ListNode<K, V> first;

    private ListNode<K, V> last;

    public LRUCache(int size) {
        this.size = size;
        cacheReader = new HashMap<>();
    }

    public LRUCache() {
        this(DEFAULT_SIZE);
    }

    public void put(K key, V value) {

        // if exists
        if (cacheReader.containsKey(key)) {
            ListNode<K, V> node = cacheReader.get(key);
            moveToFirst(node);
            node.value = value;
            cacheReader.put(key, node);
        }
        else {
            if (currentSize == size) {
                ListNode<K, V> last = removeLast();
                cacheReader.remove(last.key);
            }
            ListNode<K, V> node = new ListNode<>(key, value);
            ListNode<K, V> first = appendFirst(node);
            cacheReader.put(key, first);
        }

    }

    public V get(K key) {
        return cacheReader.get(key).value;
    }

    public void printStatus() {
        ListNode<K, V> ptr = first;
        while (ptr != null) {
            System.out.println(ptr.key + "->" + ptr.value);
            ptr = ptr.next;
        }
    }

    public int getCurrentSize() {
        return currentSize;
    }

    private ListNode<K, V> appendFirst(ListNode<K, V> node) {

        if (currentSize == 0) {
            first = node;
            last = first;
        }
        else {
            first.prev = node;
            node.next = first;
            node.prev = null;
            first = node;
        }

        currentSize++;
        return first;
    }

    private ListNode<K, V> removeLast() {
        ListNode<K, V> res = last;
        last = last.prev;
        last.next = null;
        currentSize--;
        return res;
    }

    private void moveToFirst(ListNode<K, V> node) {
        if (node.prev != null)
            node.prev.next = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
        currentSize--;
        appendFirst(node);
    }

    static class ListNode<K, V> {
        K key;
        V value;
        ListNode<K, V> prev;
        ListNode<K, V> next;
        ListNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "aaa");
        cache.put(2, "bbb");
        cache.put(3, "ccc");
        cache.put(1, "ddd");
        cache.printStatus();
        System.out.println(cache.getCurrentSize());
    }

}
