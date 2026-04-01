class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c== '{' || c == '['){
                stk.push(c);
            }
            else{
                if(stk.isEmpty()){
                    return false;
                }
                char poped = stk.pop();
                if((poped == '(' && c!=')') || (poped == '{' && c != '}') || (poped == '[' && c != ']')){
                    return false;
                }
            }
        }
        if(!stk.isEmpty()){
            return false;
        }
        return true;
    }
}
