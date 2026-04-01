class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int row = 0, col = 0, dir = 0;

        List<Integer> list = new ArrayList<>();
        int total = m * n;

        list.add(matrix[0][0]);
        matrix[0][0] = 1000;

        while (list.size() < total) {
            int nr = row + dr[dir];
            int nc = col + dc[dir];

            // if out of bounds or visited → change direction
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || matrix[nr][nc] == 1000) {
                dir = (dir + 1) % 4;  // rotate direction
                continue;
            }

            row = nr;
            col = nc;
            list.add(matrix[row][col]);
            matrix[row][col] = 1000;
        }

        return list;
    }
}
