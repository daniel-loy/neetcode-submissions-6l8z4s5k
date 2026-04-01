class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
	HashSet<String> set = new HashSet<>();
	set.add("+");
	set.add("-");
  	set.add("/");
	set.add("*");
	for(int i=0;i<tokens.length;i++){
		String c = tokens[i];
		if(set.contains(c)){
			int num1 = stk.pop();
			int num2 = stk.pop();
			int ans = 0;
			switch(c){
			  case "+": ans = num2+num1; break;
			  case "-": ans = num2-num1; break;
			  case "/": ans = (int) num2/num1; break;
			  case "*": ans = num2*num1; break;

			}
			stk.push(ans);
		}
		else{
			stk.push(Integer.parseInt(c));
		}
	}
    return stk.pop();
    }
}