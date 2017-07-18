package simple_datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Hiki on 2017/7/18.
 */
public class LinkedList<T> implements Iterable<T>{

    Node<T> head;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(T t){
        head = new Node<T>(t, head);
    }

    public T getFirst(){
        if (head == null)
            throw new NoSuchElementException();
        return head.data;
    }

    public T removeFirst(){
        T tmp = getFirst();
        head = head.next;
        return tmp;
    }




    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }


    // 声明节点
    private class Node<T> {
        T data;
        Node<T> next;

        public Node() {}

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

}
