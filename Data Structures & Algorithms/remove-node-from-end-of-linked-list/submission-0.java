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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev=null;
        ListNode current = head;
        ListNode ahead=head;
        int count=1;

        while(count<n){
            ahead=ahead.next;
            count++;
        }

        System.out.println(ahead.val);

        while(ahead.next!=null){
            prev=current;
            current=current.next;
            ahead=ahead.next;
        }
        if(prev==null){
            return head.next;
        }
        else{
        prev.next=current.next;
        }


        return head;
        
    }
}
