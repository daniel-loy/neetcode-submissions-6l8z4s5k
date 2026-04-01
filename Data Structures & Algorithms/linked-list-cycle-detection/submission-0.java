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
        ListNode harrie = head.next;
        ListNode tourtise = head;

        while(harrie != null && harrie.next!=null){
            if(harrie == tourtise){
                return true;
            }
            harrie=harrie.next.next;
            tourtise=tourtise.next;
        }
        return false;
    }
}
