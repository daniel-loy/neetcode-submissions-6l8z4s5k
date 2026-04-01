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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
        return head;
        }
       ListNode prev=null;
       ListNode current=null;
       ListNode orignal=head;
       for(int i=0;i<k;i++){
            if(head==null){
                return reverseKGroup(prev,i);
            }
            current=head.next;
            head.next=prev;
            prev=head;
            head=current;

       }
       orignal.next=reverseKGroup(head,k);
       return prev;
    }
}
