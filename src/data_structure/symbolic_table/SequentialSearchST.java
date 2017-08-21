package data_structure.symbolic_table;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Hiki on 2017/8/21.
 */
public class SequentialSearchST<Key, Value> {

    private Node first;

    public Value get(Key key){
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val;
        return null;
    }

    public void put(Key key, Value val){
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)){
                x.val = val;
                return;
            }
        // miss and update the first node
        first = new Node(key, val, first);
    }

    public int size(){
        int count = 0;
        for (Node x = first; x != null; x = x.next)
            count++;
        return count;
    }

    public void delete(Key key){
        if (isEmpty()) throw new NoSuchElementException("Empty!");

        if (key.equals(first.key)){
            first = first.next;
            return;
        }

        for (Node x = first; x.next != null; x = x.next){
            if (key.equals(x.next.key)){
                // delete from linked list
                x.next = x.next.next;
                return;
            }
        }

        throw new NoSuchElementException();

    }

    public boolean isEmpty(){
        return first == null;
    }

    public Iterable<Key> keys(){
        List<Key> keys = new ArrayList<>();
        for (Node x = first; x != null; x = x.next){
            keys.add(x.key);
        }
        return keys;
    }


    private class Node{
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SequentialSearchST<Integer, String> st = new SequentialSearchST<>();
//        st.put(1, "a");
//        st.put(2, "b");
//        st.put(3, "c");
        System.out.println(st.isEmpty());
        System.out.println(st.get(1));
        st.delete(2);
        System.out.println(st.keys());
    }
}
