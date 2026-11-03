class Solution {
    public int swimInWater(int[][] grid) {

        int n = grid.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[n][n];

        pq.add(new int[]{0,0,grid[0][0]});

        int[] row = {-1,0,1,0};
        int[] col = {0,1,0,-1};

        while(!pq.isEmpty()){

            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int time = cur[2];

            if(r == n-1 && c == n-1)
                return time;

            if(visited[r][c]) continue;
            visited[r][c] = true;

            for(int i=0;i<4;i++){

                int nr = r + row[i];
                int nc = c + col[i];

                if(nr<0 || nc<0 || nr>=n || nc>=n || visited[nr][nc])
                    continue;

                pq.add(new int[]{nr,nc, Math.max(time, grid[nr][nc])});
            }
        }

        return -1;
    }
}