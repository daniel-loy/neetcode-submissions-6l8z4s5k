/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();

		Node copyhead = new Node(-1);
		Node dummy = copyhead;

		while(head != null){
			if(map.containsKey(head)){
				copyhead.next = map.get(head);
				copyhead = copyhead.next;
			}
			else{
				Node newnode = new Node(head.val);
				copyhead.next = newnode;
				copyhead = copyhead.next;
				map.put(head,newnode);
			}

			if(head.random == null){
				copyhead.random = null;
			}
			else{
			if(map.containsKey(head.random)){
				copyhead.random = map.get(head.random);
			}
			else{
				Node newnode = new Node(head.random.val);
				copyhead.random = newnode;
				map.put(head.random,newnode);
			}			
			}
			head = head.next;
		}
		return dummy.next;
    }
}
