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

	while(tourtise != null){
		ListNode temp = tourtise.next;
		tourtise.next = currentnode;
		currentnode = tourtise;
		tourtise = temp;
	}

	ListNode reverseNode = head;

	while(reverseNode != currentnode && reverseNode!=null && currentnode !=null){
                    System.out.println(reverseNode.val);

		ListNode temp = reverseNode.next;
		reverseNode.next = currentnode;
		currentnode = currentnode.next;
		reverseNode.next.next = temp;
		reverseNode = temp;



	}

    }
}
