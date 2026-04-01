class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];       // global max
        int currMax = nums[0];       // local max (ending at i)
        int currMin = nums[0];       // local min (ending at i)

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            
            // if negative, swap — because min can become max
            if (n < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            // update local max and min
            currMax = Math.max(n, currMax * n);
            currMin = Math.min(n, currMin * n);

            // update global
            maxProd = Math.max(maxProd, currMax);

            System.out.println("i=" + i + " → currMax=" + currMax + " currMin=" + currMin + " maxProd=" + maxProd);
        }

        return maxProd;
    }
}
