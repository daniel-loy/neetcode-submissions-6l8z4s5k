class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas = 0;
        int totalcost = 0;
        int temp = 0;
        int startindex =0;
         for(int i=0;i<gas.length;i++){
            totalgas +=gas[i];
            totalcost += cost[i];
            temp += gas[i]-cost[i];
            if(temp<0){
                temp=0;
                startindex = i+1;
            }
         }

         if(totalgas<totalcost){
            return -1;
         }
         else{
            return startindex;
         }
        
    }
}
