class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }

        int prev1 = 1;
        int prev2 = 1;

        for(int i=1;i<s.length();i++){
            int current = 0;
            int currentchar = s.charAt(i)-'0';
            int previouschar = (s.charAt(i-1)-'0')*10+currentchar;
            if(currentchar != 0){
                current+=prev1;
            }
            if(previouschar>9 && previouschar<27){
                current+=prev2;
            }
            prev2 = prev1;
            prev1 = current;
            
        }

        return prev1;
    }
}
