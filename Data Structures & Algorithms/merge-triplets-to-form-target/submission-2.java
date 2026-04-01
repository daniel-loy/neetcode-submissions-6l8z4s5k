class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        for(int i=0;i<triplets.length-1;i++){
            if(triplets[i][0]>target[0] || triplets[i][1]>target[1] || triplets[i][2]>target[2]){
                continue;
            }
            triplets[i+1][0] = Math.max(triplets[i][0],triplets[i+1][0]);
            triplets[i+1][1] = Math.max(triplets[i][1],triplets[i+1][1]);
            triplets[i+1][2] = Math.max(triplets[i][2],triplets[i+1][2]);
            if(triplets[i+1][0]>target[0] || triplets[i+1][1]>target[1] || triplets[i+1][2]>target[2]){
                triplets[i+1][0] = triplets[i][0];
                triplets[i+1][1] = triplets[i][1];
                triplets[i+1][2] =  triplets[i][2];
            }

        }

        if(triplets[triplets.length-1][0]==target[0] && triplets[triplets.length-1][1]==target[1] && triplets[triplets.length-1][2]==target[2]){
            return true;
        }
        else{
            return false;
        }
    }

}
