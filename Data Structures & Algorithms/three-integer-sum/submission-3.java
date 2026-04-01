class Solution {
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);
       for(int i=0;i<nums.length && nums[i]<=0;i++){
        if(i==0 || nums[i]!=nums[i-1]){
            Calthreesum(i,nums);
        }
       } 
       return list;
    }
    public void Calthreesum(int i,int[] nums){
        int j=i+1;
        int k=nums.length-1;
        while(j<k){
        if(nums[j]+nums[k]+nums[i]<0){
            j++;
        }
        else if(nums[j]+nums[k]+nums[i]>0){
            k--;
        }
        else{
            list.add(Arrays.asList(nums[i],nums[j],nums[k]));
            System.out.println(list);
            j++;
            k--;
            // while(j<k && nums[j]==nums[j-1]){
            //     j++;
            // }
            while(j<k && nums[k]==nums[k+1]){
                k--;
            }
        }
        }
    }
}
