package data_structure.linkedList;

/**
 * Created by Hiki on 2017/7/18.
 */
public class LinkedListItr<T> {

    ListNode<T> current;

    public LinkedListItr(ListNode<T> node) {
        this.current = node;
    }

    public boolean isPastEnd(){
        return current == null;
    }

    public T retrieve(){
        return isPastEnd() ? null : current.element;
    }

    public void advance(){
        if (!isPastEnd()){
            current = current.next;
        }
    }

}
