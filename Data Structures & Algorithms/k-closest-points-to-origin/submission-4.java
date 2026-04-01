class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Point> pri =
            new PriorityQueue<>((a, b) -> Double.compare(b.v, a.v));

        for (int i = 0; i < points.length; i++) {
            double dist = Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2);
            pri.add(new Point(i, dist));
            if(pri.size()>k){
                pri.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point p = pri.poll();
            result[i] = points[p.k];
        }

        return result;
    }

    public class Point {
        int k;
        double v;

        Point(int key, double val) {
            k = key;
            v = val;
        }
    }
}
