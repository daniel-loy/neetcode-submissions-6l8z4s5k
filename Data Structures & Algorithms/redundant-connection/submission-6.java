class Solution {
    int[] status;
    int[] result = new int[2];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;

        status = new int[n];
        int unique = 0;
        for(int i=0;i<n;i++){
            status[i]=  i;
        }
        
            for(int[] num : edges){
                findCycle(num[0],num[1]);
            }

        return result;
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


    public void findCycle(int edge1,int edge2){
        int parent1 = getParent(edge1);
        int parent2 = getParent(edge2);
        System.out.println(parent1+" "+parent2);
        if(parent1 == parent2){
            result[0]=edge1;
            result[1]=edge2;
        }
        else{
            status[parent1] = parent2;
        }

        // return false;
    }
}
