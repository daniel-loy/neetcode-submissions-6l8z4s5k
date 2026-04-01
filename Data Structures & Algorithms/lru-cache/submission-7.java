class LRUCache {

    class ListNode {
        int key;
        int value;
        ListNode next;

        ListNode(int k, int v) {
            key = k;
            value = v;
        }
    }

    ListNode dummy = new ListNode(-1, -1);
    ListNode lastNode = dummy;
    int capacity;
    HashMap<Integer, ListNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        ListNode prev = map.get(key);
        ListNode node = prev.next;

        // If already most recently used
        if (node == lastNode) {
            return node.value;
        }

        // Detach node
        prev.next = node.next;
        map.put(node.next.key, prev);

        // Move to end
        lastNode.next = node;
        map.put(node.key, lastNode);
        lastNode = node;
        lastNode.next = null;

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode prev = map.get(key);
            ListNode node = prev.next;
            node.value = value;

            // Move to end (reuse get logic)
            get(key);
            return;
        }

        // Evict LRU
        if (map.size() == capacity) {
            ListNode lru = dummy.next;
            map.remove(lru.key);
            dummy.next = lru.next;
            if (dummy.next != null) {
                map.put(dummy.next.key, dummy);
            } else {
                lastNode = dummy;
            }
        }

        // Insert new node
        ListNode node = new ListNode(key, value);
        lastNode.next = node;
        map.put(key, lastNode);
        lastNode = node;
    }
}
