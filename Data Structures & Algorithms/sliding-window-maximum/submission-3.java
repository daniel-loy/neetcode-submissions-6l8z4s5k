class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> Pri = new PriorityQueue<>((a, b) -> b - a);   
        ArrayList<Integer> arr = new ArrayList<>();
        int j=0;
        for(int i=0;i<k;i++){
            Pri.add(nums[i]);
        }  
        arr.add(Pri.peek());
        Pri.remove(nums[j]);
        j++;
        for(int i=k;i<nums.length;i++){
               Pri.add(nums[i]);
               arr.add(Pri.peek());
               Pri.remove(nums[j]);
               j++;
        }
        int[] arrs = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            arrs[i] = arr.get(i);
        }
        return arrs;
    }
}
