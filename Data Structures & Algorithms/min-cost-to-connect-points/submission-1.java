class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pri = new PriorityQueue<>((a,b)->a[2]-b[2]);

        boolean[] visited = new boolean[points.length];

        pri.add(new int[]{points[0][0],points[0][1],0,0});
        int result = 0;
        while(!pri.isEmpty()){
            int[] popedpoint = pri.poll();
            int point1 = popedpoint[0];
            int point2 = popedpoint[1];
            int point3 = popedpoint[2];
            int index = popedpoint[3];
            if(visited[index]){
                continue;
            }
            result += point3;
            visited[index]=true;
            for(int i=0;i<points.length;i++){
                if(!visited[i]){
                    int weight = Math.abs(point1 - points[i][0]) + Math.abs(point2 - points[i][1]);
                    pri.add(new int[]{points[i][0],points[i][1],weight,i});        
                    }
            }

        }
        return result;


    }
}
