class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        boolean[] visited = new boolean[n+1];
        HashMap<Integer,List<Point>> map= new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] arr : times){
            List<Point> point = map.get(arr[0]);
            point.add(new Point(arr[1],arr[2]));
            map.put(arr[0],point);
        }
        PriorityQueue<Point> pri = new PriorityQueue<>((a,b)->a.val-b.val);

        pri.add(new Point(k,0));
        int lastpoped = 0;
        while(!pri.isEmpty()){
            Point poped = pri.poll();
            if(visited[poped.key]){
                continue;
            }
            visited[poped.key] = true;
            System.out.println(poped.key+" "+poped.val);
            for(Point neighbor : map.get(poped.key)){
                if(!visited[neighbor.key]){
                    pri.offer(new Point(neighbor.key,neighbor.val+poped.val));
                }
            }

            lastpoped = poped.val;
        }

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                return -1;
            }
        }
        return lastpoped;
    }

    public class Point{
        int key;
        int val;

        public Point(int k,int v){
            key = k;
            val = v;
        }
    }
}
