class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stk = new Stack<>();
	int[] result = new int[temperatures.length];
	for(int i=0;i<temperatures.length;i++)
	{
	   	while(!stk.isEmpty() && temperatures[stk.peek()]<temperatures[i]){
		result[stk.peek()] = i-stk.peek();
		stk.pop();
		}
		stk.push(i);
	}
	return result;

    }
}