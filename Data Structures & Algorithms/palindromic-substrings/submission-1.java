class Solution {
    int totalcount = 0;
    public int countSubstrings(String s) {
           for(int i=0; i<s.length(); i++){
            int len1 = checkPalindrome(s, i, i);
            int len2 = checkPalindrome(s, i, i+1);
           }
           return totalcount;
    }

        public int checkPalindrome(String s, int left, int right){
        
        int L = left, R = right;
        
        while(L >=0 && R<s.length() && s.charAt(L) == s.charAt(R)){
            totalcount++;
            L--;
            R++;
            
            
        }
        
        return R-L-1;
        
        
    }
}
