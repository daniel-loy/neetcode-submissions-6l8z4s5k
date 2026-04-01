
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Graph: city -> list of (next city, price)
        HashMap<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();

        for (int[] arr : flights) {
            map.computeIfAbsent(arr[0], key -> new ArrayList<>())
                .add(new Pair<>(arr[1], arr[2]));
        }

        // Min-heap: (current city, total cost so far, stops used)
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> a.get(1) - b.get(1));
        queue.offer(Arrays.asList(src, 0, 0));

        while (!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            int city = list.get(0);
            int cost = list.get(1);
            int stops = list.get(2);

            if (city == dst) {
                return cost; // Found the cheapest route
            }

            if (stops > k) continue; // Exceeded stop limit

            if (map.containsKey(city)) {
                for (Pair<Integer, Integer> pr : map.get(city)) {
                    queue.offer(Arrays.asList(pr.getKey(), cost + pr.getValue(), stops + 1));
                }
            }
        }

        return -1; // No path found
    }
}
