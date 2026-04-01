class Solution {
    public int trap(int[] height) {
        int left = 0;
	int right = height.length-1;
	int leftmax = Integer.MIN_VALUE;
	int rightmax = Integer.MIN_VALUE;
	int max = 0;
	while(left<right){
	    
		if(height[left]<height[right]){
			leftmax = Math.max(leftmax,height[left]);
			max += leftmax - height[left];
			left++;
		}
		else{
			rightmax = Math.max(rightmax,height[right]);
			max += rightmax - height[right];
			right--;
		}

	}
	
	return max;
    }
}