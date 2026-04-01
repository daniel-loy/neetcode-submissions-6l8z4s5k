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
       ListNode count = head;
       ListNode original=head;
       for(int i=0;i<k;i++){
        if(count==null){
            return head;
        }
        count=count.next;
       }
       for(int i=0;i<k;i++){
            current=head.next;
            head.next=prev;
            prev=head;
            head=current;

       }
       original.next=reverseKGroup(current,k);
       return prev;
    }
}
