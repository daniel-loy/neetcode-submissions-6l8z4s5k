class Solution {
    public boolean checkValidString(String s) {
        int minop = 0;
        int maxop = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                minop++;
                maxop++;
            }
            else if(s.charAt(i)==')'){
                minop--;
                maxop--;
            }
            else{
                maxop++;
                minop--;
            }
            if(maxop<0){
                return false;
            }
            minop = Math.max(minop,0);
        }

        return minop==0;
    }
}
