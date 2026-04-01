class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) - '0'==0){
            return 0;
        }
        int prev1 = 1;
        int prev2 = 1;
        for(int i=1;i<s.length();i++){
            int current=0;
            if(s.charAt(i)-'0'>0){
                current=prev2;
            }
            int num = ((s.charAt(i-1)-'0')*10)+(s.charAt(i)-'0');
            if(num>=10 && num<=26){
                current+=prev1;
            }
            prev1=prev2;
            prev2=current;
        }
        return prev2;
    }
}
