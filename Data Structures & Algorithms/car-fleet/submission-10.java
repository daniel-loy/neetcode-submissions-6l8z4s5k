class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int result = 0;

	Integer[] indeices = new Integer[position.length];
	
	for(int i=0;i<position.length;i++){
		indeices[i]=i;
	}

	Arrays.sort(indeices,(i,j)->Integer.compare(position[i],position[j]));

	Stack<Double> stack = new Stack<>();
	
	for(int i=0;i<speed.length;i++){
		double time = (double) (target-position[indeices[i]])/speed[indeices[i]];
                System.out.println(target-position[indeices[i]]+" "+speed[indeices[i]]);

		stack.push(time);

	}
		double top = stack.pop();
		result = 1;
	while(!stack.isEmpty()){

		if(stack.peek()<=top){
			stack.pop();
		}
		else{
			result++;
			top = stack.pop();
		}
	}
	return result;
    }
}