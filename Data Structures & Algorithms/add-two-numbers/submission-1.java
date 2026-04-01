/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode dummy = new ListNode(-1);
       ListNode current = dummy;

      int carry = 0;

	while(l1!=null && l2!=null){
		int num = l1.val+l2.val+carry;

		ListNode newnode = new ListNode(num%10);

		current.next = newnode;
		current = current.next;
		carry = num/10;
        l1 = l1.next;
        l2 = l2.next;
	}

	while(l1!=null){
		int num = l1.val+carry;
		ListNode newnode = new ListNode(num%10);
		current.next = newnode;
		current = current.next;
		carry = num/10;
        l1 = l1.next;

	}
	while(l2!=null){
		int num = l2.val+carry;
		ListNode newnode = new ListNode(num%10);
		current.next = newnode;
		current = current.next;
		carry = num/10;
        l2 = l2.next;
	}

    if(carry != 0){
        ListNode newnode = new ListNode(carry);
		current.next = newnode;
		current = current.next;
    }

	return dummy.next;
    }
}
