import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Aneureka
 * @createdAt 2020-03-09 16:32
 * @description
 **/
public class LRUCache<K, V> implements Iterable<K> {

    private Node head;
    private Node tail;
    private HashMap<K, Node> map;
    private int maxSize;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
        this.map = new HashMap<>((int) Math.ceil(maxSize / 0.75));
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node node = map.get(key);
        unlink(node);
        appendHead(node);
        return node.v;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            unlink(map.get(key));
        }
        Node node = new Node(key, value);
        appendHead(node);
        map.put(key, node);
        if (map.size() > maxSize) {
            Node toRemoveNode = removeTail();
            if (toRemoveNode != null) {
                map.remove(toRemoveNode.k);
            }
        }
    }

    private void unlink(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
    }

    private void appendHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private Node removeTail() {
        Node toRemoveNode = tail.prev;
        if (toRemoveNode == head) {
            return null;
        }
        toRemoveNode.prev.next = tail;
        tail.prev = toRemoveNode.prev;
        toRemoveNode.prev = null;
        toRemoveNode.next = null;
        return null;
    }


    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {

            private Node cur = head.next;

            @Override
            public boolean hasNext() {
                return cur != tail;
            }

            @Override
            public K next() {
                Node node = cur;
                cur = cur.next;
                return node.k;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (K k : this) {
            sb.append(k).append(" ");
        }
        return sb.toString();
    }

    private class Node {
        Node prev;
        Node next;
        K k;
        V v;
        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(5);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(lruCache);
        lruCache.put(3, 2);
        System.out.println(lruCache);
        lruCache.put(1, 2);
        System.out.println(lruCache);
        lruCache.get(4);
        System.out.println(lruCache);
    }
}
