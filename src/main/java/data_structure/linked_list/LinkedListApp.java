package data_structure.linked_list;

/**
 * Created by Hiki on 2017/7/18.
 */
public class LinkedListApp {

    private static void printList(LinkedList<Integer> list){

        if (list.isEmpty()){
            System.out.println("Empty list.");
        }
        else{
            for (LinkedListItr<Integer> itr = list.first(); !itr.isPastEnd(); itr.advance()){
                System.out.print(itr.retrieve() + " ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        LinkedListItr<Integer> itr = list.zeroth();

        for (int i = 0; i < 10; i++){
            list.insert(i, itr);
            printList(list);
            itr.advance();
        }

        for (int i = 0; i < 10; i+=2){
            list.remove(i);
        }

        for (int i = 0; i < 10; i++){
            if ((i%2==0) != (list.find(i).isPastEnd()))
                System.out.println("Find failed.");
        }

        System.out.println("Finished all delete operations.");
        printList(list);
    }

}
