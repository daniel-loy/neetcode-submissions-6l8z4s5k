class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int ans = 0;
        PriorityQueue<Integer> pri = new PriorityQueue<>((a,b)->position[b]-position[a]);
        for(int i=0;i<position.length;i++){
            pri.add(i);
        }
        double max=(double)(target-position[pri.peek()])/speed[pri.peek()];
        ans +=1;
                System.out.println(max+" "+" "+ans);
        pri.poll();
        while(!pri.isEmpty()){
           if(max<(double)(target-position[pri.peek()])/speed[pri.peek()])
            {
                ans+=1;
                max=(double)(target-position[pri.peek()])/speed[pri.peek()];
            }
            pri.poll();
        }
        return ans;
    }
}