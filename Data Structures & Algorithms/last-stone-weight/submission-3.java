class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pri = new PriorityQueue<>((a,b)->b-a);
        for(int stone : stones){
            pri.add(stone);
        }

        while(pri.size()>1){
            int a = pri.poll();
            int b = pri.poll();
            if(a!=b){
                pri.add(a-b);
            }
        }
        return pri.size()==0?0 : pri.peek();
    }
}
