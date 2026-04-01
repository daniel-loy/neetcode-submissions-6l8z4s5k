class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }
        int maxcount = Integer.MAX_VALUE;
        int index = Integer.MAX_VALUE;
        int i = 1;
        int j = max;
        while(i<=j){    

          int mid = (i+j)/2;
          int count = calminhour(mid,piles);
          if(count <= h){
            j=mid-1;
           }
           else{
            i=mid+1;
           }  
        }
        return i;
    }

    public int calminhour(int j,int[] piles){
        int count = 0;
        for(int i=0;i<piles.length;i++){
          int a = piles[i];
          int reminder = (a%j)>0?1:0;
          count +=(a/j)+reminder;
        }

        return count;
    }
}
