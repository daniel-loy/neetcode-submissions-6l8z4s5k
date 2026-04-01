class Solution {
            int length=0;
    public int countSubstrings(String s) {
        if(s == null || s.length() < 1){
            return 0;
        }
        int Right=0;
        int Left=0;
        for(int i=0;i<s.length();i++){
            int len1 = checkpalindrome(i,i,s);
            int len2=checkpalindrome(i,i+1,s);            
        }
        return length;  
    }
    public int checkpalindrome(int left,int right,String s){
        int L=left;
        int R=right;
        while(L>=0 && R<s.length() && s.charAt(L)==s.charAt(R)){
            length++;
            L--;
            R++;
        }
        return R-L-1;
    }
}
