class LRUCache {

    class ListNode{

        int key;
        int value;
        ListNode next;
        ListNode(){
            key = -1;
            value = -1;
            next = null;
        }
        ListNode(int k,int v){
            key = k;
            value =v; 
            next = null;
        }
    }
    ListNode dummy = new ListNode();
    ListNode lastNode = dummy;
    int totalcapacity = 0;
    int count = 0;
    HashMap<Integer,ListNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        totalcapacity = capacity;
    }
    
    public int get(int key) {
            if(map.containsKey(key)){
                ListNode traverse = map.get(key);
                if(traverse.next.next == null){
                    return traverse.next.value;
                }
                map.put(traverse.next.next.key,traverse);
                map.put(traverse.next.key,lastNode);
                lastNode.next = traverse.next;
                lastNode = lastNode.next;
                traverse.next = traverse.next.next;
                lastNode.next = null;
                return lastNode.value;
            }
            else{
                return -1;
            }

    }
    
    public void put(int key, int value) {

            if(map.containsKey(key)){
                ListNode traverse = map.get(key);
                if(traverse.next.next == null){
                      traverse.next.value = value;
                      return;
                }

                map.put(traverse.next.next.key,traverse);
                map.put(traverse.next.key,lastNode);

                lastNode.next = traverse.next;
                lastNode = lastNode.next;
                traverse.next = traverse.next.next;

                lastNode.value = value;
                lastNode.next = null;
                lastNode.value = value;
                return;
            }        

        if(map.size() == totalcapacity){
            map.remove(dummy.next.key);
            dummy.next = dummy.next.next;
            if (dummy.next != null) {
                map.put(dummy.next.key, dummy);
            } else {
                lastNode = dummy;
            }
        }

            ListNode newNode = new ListNode(key,value);
            map.put(key,lastNode);
            lastNode.next = newNode;
            lastNode = lastNode.next;
            count++;
    }
}
