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
        ListNode list = head;
        int n = 0;
        ListNode returnNode = head;
        ListNode prev = null;
        while(list!=null || n==k){
            if(n == k){
            ListNode dummy = head;
            head = head.next;
            n--;
            ListNode prevStartNode = dummy;
            while(n!=0){
                ListNode temp = head.next;
                head.next = dummy;
                dummy = head;
                head = temp;
                n--;
            }
            if(prev!=null){
            prev.next = dummy;
            }
            else{
                returnNode = dummy;
            }
            prev = prevStartNode;
            }
            else{
                list = list.next;
                n++;
            }
        }
        if(n>0){
            prev.next = head;
        }
        else{
            prev.next = null;
        }
        return returnNode;

    }
}
