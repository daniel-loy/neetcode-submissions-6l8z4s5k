class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int n = nums1.length;
        int m = nums2.length;
        int start = 0;
        int end = n;
        int x = (n+m+1)/2;  
        while(start<=end){
            int partX = (end+start)/2;
            int partY = x-partX;
            int xleft = partX == 0 ?Integer.MIN_VALUE: nums1[partX-1];
            int xright = partX == n ?Integer.MAX_VALUE: nums1[partX];
            int yleft = partY == 0 ?Integer.MIN_VALUE: nums2[partY-1];
            int yright = partY == m ?Integer.MAX_VALUE: nums2[partY];

            if(xleft<=yright && yleft<=xright){
                if((n+m)%2 == 0){
                    return  ((double) Math.max(xleft,yleft)+Math.min(xright,yright))/2;
                }
                else{
                    return Math.max(xleft,yleft);
                }
            }

            if(xleft > yright){
                end = partX-1;
            }
            else{
                start = partX+1;
            }

        }
        return 0;
    }
}
