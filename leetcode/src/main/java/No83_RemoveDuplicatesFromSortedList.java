import data_helper.ListNode;

/**
 * Created by Hiki on 9/18/2017.
 */
public class No83_RemoveDuplicatesFromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;

		ListNode res = head;
		while (head.next != null){
			if (head.next.val == head.val)
				head.next = head.next.next;
			else
				head = head.next;
		}

		return res;

	}




}
