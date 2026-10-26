class Solution {
    int[] status;
    public int countComponents(int n, int[][] edges) {

        status = new int[n];
        int unique = 0;
        for(int i=0;i<n;i++){
            status[i]=  i;
        }
        
            for(int[] num : edges){
                findCycle(num[0],num[1]);    
            }
        
        for(int i=0;i<n;i++){
            if(status[i]==i){
                unique++;
            }
        }

        return unique;
    }

    public int getParent(int parent){
        if(status[parent] == parent){
            return parent;
        }
        else
        {
            int par = getParent(status[parent]);
            status[parent] = par;
            return par;
        }
   
    }


    public void findCycle(int parent,int child){
        int parent1 = getParent(parent);
        int parent2 = getParent(child);

        status[parent1] = parent2;
    }
}
