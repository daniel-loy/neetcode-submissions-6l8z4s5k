class Solution {
    List<List<Integer>> resultlist = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
                dfs(candidates,target,new ArrayList<>(),0,0);
        	return resultlist;
    }

   public void dfs(int[] nums,int target,List<Integer> list,int sum,int index){

        if(sum==target){
            resultlist.add(List.copyOf(list));
            return;     
        }

        if(sum>target){
            return;
        }
	int start = index;
	int end = nums.length;
	while(start<end){
        list.add(nums[start]);
        dfs(nums,target,list,sum+nums[start],start+1);
        list.remove(list.size()-1);
	    int current = nums[start];
	    start++;
	    while(start<nums.length && current==nums[start]){
		    start++;
	    }
	}
        }
    }

