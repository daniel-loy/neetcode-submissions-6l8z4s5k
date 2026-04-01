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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp=null;
        ListNode prev = null;
        ListNode firstNode=list1;
        if(list1==null){
            
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.val>list2.val){
           return mergeTwoLists(list2, list1);
        }
        while(list1!=null && list2!=null)
        if(list1.val>list2.val){
                prev.next=list2;
                temp=list2;
                list2=list2.next;
                temp.next=list1;
                prev=temp;
        }
        else{
            prev=list1;
            list1=list1.next;
        }

        if(list1 == null){
            prev.next=list2;
        }
        return firstNode;
    }
}