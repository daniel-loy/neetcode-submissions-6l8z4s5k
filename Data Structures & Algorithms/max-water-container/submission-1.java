class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
	int right=heights.length-1;
	int max = Integer.MIN_VALUE;
	while(left<right){
	   int currentheight = Math.min(heights[left],heights[right])*(right-left);
	   max = Math.max(currentheight,max);	
		
	  if(heights[left]>heights[right]){
		right--;
	}
	else{
		left++;
	}	
	}

	return max;
    }
}

