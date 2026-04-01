class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
	int[] rank = new int[edges.length+1];
        parent = new int[edges.length+1];
	for(int i=0;i<=edges.length;i++){
		parent[i]=i;

	}
	for(int[] edge : edges){
		int parent1 = dfs(edge[0]);
		int parent2 = dfs(edge[1]);
		if(parent1 == parent2){
			return edge;
		}
		if(rank[parent1] == rank[parent2]){
			parent[parent2] = parent1;
			rank[parent1]++;
		}
		if(rank[parent1]>rank[parent2]){
			parent[parent2] = parent1;

		}
		else{
			parent[parent1] = parent2;
		}
	}
	return new int[]{0};
	
    }

    public int dfs(int child){
	if(child == parent[child]){
	return child;
	}
	return dfs(parent[child]);
   }
}