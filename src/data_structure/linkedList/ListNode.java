package data_structure.linkedList;

/**
 * Created by Hiki on 2017/7/18.
 */
public class ListNode<T> {

    T element;
    ListNode<T> next;

    public ListNode(T element) {
        this(element, null);
    }

    public ListNode(T element, ListNode<T> next) {
        this.element = element;
        this.next = next;
    }
}
