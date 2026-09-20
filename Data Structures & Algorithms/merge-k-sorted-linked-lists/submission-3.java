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
            ListNode mergednode = new ListNode(Integer.MIN_VALUE);
            for(int i=0;i<lists.length;i++){
                ListNode left  = mergednode;
                ListNode right = lists[i];
                ListNode prev = new ListNode(-1);
                prev.next = left;
                while(left!=null && right!=null){
                    if(left.val>=right.val){
                        prev.next = right;
                        right = right.next;
                        prev = prev.next;
                        prev.next = left;
                    }
                    else{
                        left = left.next;
                        prev = prev.next;
                    }
                }

                if(right != null){
                    prev.next = right;
                }
                
            }

            return mergednode.next;
    }
}
