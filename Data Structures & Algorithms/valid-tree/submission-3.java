class Solution {
    public boolean validTree(int n, int[][] edges) {
     
        if (edges.length != n-1){
            return false;
        }
        
        List<List<Integer>> adjancencyList = new ArrayList();
        for(int i=0; i<n; i++){
            adjancencyList.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            adjancencyList.get(edge[0]).add(edge[1]);
            adjancencyList.get(edge[1]).add(edge[0]);
        }
        
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];        
        
        stack.push(0);
        
        while(!stack.isEmpty()){
            int node=stack.pop();
                if(visited[node]){
                    continue;
                }
                visited[node]=true;
            for(int neighbour:adjancencyList.get(node)){
                stack.push(neighbour);
            }
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
   
        
        
     }
}