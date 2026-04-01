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
    public void reorderList(ListNode head) {
        ListNode harrie = head.next;
        ListNode tourtise = head;

        while(harrie != null && harrie.next!=null){
            harrie=harrie.next.next;
            tourtise=tourtise.next;
        }

        ListNode temp = tourtise.next;
        tourtise.next=null;
        tourtise=temp;

        ListNode prev = null;

        while(tourtise != null){
            temp=tourtise.next;
            tourtise.next=prev;
            prev=tourtise;
            tourtise=temp;

        }

        ListNode dummy=new ListNode(1);
        ListNode reorderList=dummy;
        
        while(prev!=null && head!=null){
            reorderList.next=head;
            head=head.next;
            reorderList.next.next=prev;
            reorderList=reorderList.next.next;
            prev=prev.next;

        }

        if(prev==null){
            reorderList.next=head;
        }

        if(head==null){
            reorderList.next=prev;
        }

        head=dummy.next;
    }
    }

