class Solution {
    public int longestConsecutive(int[] nums) {
       if(nums.length==0){
        return 0;
       }
       Arrays.sort(nums);
       int Max = 0;
       int Prev = 1;
        System.out.println(Arrays.toString(nums));
       for(int i=0;i<nums.length-1;i++){
        System.out.println((nums[i+1]-1)+" "+(nums[i]-nums[i+1])+" "+Prev);
        if(nums[i]==nums[i+1]-1 || nums[i]-nums[i+1]==0){
            if(nums[i]-nums[i+1]==0){
                continue;
            }
            Prev++;
        }
        else{
            if(Prev>Max){
                Max=Prev;
            }
            Prev = 1;
        }
       }
        if(Prev>Max){
                Max=Prev;
            }
       return Max;
    }
}
