class Solution {
    public int trap(int[] height) {
        int i=0;
        int j=height.length-1;
        int maxwater=0;
        int leftmax=0;
        int rightmax=0;
        while(i<j){
            if(height[i]<height[j]){
                if(height[i]<leftmax){
                maxwater+=leftmax-height[i];
                i++;
                }
                else{
                leftmax=height[i];
                i++;
                }
            }
            else
            {
            if(height[j]<rightmax){
                maxwater+=rightmax-height[j];
                j--;
            }
            else{
                rightmax=height[j]; 
                j--; 
                }
            }
    }
    return maxwater;
}
}
