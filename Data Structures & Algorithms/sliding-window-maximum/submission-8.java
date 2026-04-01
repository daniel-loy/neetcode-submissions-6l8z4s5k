class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dequeue = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            while(!dequeue.isEmpty() && nums[dequeue.peekLast()]<nums[i]){
                dequeue.removeLast();
            }
            dequeue.addLast(i);
        }
        int n=0;
        result[n++]=nums[dequeue.peek()];
        for(int i=k;i<nums.length;i++){
            int currentwindow = i-k+1;
            if(dequeue.size()==k || dequeue.peek()<currentwindow){
                while(!dequeue.isEmpty() && dequeue.peek()<currentwindow){
                    dequeue.removeFirst();
                }
            }
            while(!dequeue.isEmpty() && nums[dequeue.peekLast()]<nums[i]){
                dequeue.removeLast();
            }
            dequeue.addLast(i);
            result[n++]=nums[dequeue.peek()];
        }
        return result;
    }
}
