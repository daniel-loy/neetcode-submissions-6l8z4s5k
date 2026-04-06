class Solution {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;

        for(int i=0;i<s.length();i++){
            int evensubset = checkforpalindrome(s,i,i+1);
            int oddsubset = checkforpalindrome(s,i,i);
            int len = Math.max(evensubset,oddsubset);
            System.out.println(len);

            if(len > right-left){
                left = i-((len-1)/2);
                right = (len/2)+i;
            }

        }

        return s.substring(left,right+1);
    }

    public int checkforpalindrome(String s,int left,int right){
        int r = right;
        int l = left;

        while(r<s.length() && l>=0 && s.charAt(r) == s.charAt(l)){
            r++;
            l--;
        }
        // System.out.println(" right : "+right+" left : "+left+" r : "+r+" l : "+l+" r-l-1 "+(r-l-1));
        return r-l-1;
    }
}
