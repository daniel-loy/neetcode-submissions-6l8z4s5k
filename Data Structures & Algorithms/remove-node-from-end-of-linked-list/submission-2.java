class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
	
	ListNode traverse = head;
	while(traverse!=null){
		traverse=traverse.next;
		length++;
	}
	int count = length;

	if(count == n){
	    return head.next;
	}

        ListNode current = head.next;
        ListNode prev = head;
	count--;
        while(current != null){
            if(count == n){
                prev.next = current.next;
                return head;
            }
            current = current.next;
            prev = prev.next;
            count--;
        }

        return null;
    }
}