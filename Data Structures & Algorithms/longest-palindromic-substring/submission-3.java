class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        int Right=0;
        int Left=0;
        for(int i=0;i<s.length();i++){
            int len1 = checkpalindrome(i,i,s);
            int len2=checkpalindrome(i,i+1,s);
            int maxlen = Math.max(len1,len2);
            if((Right-Left+1)<maxlen){
                System.out.println(maxlen);
                Left = i-(maxlen-1)/2;
                Right = i+maxlen/2;

            }
        }
        return s.substring(Left,Right+1);
    }

    public int checkpalindrome(int left,int right,String s){
        int L=left;
        int R=right;
        while(L>=0 && R<s.length() && s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
}
