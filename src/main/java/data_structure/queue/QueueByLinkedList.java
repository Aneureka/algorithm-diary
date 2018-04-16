package data_structure.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Hiki on 2017/7/18.
 * QueueByLinkedList implementation based on linked list
 */
public class QueueByLinkedList<T> implements Iterable<T> {

    private Node<T> head, tail; // head and tail of the queue
    private int n; // size of the queue

    // helper inner class
    private static class Node<T>{
        private T t;
        private Node<T> next;
    }

    public QueueByLinkedList() {
        head = tail = null;
        n = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    // return the number of items in the queue
    public int size(){
        return n;
    }

    public void enqueue(T t){
        Node<T> oldTail = tail;
        tail = new Node<T>();
        tail.t = t;
        tail.next = null;
        if (isEmpty())
            head = tail;
        else
            oldTail.next = tail;
        n++;
    }

    public T dequeue(){
        if (isEmpty())
            throw new NoSuchElementException();
        T t = head.t;
        head = head.next;
        n--;
        if (isEmpty())
            tail = null;
        return t;
    }

    public T peek(){
        if (isEmpty())
            throw new NoSuchElementException();
        return head.t;
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
        return new ListIterator<T>(head);
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

    public static void main(String[] args) {
        QueueByLinkedList<String> queue = new QueueByLinkedList<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}
