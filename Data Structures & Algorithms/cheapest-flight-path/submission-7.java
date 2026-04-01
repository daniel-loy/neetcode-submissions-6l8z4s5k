class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            PriorityQueue<Point> queue = new PriorityQueue<>((a,b)->a.price-b.price);
            HashMap<Integer,List<Point>> map = new HashMap<>();

            for(int[] flight : flights){
               if(!map.containsKey(flight[0])){
                map.put(flight[0],new ArrayList<>());
               }

            if(!map.containsKey(flight[1])){
                map.put(flight[1],new ArrayList<>());
               }
            }

            for(int[] flight : flights){
                List<Point> list = map.get(flight[0]);
                list.add(new Point(flight[1],flight[2],0));
            }

            queue.add(new Point(src,0,0));

            while(!queue.isEmpty()){
                Point poped = queue.poll();

                int price = poped.price;
                int node = poped.currentsrc;
                int nodenumber = poped.node;

                if(node == dst){
                    return price;
                }

                if(nodenumber > k){
                    continue;
                }

                for(Point p : map.get(node)){
                    queue.add(new Point(p.currentsrc,p.price+price,nodenumber+1));
                }

            }

            return -1;
    }

    public class Point {
        int currentsrc;
        int price;
        int node;

        Point(int cur,int p,int n){
            currentsrc = cur;
            price = p;
            node = n;
        }
    }
}
