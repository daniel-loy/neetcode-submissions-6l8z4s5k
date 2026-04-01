class Solution {
    public int trap(int[] height) {
        int left = 0;
	int leftmax=0;
	int rightmax=0;
	int count=0;
	int right = height.length-1;
	while(left<right){
	   while(left<right && height[left]<=height[right]){
		   leftmax = Math.max(height[left],leftmax);
			
		   count += leftmax-height[left];
		   left++;
	   }
	   while(left<right && height[right]<=height[left]){
		rightmax = Math.max(height[right],rightmax);
		count += rightmax-height[right];
		right--;

	}

	}
    return count;

    }
}