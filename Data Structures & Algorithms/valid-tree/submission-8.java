class Solution {
    int[] status;
    public boolean validTree(int n, int[][] edges) {

        status = new int[n];
        int unique = 0;
        for(int i=0;i<n;i++){
            status[i]=  i;
        }
        
            for(int[] num : edges){
                if(findCycle(num[0],num[1])){
                    return false;
                }
            }
        
        for(int i=0;i<n;i++){
            if(status[i]==i){
                unique++;
            }

            if(unique >1){
                return false;
            }
        }

        return true;
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


    public boolean findCycle(int child,int parent){
        int parent1 = getParent(parent);
        int parent2 = getParent(child);
        if(parent1 == parent2){
            return true;
        }
        else{
            status[parent1] = parent2;
            return false;
        }

        // return false;
    }
}
