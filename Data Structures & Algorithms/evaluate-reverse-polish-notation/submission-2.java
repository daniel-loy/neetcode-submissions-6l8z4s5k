class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String c:tokens){
            if(c.matches("-?\\d+")){
                stack.push(Integer.parseInt(c));
            }

            if(c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/")){
                int a=stack.pop();
                int b=stack.pop();

                System.out.println(a+" "+b);
                if(c.equals("+")){
                    stack.push(a+b);
                }
                else if(c.equals("-")){
                    stack.push(b-a);
                }
                else if(c.equals("*")){
                    stack.push(a*b);
                }
                else if(c.equals("/")){
                    stack.push(b/a);
                }
            }
        }
        return stack.peek();
    }
}
