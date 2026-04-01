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
    public boolean hasCycle(ListNode head) {

        if(head == null){
            return false;
        }
        ListNode rabbit = head.next;
        ListNode tourtise = head;

        while(rabbit != null && rabbit.next !=null){
            if(rabbit==tourtise){
                return true;
            }
            rabbit = rabbit.next.next;
            tourtise = tourtise.next;
        }
        return false;
    }
}
