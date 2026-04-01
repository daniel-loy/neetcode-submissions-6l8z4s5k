class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>  deq = new LinkedList<>();
        int i=0;
        int[] arr=new int[nums.length-k+1];
    
        for(i=0;i<nums.length;i++){
            while(!deq.isEmpty() && deq.peek() < i-k+1){
                deq.poll();
            }

            while(!deq.isEmpty() && nums[deq.peekLast()]<nums[i]){
                deq.pollLast();
            }
            deq.offer(i);

            if(i>=k-1){
                arr[i-k+1]=nums[deq.peek()];
            }
        }
        return arr;
    }
}
