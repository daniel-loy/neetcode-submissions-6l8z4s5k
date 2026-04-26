class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        int[] current = new int[3];

        for (int i = 0; i < triplets.length; i++) {

            // Skip invalid triplets
            if (triplets[i][0] > target[0] ||
                triplets[i][1] > target[1] ||
                triplets[i][2] > target[2]) {
                continue;
            }

            current[0] = Math.max(current[0], triplets[i][0]);
            current[1] = Math.max(current[1], triplets[i][1]);
            current[2] = Math.max(current[2], triplets[i][2]);
        }

        return current[0] == target[0] &&
               current[1] == target[1] &&
               current[2] == target[2];
    }
}