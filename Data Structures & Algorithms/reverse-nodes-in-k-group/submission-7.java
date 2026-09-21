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
        ListNode traverse = head;
        int totalcount = 0;
        int currentcount = 0;

        while(traverse != null){
            totalcount++;
            traverse = traverse.next;
        }
        ListNode prefirstnode = null;
        ListNode lastgroupfirstnode = null;

        int totalgroupcount = totalcount/k;
        totalcount = 0;
        ListNode prev = null;
        ListNode returnnode = new ListNode(-1);
      
        while(totalcount!=totalgroupcount){
            if(currentcount == 0){
                prefirstnode = head;
            }
            ListNode nextnode = head.next;
            head.next = prev;
            prev = head;
            head = nextnode;
            currentcount++;
            if(currentcount%k == 0){
                if(lastgroupfirstnode == null){
                    returnnode = prev;
                }
                else{
                    lastgroupfirstnode.next = prev;
                }
                lastgroupfirstnode = prefirstnode;
                prefirstnode = head;
                totalcount++;
                if(totalcount == 1){
                }
                prev = null;
            }

        }
            lastgroupfirstnode.next = prefirstnode;
            return returnnode;
    }
}
