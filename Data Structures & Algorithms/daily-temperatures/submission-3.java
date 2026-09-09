class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] num = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<num.length;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()])
            {
                num[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return num;
    }
}
