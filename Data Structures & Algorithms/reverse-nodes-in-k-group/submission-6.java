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
        ListNode[] node = new ListNode[2];
        node[0]=null;
        node[1]=head;
        ListNode newhead = null;
        while(node[1]!=null){
            ListNode traverse = node[1];
            for(int i=0;i<k;i++){
                if(traverse==null){
                    node[0].next = node[1];
                    return newhead;
                }
                traverse = traverse.next;
            }
        ListNode startnode = node[1];
        ListNode prev = null;
        for(int i=0;i<k;i++){
              ListNode temp = startnode.next;
              startnode.next = prev;
              prev = startnode;
              startnode = temp;
        }
        if(node[0]!=null){
        node[0].next = prev;
        }
        node[0] = node[1];
        node[1] = startnode;
        if(newhead == null){
            newhead = prev;
        }
        }
        return newhead;
    }
}
