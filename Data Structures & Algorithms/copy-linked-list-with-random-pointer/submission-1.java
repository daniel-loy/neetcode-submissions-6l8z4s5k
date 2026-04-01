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
	if(head == null){
		return null;
	}
        HashMap<Node,Node> map = new HashMap<>();
	Node dummy = new Node(-1);
	Node newhead = dummy;
	Node currentnode = new Node(head.val);
	dummy.next = currentnode;
	newhead = currentnode;
    map.put(head, newhead);
	while(head!=null){
        if(head.next != null){
		if(map.containsKey(head.next)){
			newhead.next = map.get(head.next);
		}
		else{
			currentnode = new Node(head.next.val);
			newhead.next = currentnode;
			map.put(head.next,currentnode);
		}
        }
        if(head.random == null){
            head = head.next;
            newhead = newhead.next;
            continue;
        }
		if(map.containsKey(head.random)){
			newhead.random = map.get(head.random);
		}
		else{
			currentnode = new Node(head.random.val);
			newhead.random = currentnode;
			map.put(head.random,currentnode);
		}
		head = head.next;
        newhead = newhead.next;
	}
	return dummy.next;
    }
}
