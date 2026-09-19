class LRUCache {
    int capacity;
    Node head = new Node(-1,0);
    Node tail = new Node(-1,0);
    HashMap<Integer,Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
           Node currnode = map.get(key);
            Node prevnode = currnode.prev;
            Node nextnode = currnode.next;

            prevnode.next = nextnode;
            nextnode.prev = prevnode;

            tail.prev.next = currnode;
            currnode.prev = tail.prev;

            currnode.next = tail;

            tail.prev = currnode;

            return currnode.val;
        }
        else{
            return -1;
        }
    }

    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node currnode = map.get(key);
            currnode.val = value;
            Node prevnode = currnode.prev;
            Node nextnode = currnode.next;

            prevnode.next = nextnode;
            nextnode.prev = prevnode;

            tail.prev.next = currnode;
            currnode.prev = tail.prev;

            currnode.next = tail;

            tail.prev = currnode;

        }
        else{
         if(capacity == map.size()){
            int currentkey = head.next.key;
            Node nextnode = head.next.next;
            head.next = nextnode;
            nextnode.prev = head;

            map.remove(currentkey);

        } 
        Node currnode = new Node(key,value);
            tail.prev.next = currnode;
            currnode.prev = tail.prev;

            currnode.next = tail;

            tail.prev = currnode;


            map.put(key,currnode);
        }
    }

    public class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key,int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

}
