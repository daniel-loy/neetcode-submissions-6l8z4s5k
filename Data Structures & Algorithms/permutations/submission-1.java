class Solution {
    List<List<Integer>> resultlist = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums,new ArrayList<>(),new HashSet<>());
        return resultlist;
    }

    public void dfs(int[] nums,List<Integer> list,HashSet<Integer> set){
	if(set.size() == nums.length){
        resultlist.add(List.copyOf(list));
    }
    for(int i=0;i<nums.length;i++){
		if(!set.contains(nums[i])){
	      	set.add(nums[i]);
		    list.add(nums[i]);
		    dfs(nums,list,set);
		    int lastElement = list.remove(list.size() - 1);
		    set.remove(lastElement);
		}	       
	}
}
}