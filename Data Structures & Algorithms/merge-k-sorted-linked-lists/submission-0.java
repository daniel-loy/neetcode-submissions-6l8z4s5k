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
        ListNode dummy = new ListNode();
        ListNode merge=dummy;
        int min=10000;
        while(true){
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                if(min==10000){
                    min=i;
                }
            if(lists[i].val<lists[min].val){
                min=i;
            }
            }
        }
        if(min==10000){
            break; 
        }
        merge.next=lists[min];
        merge=merge.next;
        lists[min]=lists[min].next;
        merge.next=null;
        min=10000;
        }
        return dummy.next;
    }
}
