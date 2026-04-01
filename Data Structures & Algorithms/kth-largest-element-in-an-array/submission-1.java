class Solution {
    PriorityQueue<Integer> pri = new PriorityQueue<>();
    public int findKthLargest(int[] nums, int k) {
        for(int num :nums){
            if(pri.size() == k){
                if(pri.peek()<num){
                    pri.poll();
                    pri.add(num);
                }
            }
            else{
                pri.add(num);
            }
        }

        return pri.peek();
    }
}
