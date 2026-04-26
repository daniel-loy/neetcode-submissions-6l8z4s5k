class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
     int gassum = 0;
     int costsum = 0;

     for(int num:gas){
        gassum+=num;
     }   

     for(int num:cost){
        costsum+=num;
     }

     if(gassum<costsum){
        return -1;
     }

    int max = 0;
    int index = 0;

    for(int i=0;i<cost.length;i++){
        max += gas[i]-cost[i];
        if(max<0){
            index = i+1;
            max=0;
        }
    }
    return index;
    }
}
