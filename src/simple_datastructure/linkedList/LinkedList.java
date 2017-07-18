package simple_datastructure.linkedList;

/**
 * Created by Hiki on 2017/7/18.
 */
public class LinkedList<T> {

    private ListNode<T> head;

    public LinkedList() {
        head = new ListNode<T>(null);
    }

    public boolean isEmpty(){
        return head.next == null;
    }

    public void clean(){
        head.next = null;
    }

    public LinkedListItr<T> zeroth(){
        return new LinkedListItr<>(head);
    }

    public LinkedListItr<T> first(){
        return new LinkedListItr<>(head.next);
    }

    public void insert(T t, LinkedListItr<T> p){
        if (p != null && p.current != null){
            p.current.next = new ListNode<T>(t, p.current.next);
        }
    }

    public LinkedListItr<T> find(T t){
        ListNode<T> itr = head.next;

        while (itr != null && !itr.element.equals(t)){
            itr = itr.next;
        }

        return new LinkedListItr<>(itr);
    }

    public LinkedListItr<T> findPrevious(T t){
        ListNode<T> itr = head.next;

        while (itr.next != null && !itr.next.element.equals(t)){
            itr = itr.next;
        }

        return new LinkedListItr<>(itr);
    }

    public void remove(T t){
        LinkedListItr<T> p = findPrevious(t);

        if (p.current.next != null){
            p.current.next = p.current.next.next;
        }
    }


}
