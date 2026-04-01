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
    public void reorderList(ListNode head) {
        ListNode rabbit = head.next;
	ListNode tourtise = head;

	while(rabbit!=null && rabbit.next != null){

		rabbit = rabbit.next.next;
		tourtise = tourtise.next;

	}
	ListNode currentnode = null;
    System.out.println(tourtise.val);

	while(tourtise != null){
		ListNode temp = tourtise.next;
		tourtise.next = currentnode;
		currentnode = tourtise;
		tourtise = temp;
	}
        System.out.println(currentnode.val);

	ListNode reverseNode = head;
	ListNode prev = currentnode;

	while(reverseNode!=null && currentnode !=null){
        prev = currentnode;
		ListNode temp = reverseNode.next;
		reverseNode.next = currentnode;
		currentnode = currentnode.next;
		reverseNode.next.next = temp;
		reverseNode = temp;

	}

	// if(reverseNode == null){
	// 	prev.next = currentnode;
	// }

    }
}
