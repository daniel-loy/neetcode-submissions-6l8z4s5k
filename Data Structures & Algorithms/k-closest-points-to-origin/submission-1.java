
class Solution {

    public int[][] kClosest(int[][] points, int k) {
        // Max-heap: largest distance at the top
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0] + a[1]*a[1])
        );

        for (int i = 0; i < points.length; i++) {
            if (heap.size() < k) {
                heap.offer(points[i]);
            } 
            else if(points[i][0]*points[i][0] + points[i][1]*points[i][1] < heap.peek()[0]*heap.peek()[0] + heap.peek()[1]*heap.peek()[1]) {
                    heap.poll();        // remove farthest
                    heap.offer(points[i]); // add closer point   
            
        }
        }

        // Convert heap to array
        int[][] result = new int[heap.size()][2];
        int index = 0;
        while (!heap.isEmpty()) {
            result[index++] = heap.poll();
        }

    
            return result;

}
}
