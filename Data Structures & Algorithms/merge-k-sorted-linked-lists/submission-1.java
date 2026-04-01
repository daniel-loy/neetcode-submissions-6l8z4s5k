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
                if (lists == null || lists.length == 0) return null;

        for(int i=1;i<lists.length;i++){
            ListNode list1 = lists[i-1];
            ListNode list2 = lists[i];
            ListNode prev = new ListNode(-1,list2);
            lists[i] = prev;
            
           while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                ListNode temp = list1;
                list1=list1.next;
                temp.next = list2;
                prev.next = temp;
                prev = temp;
            }
            else{
                prev = prev.next;
                list2=list2.next;
            }
           }
           if(list1 !=null){
            prev.next = list1;
           }
           lists[i]=lists[i].next;
        }

        return lists[lists.length-1];
    }
}
