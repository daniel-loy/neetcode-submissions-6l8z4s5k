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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 1){
            return lists[0];
        }

        if(lists.length == 0){
            return null;
        }

        ListNode dummy = new ListNode();
        for(int i=1;i<lists.length;i++){
            ListNode mergenode = dummy;
            ListNode previous = lists[i-1];
            ListNode current = lists[i];
            while(previous != null && current != null){
                if(previous.val>current.val){
                    mergenode.next = current;
                    mergenode = mergenode.next;
                    current = current.next;
                }
                else{
                    mergenode.next = previous;
                    mergenode = mergenode.next;
                    previous = previous.next; 
                }
            }
            if(previous != null){
                mergenode.next = previous;
            }
            if(current!=null){
                mergenode.next = current;
            }

            lists[i]=dummy.next;
        }

        return dummy.next;
    }
}
