class Solution {

    public class Node{
        public List<Node> neighbor = new ArrayList<>();
        public int val;
        public Node(int value){
            val = value;
        }

        public void addneighbor(Node node){
            neighbor.add(node);
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,Node> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new Node(i));
        }
        for(int[] course : prerequisites){
            int course1 = course[0];
            int course2 = course[1];

            map.get(course2).addneighbor(map.get(course1));
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

            for(Node key : map.values()){
                    if(!dfs(visited,key,recStack)){
                        return false;
                    
                }
            }
        return true;
    }

    public boolean dfs(boolean[] visited,Node node,boolean[] recStack){

            if(recStack[node.val]){
                return false;
            }
            if(visited[node.val]){
                return true;
            }

            recStack[node.val] = true;
        visited[node.val] = true;
        for(Node neighbornode : node.neighbor){
            if(!dfs(visited,neighbornode,recStack)){
                return false;
            }
        }
            recStack[node.val] = false;

        return true;
    }
}
