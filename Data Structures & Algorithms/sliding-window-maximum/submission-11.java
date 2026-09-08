class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pri = new PriorityQueue<>((a,b)->Integer.compare(nums[b],nums[a]));

        int[] result = new int[nums.length-k+1];
        
        int right = k-1;

        for(int i=0;i<k;i++){
            pri.add(i);
        }

        result[0]=nums[pri.peek()];

        for(int i=1;i<nums.length-k+1;i++){
            while(!pri.isEmpty() && pri.peek()<i){
                int num = pri.poll();
            }
            right++;
            pri.add(right);
            result[i]=nums[pri.peek()];
        }

        return result;

    }
}
