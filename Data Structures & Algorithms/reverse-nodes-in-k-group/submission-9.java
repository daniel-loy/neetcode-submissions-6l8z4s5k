class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        // Count total nodes
        int totalcount = 0;
        ListNode traverse = head;

        while (traverse != null) {
            totalcount++;
            traverse = traverse.next;
        }

        int totalgroupcount = totalcount / k;

        ListNode prevGroupTail = null;
        ListNode returnnode = head;

        for (int group = 0; group < totalgroupcount; group++) {

            // This will become the tail after reversal
            ListNode groupTail = head;

            ListNode prev = null;

            // Reverse k nodes
            for (int i = 0; i < k; i++) {
                ListNode nextnode = head.next;

                head.next = prev;
                prev = head;
                head = nextnode;
            }

            // prev = first node of reversed group
            // groupTail = last node of reversed group

            if (prevGroupTail != null) {
                prevGroupTail.next = prev;
            } else {
                // First group becomes the new head
                returnnode = prev;
            }

            // Tail of current group becomes previous group's tail
            prevGroupTail = groupTail;
        }

        // Connect remaining nodes
        prevGroupTail.next = head;

        return returnnode;
    }
}