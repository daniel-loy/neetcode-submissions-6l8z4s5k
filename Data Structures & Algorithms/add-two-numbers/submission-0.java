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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode Dummy = new ListNode(1);
        ListNode SumNode = Dummy;

        while(l1!=null && l2!=null){
            ListNode newNode = new ListNode();
            int sum = l1.val+l2.val+carry;
            carry=sum/10;
            newNode.val=sum%10;
            SumNode.next=newNode;
            SumNode=SumNode.next;
            l1=l1.next;
            l2=l2.next;
        }

        if(l1==null){
            while(l2!=null){
            ListNode newNode = new ListNode();
            int sum = l2.val+carry;
            carry=sum/10;
            newNode.val=sum%10;
            SumNode.next=newNode;
            SumNode=SumNode.next;
            l2=l2.next;
            }
        }

        if(l2==null){
            while(l1!=null){
            ListNode newNode = new ListNode();
            int sum = l1.val+carry;
            carry=sum/10;
            newNode.val=sum%10;
            SumNode.next=newNode;
            SumNode=SumNode.next;
            l1=l1.next;   
        }

        if(carry!=0){
            ListNode newNode = new ListNode();
             newNode.val=carry;
            SumNode.next=newNode;
            SumNode=SumNode.next;
        }

    }

            return Dummy.next;

}

}
