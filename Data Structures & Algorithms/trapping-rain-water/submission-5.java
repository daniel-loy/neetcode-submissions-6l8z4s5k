class Solution {
    public int trap(int[] height) {
        int maxwater = 0;
        int left =0;
        int right = height.length-1;
        int leftmax = height[left];
        int rightmax = height[right];

        while(left<right)
        {
            if(leftmax<rightmax){
                if(leftmax<height[left])
                {
                    leftmax = height[left];
                }
                else{
                    maxwater+=leftmax-height[left];
                                    left++;

                }
                //System.out.println("maxwater "+maxwater+" left index :"+left+" value :"+height[left]);
            }
            else{
                if(rightmax<height[right])
                {
                    rightmax = height[right];
                }
                else{
                    maxwater+=rightmax-height[right];
                                    right--; 

                }
                    //System.out.println("maxwater "+maxwater+" right index :"+right+" value :"+height[right]);

            }
        }
        return maxwater;
    }
}
