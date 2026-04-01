class Solution {
    int[] parent;
    public int countComponents(int n, int[][] edges) {
    int[] rank = new int[n];
	parent = new int[n];
	
	for(int i=0;i<n;i++){
	parent[i] = i;
	}
	
	for(int[] edge : edges){
		int parent1 = getParent(edge[0]);
		int parent2 = getParent(edge[1]);
        if(rank[parent1]==rank[parent2]){
            parent[parent2] = parent1;
            rank[parent1]++;        }
        else if(rank[parent1]>rank[parent2]){
            parent[parent2] = parent1;
        }
        else{
            parent[parent1] = parent2;
        }

	}
	HashSet<Integer> set = new HashSet<>();
	for(int i=0;i<n;i++){
    set.add(getParent(i));        
    System.out.println(parent[i]+" "+i);
	}

	return set.size();

    }

    public int getParent(int child){
	if(child == parent[child]){
	return child;
	}
	return getParent(parent[child]);
}
}
