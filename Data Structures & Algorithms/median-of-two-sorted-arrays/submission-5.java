class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
         int n = (nums1.length+nums2.length+1)/2;
         int left = 0;
         int right = nums1.length;
        while(left<=right){
            int partA = (left+right)/2;
            int partB = n-partA;
            int leftA = partA == 0?Integer.MIN_VALUE:nums1[partA-1];
            int leftB = partA == nums1.length ? Integer.MAX_VALUE:nums1[partA];
            int rightA = partB == 0?Integer.MIN_VALUE:nums2[partB-1];
            int rightB = partB == nums2.length ? Integer.MAX_VALUE:nums2[partB];
            System.out.println((leftA)+" "+leftB+"\n"+(rightA)+" "+(rightB));

            if(leftA<=rightB && rightA<=leftB){
                if((nums1.length+nums2.length)%2 != 0){
                    return Math.max(leftA,rightA);
                }
                else{
                    return ((float)(Math.max(leftA,rightA)+Math.min(leftB,rightB)))/2;
                }
            }

            if(leftA>rightB){
                right = partA-1;
            }
            else{
                left=partA+1;
            }
        }
        return 0;
    }
}
