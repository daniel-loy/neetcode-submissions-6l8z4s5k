
class Solution {

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        HashMap<Integer, List<Points>> map = new HashMap<>();

        for (int[] flight : flights) {
            map.computeIfAbsent(flight[0], x -> new ArrayList<>())
               .add(new Points(flight[1], flight[2]));
        }

        PriorityQueue<int[]> pri = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        int[][] dist = new int[n][k + 2];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[src][0] = 0;

        // {city, cost, flightsTaken}
        pri.offer(new int[]{src, 0, 0});

        while (!pri.isEmpty()) {

            int[] node = pri.poll();

            int currentnode = node[0];
            int currentscore = node[1];
            int pathlength = node[2];

            // Ignore outdated entries
            if (currentscore != dist[currentnode][pathlength]) {
                continue;
            }

            if (currentnode == dst) {
                return currentscore;
            }

            if (pathlength == k + 1) {
                continue;
            }

            for (Points point : map.getOrDefault(
                    currentnode, new ArrayList<>())) {

                int newCost = currentscore + point.value;
                int newFlights = pathlength + 1;

                if (newCost < dist[point.key][newFlights]) {

                    dist[point.key][newFlights] = newCost;

                    pri.offer(new int[]{
                        point.key,
                        newCost,
                        newFlights
                    });
                }
            }
        }

        return -1;
    }

    public class Points {
        int key;
        int value;

        public Points(int k, int v) {
            key = k;
            value = v;
        }
    }
}