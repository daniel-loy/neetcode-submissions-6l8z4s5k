class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int maxarea = Integer.MIN_VALUE;
        int i=0;
        while(i<=heights.length){
            int n = i==heights.length?Integer.MIN_VALUE:heights[i];
            while(!stk.isEmpty() && heights[stk.peek()] > n){
               int poped = stk.pop();
                int width = stk.isEmpty() ? i : i - stk.peek() - 1;
               maxarea = Math.max(maxarea,width*heights[poped]);
            }
            stk.push(i);
            i++;
        }
        return maxarea;
    }
}
