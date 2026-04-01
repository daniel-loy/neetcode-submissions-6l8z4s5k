/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Node newnode = new Node();
        HashMap<Node,Node> map = new HashMap<>();
        return dfs(node,newnode,map);
    }

    public Node dfs(Node givenode,Node newnode,HashMap<Node,Node> map){
           if(givenode == null){
                return newnode;
            }
            if(map.containsKey(givenode)){
                return map.get(givenode);
            }

            map.put(givenode,newnode);
            newnode.val = givenode.val;
            for(Node node : givenode.neighbors){
                newnode.neighbors.add(dfs(node,new Node(),map));
            }
            

            return newnode;
    }
}