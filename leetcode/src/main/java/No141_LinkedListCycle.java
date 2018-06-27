import data_helper.ListNode;

/**
 * Created by Hiki on 9/28/2017.
 */
public class No141_LinkedListCycle {

	public boolean hasCycle(ListNode head) {

		if (head.next == null || head.next.next == null)
			return false;

		ListNode slow = head.next;
		ListNode fast = head.next.next;

		while(slow != fast){
			try {
				slow = slow.next;
				fast = fast.next.next;
			}
			catch (NullPointerException e){
				return false;
			}

		}

		return true;
	}

}
