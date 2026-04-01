class MinStack {
    Node head;

    public MinStack() {
    }
    
    public void push(int val) {
        if(head == null){
            head=new Node(val,val);
        }
        else{
            head = new Node(val,Math.min(val,head.min));
        }
    }
    
    public void pop() {
        head=head.next;
    }
    
    public int top() {
        return head.data;
        
    }
    
    public int getMin() {
        return head.min;
    }
    public class Node{
        int data;
        int min;
        Node next;
        public Node(int val,int min){
            this.data = val;
            this.min=min;
            this.next=head;
        }
    }
}
