class Solution {
    public int jump(int[] nums) {
        int maxindexreachable = 0;
        int[] arr = new int[nums.length];
        arr[0]=0;
        if(nums.length==1){
            return 0;
        }
        for(int i=0;i<nums.length-1;i++){

            int maxindex = nums[i]+i;

            if(arr[i]==0 && i!=0){
                arr[i]=arr[i-1]+1;
            }

            if(maxindex >= nums.length-1){
                return arr[i]+1;
            }

            if(maxindex > maxindexreachable){
                arr[maxindex]=arr[i]+1;
                maxindexreachable = maxindex;
            }
        }

        return arr[nums.length-1]; 
    }
}
