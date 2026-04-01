class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=edges.length;i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
            boolean[] visited = new boolean[edges.length+1];
            if(dfs(list,visited,edge[0],-1)){
                return new int[]{edge[0],edge[1]};
            }
        }
        return new int[]{};
    }

    public boolean dfs(List<List<Integer>> list,boolean[] visited,int node,int parent){
        visited[node]=true;
        for(int edge : list.get(node)){
            if(!visited[edge]){
                if(dfs(list,visited,edge,node)){
                    return true;
                }
            }
            else if(parent != edge){
                return true;
            }
        }
        return false;
    }
}
