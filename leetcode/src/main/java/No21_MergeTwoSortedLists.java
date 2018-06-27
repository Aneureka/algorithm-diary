import data_helper.ListNode;

/**
 * Created by Hiki on 2017/9/13.
 */
public class No21_MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode l3;
		if (l1.val <= l2.val){
			l3 = new ListNode(l1.val);
			l1 = l1.next;
		}
		else{
			l3 = new ListNode(l2.val);
			l2 = l2.next;
		}

		ListNode tmp = l3;

		while (true){
			if (l1 == null){
				tmp.next = l2;
				break;
			}
			if (l2 == null){
				tmp.next = l1;
				break;
			}
			if (l1.val <= l2.val){
				tmp.next = new ListNode(l1.val);
				l1 = l1.next;
			}
			else{
				tmp.next = new ListNode(l2.val);
				l2 = l2.next;
			}

			tmp = tmp.next;

		}


		return l3;

	}

}
