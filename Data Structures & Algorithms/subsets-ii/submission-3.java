class Solution {
    List<List<Integer>> resultlist = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
                dfs(nums,new ArrayList<>(),0);
        	return resultlist;
    }

   public void dfs(int[] nums,List<Integer> list,int index){

        resultlist.add(List.copyOf(list));

	int start = index;
	int end = nums.length;
	while(start<end){
        list.add(nums[start]);
        dfs(nums,list,start+1);
        list.remove(list.size()-1);
	    int current = nums[start];
	    start++;
	    while(start<nums.length && current==nums[start]){
		    start++;
	    }
	}
        }
    }