class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] arr = new int[3];
        for(int i=0;i<triplets.length;i++){
            if(triplets[i][0]>target[0] || triplets[i][1]>target[1] || triplets[i][2]>target[2]){
                continue;
            }
            arr[0] = Math.max(triplets[i][0],arr[0]);
            arr[1] = Math.max(triplets[i][1],arr[1]);
            arr[2] = Math.max(triplets[i][2],arr[2]);
        }

        if(arr[0]==target[0] && arr[1]==target[1] && arr[2]==target[2]){
            return true;
        }
        else{
            return false;
        }
    }
}
