class Solution {
    public boolean canJump(int[] nums) {

       int max = nums[0];

       if(nums.length==1){
        return true;
       }

       if(max==0){

        return false;
       }

       for(int i=1;i<nums.length;i++){

        max = Math.max(max,i+nums[i]);
        
        if(i>=max && i!=nums.length-1){
            System.out.println(i+" "+max);
            return false;
        }
       }

       return true; 
    }
}
