class Solution {
    int[] status;
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

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
        
        // for(int i=0;i<n;i++){
        //     System.out.println(status[i]);
        //     if(status[i]==i){
        //         unique++;
        //     }

        //     if(unique >1){
        //         return false;
        //     }
        // }

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


    public boolean findCycle(int edge1,int edge2){
        int parent1 = getParent(edge1);
        int parent2 = getParent(edge2);
        System.out.println(parent1+" "+parent2);
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
