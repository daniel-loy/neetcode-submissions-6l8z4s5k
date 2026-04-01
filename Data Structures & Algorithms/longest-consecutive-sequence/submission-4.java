class Solution {
    public int longestConsecutive(int[] nums) {
      HashSet<Integer> set = new HashSet<>();

      if(nums.length==0){
        return 0;
      }
       for(int num : nums){
        set.add(num);
       }
        int Max=0;
       for(int num : nums){
        if(set.contains(num-1)){
            continue;
        }
        else{
            int currnum=num;
            int prev=1;
            while(set.contains(currnum+1)){
                currnum++;
                prev++; 
            }

            Max=Math.max(Max,prev);
        }
       }
       return Max;
    }
}
