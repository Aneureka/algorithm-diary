import data_helper.ListNode;

/**
 * Created by Hiki on 9/28/2017.
 */
public class No160_IntersectionOfTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		int lenA = 0, lenB = 0;
		ListNode ptrA = headA, ptrB = headB;

		while (ptrA != null){
			ptrA = ptrA.next;
			lenA++;
		}
		while (ptrB != null){
			ptrB = ptrB.next;
			lenB++;
		}

		// 缩短长的一条链
		if (lenA > lenB){
			while (lenA > lenB){
				headA = headA.next;
				lenA--;
			}
		}
		else if (lenB > lenA){
			while (lenB > lenA){
				headB = headB.next;
				lenB--;
			}
		}

		while (headA != null){
			if (headA == headB)
				return headA;
			headA = headA.next;
			headB = headB.next;
		}

		return null;
	}

}
