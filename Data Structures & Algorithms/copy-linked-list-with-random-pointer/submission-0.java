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
        Node dummy = new Node(1);
        Node duplicate = dummy;
        Node randomval=head;
        HashMap<Node,Node> map = new HashMap<>();
        map.put(null,null);
        while(head != null){

            if(!map.containsKey(head)){
            Node newNode = new Node(head.val);
            map.put(head,newNode);
            duplicate.next=newNode;
            }
            else{
                duplicate.next=map.get(head);
            }

            duplicate=duplicate.next;

            randomval=head.random;

            if(!map.containsKey(randomval)){
            Node newRandomNode = new Node(randomval.val);
            map.put(randomval,newRandomNode);
            duplicate.random=newRandomNode;
            }
            else{
                duplicate.random=map.get(randomval);
            }    

            head=head.next;
        }

        return dummy.next;
    }
}
