package simple_datastructure.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Hiki on 2017/7/18.
 * QueueByLinkedList implementation based on linked list
 */
public class StackByLinkedList<T> implements Iterable<T> {

    private Node<T> first; // top of the stack
    private int n; // size of the stack

    // helper inner class
    private static class Node<T>{
        private T t;
        private Node<T> next;
    }

    public StackByLinkedList() {
        first = null;
        n = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    // return the number of items in the stack
    public int size(){
        return n;
    }

    public void push(T t){
        Node<T> oldFirst = first;
        first = new Node<>();
        first.t = t;
        first.next = oldFirst;
    }

    public T pop(){
        if (isEmpty())
            throw new NoSuchElementException();
        T t = first.t;
        first = first.next;
        n--;
        return t;
    }

    public T peek(){
        if (isEmpty())
            throw new NoSuchElementException();
        return first.t;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : this){
            sb.append(t).append(" ");
        }
        return sb.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T item = current.t;
            current = current.next;
            return item;
        }
    }

}
