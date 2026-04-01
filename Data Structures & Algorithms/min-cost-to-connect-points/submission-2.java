class Solution {
    public int minCostConnectPoints(int[][] points) {

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        // {cost, index}

        boolean[] visited = new boolean[points.length];

        pq.add(new int[]{0, 0}); // start from point 0
        int result = 0;
        int count = 0;

        while (!pq.isEmpty() && count < points.length) {

            int[] curr = pq.poll();
            int cost = curr[0];
            int index = curr[1];

            if (visited[index]) continue;

            visited[index] = true;
            result += cost;
            count++;

            for (int i = 0; i < points.length; i++) {
                if (!visited[i]) {
                    int weight =
                        Math.abs(points[index][0] - points[i][0]) +
                        Math.abs(points[index][1] - points[i][1]);

                    pq.add(new int[]{weight, i});
                }
            }
        }

        return result;
    }
}