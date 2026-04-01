class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();

        int[] arr = new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++){
            if(!stack.isEmpty()){

            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()])
            {
                arr[stack.peek()]=i-stack.peek();
                stack.pop();
            }

            }

            stack.push(i);
        }
        return arr;
    }
}
