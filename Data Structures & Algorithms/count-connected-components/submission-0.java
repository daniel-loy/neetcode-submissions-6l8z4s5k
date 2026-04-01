class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int[] arr : edges){
            list.get(arr[0]).add(arr[1]);
            list.get(arr[1]).add(arr[0]);
        }
        boolean[] visited = new boolean[n];
        int result=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
            dfs(list,visited,i);
            result+=1;
            }
        }
        return result;
    }
    public void dfs(List<List<Integer>> list,boolean[] visited,int node){
        if(visited[node]){
            return;
        }
        visited[node]=true;
        for(int edge : list.get(node)){
            dfs(list,visited,edge);
        }
    }
}
