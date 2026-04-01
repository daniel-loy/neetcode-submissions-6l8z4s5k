class Solution {
    List<List<Integer>> resultlist = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new ArrayList<>());
        return resultlist;
    }

    public void dfs(int[] nums,int index,List<Integer> list){
        resultlist.add(new ArrayList<>(list));

        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            dfs(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }
}
