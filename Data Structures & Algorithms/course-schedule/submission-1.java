class Solution {
    public HashMap<Integer,Node> hash = new HashMap<>();
    class Node{
        boolean isEmpty = true;
        public HashMap<Integer,Node> dependent;
        Node(){
            dependent = new HashMap<>();
        }
        
        public void Addlist(int val,Node node){
            isEmpty=false;
            dependent.put(val,node);
        }
        
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node node;
        for(int i=0;i<numCourses;i++){
            hash.put(i,new Node());
        }
        for(int i=0;i<prerequisites.length;i++){
                node = hash.get(prerequisites[i][0]);
                node.Addlist(prerequisites[i][1],hash.get(prerequisites[i][1]));
        }
        boolean[] visited = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!dfs(i,visited)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int currentnode,boolean[] visited){
        if(hash.get(currentnode).isEmpty){
            return true;
        }

        if(visited[currentnode]==true){
            return false;
        }

        visited[currentnode]=true;

        for(int key : hash.get(currentnode).dependent.keySet()){
            boolean isvalid = dfs(key,visited);

            if(isvalid==false){
                return false;
            }
        }
        visited[currentnode]=false;
        return true;
    }
}