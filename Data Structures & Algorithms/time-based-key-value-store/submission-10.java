class TimeMap {

    class Node{
        int key=0;
        String value="";
        Node next=null;
        Node(int index,String data){
            key = index;
            value=data;
        }
    }

    HashMap<String,Node> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            Node head=map.get(key);
            Node newnode = new Node(timestamp,value);
            while(head.next!=null){
                head = head.next;
            }
            head.next=newnode;   
        }
        else{
            Node newNode = new Node(timestamp,value);
            map.put(key,newNode);
        }
    }
    
    public String get(String key, int timestamp) {
            Node head=map.get(key);
            String max="";
            while(head!=null){
                if(head.key<=timestamp){
                    max=head.value;
                }
                head=head.next;
            }
            return max;
    }
}
