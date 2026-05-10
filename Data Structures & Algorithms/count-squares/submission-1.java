class CountSquares {
    Map<String, Integer> map;
    List<int[]> points;
    public CountSquares() {
        map = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        String key = x + "," + y;

        map.put(key, map.getOrDefault(key, 0) + 1);

        points.add(point);
    }
    
    public int count(int[] point) {
                int x1 = point[0];
        int y1 = point[1];

        int result = 0;

        for(int[] p : points) {

            int x2 = p[0];
            int y2 = p[1];

            // skip invalid diagonals
            if(Math.abs(x1 - x2) != Math.abs(y1 - y2)
                    || x1 == x2
                    || y1 == y2) {
                continue;
            }

            // other two corners
            String point1 = x1 + "," + y2;
            String point2 = x2 + "," + y1;

            result +=
                    map.getOrDefault(point1, 0) *
                    map.getOrDefault(point2, 0);
        }

        return result;
    
    }
}
