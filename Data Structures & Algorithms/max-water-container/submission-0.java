class Solution {
    public int maxArea(int[] heights) {
        int Max = 0;
        int LeftMax=0;
        int RightMax=0;
        int i=0;
        int j=heights.length-1;
        while(i<j){
          if(heights[i]<heights[j]){
            if((heights[i]*(j-i))>Max){
                 Max=heights[i]*(j-i);
            }
            i++;   
          }
          else{
            if((heights[j]*(j-i))>Max){
                Max=heights[j]*(j-i);
            }
            j--; 
          }
        }
        return Max;
    }
}
