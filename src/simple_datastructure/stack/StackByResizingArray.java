package simple_datastructure.stack;

import java.util.NoSuchElementException;

/**
 * Created by Hiki on 2017/7/19.
 * QueueByLinkedList implementation based on resizing array
 */
public class StackByResizingArray<T> {

    private T[] stack;
    private int n; // size of the stack

    public StackByResizingArray() {
        this.stack = (T[]) new Object[20];
        this.n = 0;
    }

    public void push(T t){
        if (n >= stack.length)
            resize(stack.length*2);
        stack[n++] = t;
    }

    public T pop(){
        if (n < stack.length/4)
            resize(stack.length/2);
        if(isEmpty())
            throw new NoSuchElementException();
        return stack[--n];
    }

    public T peek(){
        if(isEmpty())
            throw new NoSuchElementException();
        return stack[n-1];
    }

    private boolean isEmpty(){
        return n == 0;
    }

    private void resize(int sz){
        T[] copy = (T[]) new Object[sz];
        for (int i = 0; i < n; i++)
            copy[i] = stack[i];
        stack = copy;
    }


    public static void main(String[] args) {
        StackByResizingArray<String> st = new StackByResizingArray<>();
        st.push("a");
        st.push("b");
        st.push("c");
        st.push("d");
        st.push("e");
        System.out.println(st.pop());
        st.push("e");
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        st.push("a");
        System.out.println(st.pop());
    }
}
