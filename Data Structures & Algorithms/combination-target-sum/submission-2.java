class Solution {

    List<List<Integer>> resultlist = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums,target,new ArrayList<>(),0,0);
        return resultlist;
    }

    public void dfs(int[] nums,int target,List<Integer> list,int sum,int start){

        if(sum==target){
            resultlist.add(List.copyOf(list));
            return;     
        }

        if(sum>target){
            return;
        }


        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            dfs(nums,target,list,sum+nums[i],i);
            list.remove(list.size()-1);
        }
    }
}
