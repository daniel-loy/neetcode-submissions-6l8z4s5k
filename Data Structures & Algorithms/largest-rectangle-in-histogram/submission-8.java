class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() &&
                   heights[stack.peek()] > heights[i]) {

                int popped = stack.pop();

                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                max = Math.max(max, heights[popped] * width);
            }

            stack.push(i);
        }

        // Process remaining elements
        while (!stack.isEmpty()) {

            int popped = stack.pop();

            int width;
            if (stack.isEmpty()) {
                width = heights.length;
            } else {
                width = heights.length - stack.peek() - 1;
            }

            max = Math.max(max, heights[popped] * width);
        }

        return max;
    }
}
